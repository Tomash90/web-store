<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<script src = "/webstore/resource/js/angular.min.js" ></script>
<title>Koszyk</title>
</head>
<body>
	<section>
		<div class = "jumbotron">
			<div class = "container">
				<h1>Koszyk</h1>
			</div>
		</div>
	</section>
	<section class="container" ng-app="cartApp">
		<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
			<div>
				<a class="btn btn-danger pull-left" ng-click="clearCart()"><span class = "glyphicon glyphicon-remove-sign"></span> Wyczyść koszyk</a>
				<a href="<spring:url value="/checkout?cartId=${cartId}"/>" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart glyphicon"></span> Kupuję</a>
			</div>
			<table class="table table-hover">
				<tr>
					<th>Produkt</th>
					<th>Cena za sztukę</th>
					<th>Liczba sztuk</th>
					<th>Cena</th>
					<th>Akcja</th>
				</tr>	
				<tr class="warning" ng-repeat="item in cart.cartItems">
				<td><img src="<c:url value="/resource/images/{{item.product.productId}}.jpg"></c:url>" alt="image" style="width:8%"/> <mark>{{item.product.productId}}-{{item.product.name}}</mark></td>
				<td>{{item.product.unitPrice}} PLN</td>
				<td>{{item.quantity}}</td>
				<td>{{item.totalPrice}} PLN</td>
				<td>
					<a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)"><span class= "glyphicon glyphicon-remove"></span> Usuń</a>
				</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Łączna cena</th>
					<th class="danger">{{cart.grandTotal}} PLN</th>
					<th></th>
				</tr>
			</table>
			<a href="<spring:url value="/products"/>" class="btn btn-default"><span class="glyphicon-hand-left glyphicon"></span> Wróć do zakupów</a>
		</div>
	</section>
	<script src = "/webstore/resource/js/controller.js" ></script>
</body>
</html>