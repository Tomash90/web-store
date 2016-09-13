<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<title><spring:message code="addProduct.form.addProducts.title"/></title>
</head>
<body>
	<section>
		<div class = "jumbotron">
			<div class = "container">
				<h1 class="alert alert-danger">Błędny kod promocyjny</h1>
			</div>
		</div>
	</section>
	<section>
	<div class="container">
		<p>
			<a href="<spring:url value="/products" />" class="btn btn-primary"><span class="glyphicon-hand-left glyphicon"></span> Produkty</a>
		</p>
	</div>
	</section>
</body>
</html>