<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
	<section>
		<div class = "jumbotron">
			<div class = "container">
				<h1 class="alert alert-danger"><spring:message code="productNotFound.header"/> ${invalidProductId}</h1>
			</div>
		</div>
	</section>
	<section>
		<div class="container">
			<p>${url}</p>
			<p>${exception}</p>
		</div>
		<div class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary"><span class="glyphicon-shopping-cart glyphicon"></span> <spring:message code="productNotFound.button.products"/></a>
			</p>
		</div>
	</section>