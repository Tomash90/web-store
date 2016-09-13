<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<title>Klient</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Wysyłka</h1>
				<p>Dane do Wysyłki<p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="order.shippingDetail" class="form-horizontal">
			<fieldset>
				<legend>Dane do wysyłki</legend>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="name"/>Nazwa</label>
					<div class="col-sm-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="shippingDate"/>Data Wysyłki (dd/mm/yyyy)</label>
					<div class="col-sm-10">
						<form:input id="shippingDate" path="shippingDate" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="doorNo"/>Numer domu</label>
					<div class="col-sm-10">
						<form:input id="doorNo" path="shippingAddress.doorNo" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="streetName"/>Ulica</label>
					<div class="col-sm-10">
						<form:input id="streetName" path="shippingAddress.streetName" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="areaName"/>Miasto</label>
					<div class="col-sm-10">
						<form:input id="areaName" path="shippingAddress.areaName" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="state"/>Województwo</label>
					<div class="col-sm-10">
						<form:input id="state" path="shippingAddress.state" type="text" class="form:input-large"/>
					</div>
				</div>
					<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="country"/>Kraj</label>
					<div class="col-sm-10">
						<form:input id="country" path="shippingAddress.country" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="zipCode"/>Kod Pocztowy</label>
					<div class="col-sm-10">
						<form:input id="zipCode" path="shippingAddress.zipCode" type="text" class="form:input-large"/>
					</div>
				</div>
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="back" class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Wstecz</button>
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj" name="_eventId_shippingDetailCollected"/>
						<button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Anuluj</button>
					</div>
				</div>
				</fieldset>
		</form:form>
	</section>
</body>
</html>