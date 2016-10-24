<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger"><spring:message code="thankCustomer.header"/></h1>
				<p><spring:message code="thankCustomer.paragraphOne"/>
				 <fmt:formatDate type="date" value="${order.shippingDetail.shippingDate}" />!</p>
				<p><spring:message code="thankCustomer.paragraphTwo"/> ${order.orderId}</p>
			</div>
		</div>
	</section>
	<section>
		<div class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span> <spring:message code="checkOutCancelled.back"/>
				</a>
			</p>
		</div>
	</section>
