<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
	<section class="container">
		<form:form modelAttribute="order.shippingDetail" class="form-horizontal">
			<fieldset>
				<legend><spring:message code="shippingDetail.legend"/></legend>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="name"/><spring:message code="shippingDetail.name"/></label>
					<div class="col-sm-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="shippingDate"/><spring:message code="shippingDetail.date"/></label>
					<div class="col-sm-10">
						<form:input id="shippingDate" path="shippingDate" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="doorNo"/><spring:message code="shippingDetail.doorNo"/></label>
					<div class="col-sm-10">
						<form:input id="doorNo" path="shippingAddress.doorNo" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="streetName"/><spring:message code="shippingDetail.streetName"/></label>
					<div class="col-sm-10">
						<form:input id="streetName" path="shippingAddress.streetName" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="areaName"/><spring:message code="shippingDetail.areaName"/></label>
					<div class="col-sm-10">
						<form:input id="areaName" path="shippingAddress.areaName" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="state"/><spring:message code="shippingDetail.state"/></label>
					<div class="col-sm-10">
						<form:input id="state" path="shippingAddress.state" type="text" class="form:input-large"/>
					</div>
				</div>
					<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="country"/><spring:message code="shippingDetail.country"/></label>
					<div class="col-sm-10">
						<form:input id="country" path="shippingAddress.country" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="zipCode"/><spring:message code="shippingDetail.zipCode"/></label>
					<div class="col-sm-10">
						<form:input id="zipCode" path="shippingAddress.zipCode" type="text" class="form:input-large"/>
					</div>
				</div>
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="back" class="btn btn-default" name="_eventId_backToCollectCustomerInfo"> <spring:message code="shippingDetail.button.back"/></button>
						<input type="submit" id="btnAdd" class="btn btn-primary" value="<spring:message code="shippingDetail.button.add"/>" name="_eventId_shippingDetailCollected"/>
						<button id="btnCancel" class="btn btn-default" name="_eventId_cancel"> <spring:message code="shippingDetail.button.cancel"/></button>
					</div>
				</div>
				</fieldset>
		</form:form>
	</section>