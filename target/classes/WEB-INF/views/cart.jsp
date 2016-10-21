<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8"%> 
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src = "/webstore/resource/js/angular.min.js" ></script>
	<section class="container" ng-app="cartApp">
		<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
			<div>
				<a class="btn btn-danger pull-left" ng-click="clearCart()"><span class = "glyphicon glyphicon-remove-sign"></span> <spring:message code="cart.removeAll"/></a>
				<a href="<spring:url value="/checkout?cartId=${cartId}&username=${username}"/>" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart glyphicon"></span> <spring:message code="cart.buy"/></a>
			</div>
			<table class="table table-hover">
				<tr>
					<th><spring:message code="cart.product.table"/></th>
					<th><spring:message code="cart.unitPrice.table"/></th>
					<th><spring:message code="cart.amount.table"/></th>
					<th><spring:message code="cart.price.table"/></th>
					<th><spring:message code="cart.action.table"/></th>
				</tr>	
				<tr class="warning" ng-repeat="item in cart.cartItems">
				<td><img src="<c:url value="/resource/images/{{item.product.productId}}.jpg"></c:url>" alt="image" style="width:8%"/> <mark>{{item.product.productId}}-{{item.product.name}}</mark></td>
				<td>{{item.product.unitPrice}} PLN</td>
				<td>{{item.quantity}}</td>
				<td>{{item.totalPrice}} PLN</td>
				<td>
					<a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)"><span class= "glyphicon glyphicon-remove"></span> <spring:message code="cart.delete"/></a>
				</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th><spring:message code="cart.totalPrice.table"/></th>
					<th class="danger">{{cart.grandTotal}} PLN</th>
					<th></th>
				</tr>
			</table>
			<a href="<spring:url value="/products"/>" class="btn btn-default"><span class="glyphicon-hand-left glyphicon"></span> <spring:message code="cart.button.back"/></a>
		</div>
	</section>
<script src = "/webstore/resource/js/controller.js" ></script>