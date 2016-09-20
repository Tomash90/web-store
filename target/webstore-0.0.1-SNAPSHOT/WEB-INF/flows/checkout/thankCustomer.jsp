<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<title>Dziękujemy!</title>
</head>
<body>
<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">Zamówienie złożone do realizacji</h1>
				<p>Dziękujemy za złożenie zamówienia. Planowana data wysyłki:
				 <fmt:formatDate type="date"	value="${order.shippingDetail.shippingDate}" />!</p>
				<p>Numer Twojego zamówienia: ${order.orderId}</p>
			</div>
		</div>
	</section>
	<section>
		<div class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span> Powrót do sklepu
				</a>
			</p>
		</div>
	</section>
</body>
</html>