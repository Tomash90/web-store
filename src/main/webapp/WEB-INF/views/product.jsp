<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>


<title>Produkt</title>
</head>
<body>
	<section>
		<div class = "jumbotron">
			<div class = "container">
				<h1>Produkt</h1>
			</div>
		</div>
	</section>
	<section class="container" ng-app="cartApp">
		<div class="row">
		<div class="col-md-5">
			<img src="<c:url value="/resource/images/${product.productId}.jpg"></c:url>" alt="image" style="width:60%"/>
		</div>
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Kod produktu: </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>Producent:</strong> ${product.manufacturer}
				</p>
				<p>
					<strong>Kategoria:</strong> ${product.category}
				</p>
				<p>
					<strong>Liczba sztuk w magazynie:</strong> ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice} PLN</h4>
				<p ng-controller="cartCtrl">
					<a href="#" class="btn btn-warning btn-md" ng-click="addToCart('${product.productId}')"><span class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz</a>
					<a href="<spring:url value="/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> Koszyk</a>
					<a href="<spring:url value="/products" />" class="btn btn-info btn-md"><span class="glyphicon glyphicon-hand-left"></span> Wstecz</a>
				</p>
					
			</div>
		</div>
	</section>
	<script src = "/webstore/resource/js/controller.js" ></script>
</body>
</html>