<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Dodaj Produkt</title>
</head>
<body>
	<section>
		<div class = "jumbotron">
			<c:url var="logoutUrl" value="/logout"/> 
			<form action="${logoutUrl}" method="post"> 
  				<input class ="btn btn-danger btn-mini pull-right"  type="submit" value="Wyloguj się" />
  				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<div class = "container">
				<h1>Produkty</h1>
				<p>Dodaj Produkty</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newProduct" method="post" class="form-horizontal" enctype="multipart/form-data">
			<fieldset>
				<legend>Dodaj nowy produkt</legend>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="productId">
						<spring:message code="addProduct.form.productId.label"/>
					</label>
					<div class="col-sm-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="productId">Nazwa</label>
					<div class="col-sm-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="description">Opis</label>
					<div class="col-sm-10">
					<form:textarea id="description" path="description" rows="2"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="productId">Cena Produktu</label>
					<div class="col-sm-10">
						<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="productId">Producent</label>
					<div class="col-sm-10">
						<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="productId">Kategoria</label>
					<div class="col-sm-10">
						<form:input id="category" path="category" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="productId">Liczba dostępnych egemplarzy</label>
					<div class="col-sm-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="productImage"><spring:message code="addProduct.form.productImage.label"/></label>
					<div class="col-sm-10">
						<form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="condition">Stan</label>
					<div class="col-sm-10">
						<form:radiobutton path="condition" value="Odnowiony"/> Nowy
						<form:radiobutton path="condition" value="Używany"/> Używany
						<form:radiobutton path="condition" value="Odnowiony"/> Odnowiony
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-ffset-2 col-sm-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj">
					</div>
				</div>
			</fieldset>
			 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		</form:form>
	</section>
</body>
</html>