<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src = "/webstore/resource/js/angular.min.js" ></script>
<script src="/webstore/resource/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<section class="container">
		<form:form modelAttribute="order.customer" class="form-horizontal">
			<fieldset>
				<legend><spring:message code="collectCustomerInfo.legend"/></legend>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="name"/><spring:message code="collectCustomerInfo.name"/></label>
					<div class="col-sm-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="doorNo"/><spring:message code="collectCustomerInfo.doorNo"/></label>
					<div class="col-sm-10">
						<form:input id="doorNo" path="billingAddress.doorNo" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="streetName"/><spring:message code="collectCustomerInfo.streetName"/></label>
					<div class="col-sm-10">
						<form:input id="streetName" path="billingAddress.streetName" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="areaName"/><spring:message code="collectCustomerInfo.area"/></label>
					<div class="col-sm-10">
						<form:input id="areaName" path="billingAddress.areaName" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="state"/><spring:message code="collectCustomerInfo.state"/></label>
					<div class="col-sm-10">
						<form:input id="state" path="billingAddress.state" type="text" class="form:input-large"/>
					</div>
				</div>
					<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="country"/><spring:message code="collectCustomerInfo.country"/></label>
					<div class="col-sm-10">
						<form:input id="state" path="billingAddress.state" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="zipCode"/><spring:message code="collectCustomerInfo.zipCode"/></label>
					<div class="col-sm-10">
						<form:input id="zipCode" path="billingAddress.zipCode" type="text" class="form:input-large"/>
					</div>
				</div>
					<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="phoneNumber"/><spring:message code="collectCustomerInfo.phoneNumber"/></label>
					<div class="col-sm-10">
						<form:input id="phoneNumber" path="phoneNumber" type="text" class="form:input-large"/>
					</div>
				</div>
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="<spring:message code="collectCustomerInfo.button.create"/>" name="_eventId_customerInfoCollected"/>
						<button id="btnCancel" class="btn btn-default" name="_eventId_cancel"><spring:message code="collectCustomerInfo.button.cancel"/></button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>