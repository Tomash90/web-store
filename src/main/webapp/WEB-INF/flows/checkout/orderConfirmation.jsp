<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
	<div class = "container">
		<div class="row">
			<form:form modelAttribute="order" class="form-horizontal">
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
					<div class="well col-xs-10 col-sm-10 col-md-6 col-xsoffset-1 col-sm-offset-1 col-md-offset-3">
						<div class="text-center">
							<h1><spring:message code="orderConfirmation.header"/></h1>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong><spring:message code="orderConfirmation.shippingAddress"/></strong><br>
									${order.shippingDetail.name}<br>
									${order.shippingDetail.shippingAddress.streetName} ${order.shippingDetail.shippingAddress.doorNo}<br>
									${order.shippingDetail.shippingAddress.zipCode} ${order.shippingDetail.shippingAddress.areaName}<br>
									${order.shippingDetail.shippingAddress.state} ${order.shippingDetail.shippingAddress.country}
								</address>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 text-right">
							<p>
								<em><spring:message code="orderConfirmation.shippingDate"/> <fmt:formatDate type="date" value="${order.shippingDetail.shippingDate}" /></em>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<address>
								<strong><spring:message code="orderConfirmation.customerInfo"/></strong><br>
								${order.customer.name}<br>
								${order.customer.billingAddress.streetName} ${order.customer.billingAddress.doorNo}<br>
								${order.customer.billingAddress.state} ${order.customer.billingAddress.country}<br>
								${order.customer.billingAddress.zipCode} ${order.customer.billingAddress.areaName}
								<br> <abbr title="Phone">tel:</abbr>
								${order.customer.phoneNumber}
							</address>
						</div>
					</div>
					<div class="row">
						<table class="table table-hover">
							<thead>
								<tr>
									<th><spring:message code="orderConfirmation.product"/></th>
									<th>#</th>
									<th class="text-center"><spring:message code="orderConfirmation.price"/></th>
									<th class="text-center"><spring:message code="orderConfirmation.total"/></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cartItem" items="${order.cart.cartItems}">
									<tr>
										<td class="col-md-9"><em>${cartItem.value.product.name}</em></td>
										<td class="col-md-1" style="text-align: center">
											${cartItem.value.quantity}</td>
										<td class="col-md-1 text-center">${cartItem.value.product.unitPrice} PLN</td>
										<td class="col-md-1 text-center">${cartItem.value.totalPrice} PLN</td>
									</tr>
								</c:forEach>

								<tr>
									<td> </td>
									<td> </td>
									<td class="text-right"><h4>
											<strong><spring:message code="orderConfirmation.grandTotal"/></strong>
										</h4></td>
									<td class="text-center text-danger"><h4>
											<strong>${order.cart.grandTotal} PLN</strong>
										</h4></td>
								</tr>
							</tbody>
						</table>
						<button id="back" class="btn btn-default" name="_eventId_backToCollectShippingDetail"><spring:message code="orderConfirmation.back"/></button>
						<button type="submit" class="btn btn-success" name="_eventId_orderConfirmed"><spring:message code="orderConfirmation.confirm"/><span class="glyphicon glyphiconchevron-right"></span></button>
						<button id="btnCancel" class="btn btn-default" name="_eventId_cancel"><spring:message code="orderConfirmation.cancel"/></button>
					</div>
				</div>
			</form:form>
		</div>
	</div>