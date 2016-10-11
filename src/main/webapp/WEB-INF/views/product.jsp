<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src = "/webstore/resource/js/angular.min.js" ></script>
	<section class="container" ng-app="cartApp">
		<div class="row">
		<div class="col-md-5">
			<img src="<c:url value="/resource/images/${product.productId}.jpg"></c:url>" alt="image" style="width:60%"/>
		</div>
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong><spring:message code="addProduct.form.productId.label"/>: </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong><spring:message code="addProduct.form.manufacturer.label"/>:</strong> ${product.manufacturer}
				</p>
				<p>
					<strong><spring:message code="addProduct.form.category.label"/>:</strong> ${product.category}
				</p>
				<p>
					<strong><spring:message code="addProduct.form.unitsInStock.label"/>:</strong> ${product.unitsInStock}
				</p>
				<p>
					<strong><spring:message code="product.condition"/>:</strong> ${product.condition}
				</p>
				<h4>${product.unitPrice} PLN</h4>
				<p ng-controller="cartCtrl">
					<a href="#" class="btn btn-warning btn-md" ng-click="addToCart('${product.productId}')"><span class="glyphicon-shopping-cart glyphicon"></span> <spring:message code="product.button.buy"/></a>
					<a href="<spring:url value="/cart" />" class="btn btn-default btn-md"><span class="glyphicon glyphicon-hand-right"></span> <spring:message code="product.button.cart"/></a>
					<a href="<spring:url value="/products" />" class="btn btn-info btn-md"><span class="glyphicon glyphicon-hand-left"></span> <spring:message code="product.button.back"/></a>
				</p>
					
			</div>
		</div>
	</section>
	<script src = "/webstore/resource/js/controller.js" ></script>
</body>
</html>