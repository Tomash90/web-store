<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
	<section class="container">
		<form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
		<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>
				<legend><spring:message code="addProduct.form.addProduct.legend"/></legend>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="productId">
						<spring:message code="addProduct.form.productId.label"/>
					</label>
					<div class="col-sm-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
						<form:errors path="productId" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="name"><spring:message code="addProduct.form.name.label"/></label>
					<div class="col-sm-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="description"><spring:message code="addProduct.form.description.label"/></label>
					<div class="col-sm-10">
					<form:textarea id="description" path="description" rows="2"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="unitPrice"><spring:message code="addProduct.form.unitPrice.label"/></label>
					<div class="col-sm-10">
						<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
						<form:errors path="unitPrice" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="manufacturer"><spring:message code="addProduct.form.manufacturer.label"/></label>
					<div class="col-sm-10">
						<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="category"><spring:message code="addProduct.form.category.label"/></label>
					<div class="col-sm-10">
						<form:input id="category" path="category" type="text" class="form:input-large"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-sm-2" for="unitsInStock"><spring:message code="addProduct.form.unitsInStock.label"/></label>
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
					<label class="control-label col-sm-2" for="condition"><spring:message code="addProduct.form.condition.label"/></label>
					<div class="col-sm-10">
						<form:radiobutton path="condition" value="Nowy"/> <spring:message code="addProduct.form.new.radiobutton"/>
						<form:radiobutton path="condition" value="Używany"/> <spring:message code="addProduct.form.used.radiobutton"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-ffset-2 col-sm-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="<spring:message code="addProduct.form.add.submit"/>">
					</div>
				</div>
			</fieldset>
			 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		</form:form>
	</section>