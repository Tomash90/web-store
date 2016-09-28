<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<link href="/webstore/resource/css/log.css" rel="stylesheet">
<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
				<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="login" id="login-form-link"><spring:message code="login.login"/></a>
							</div>
							<div class="col-xs-6">
								<a href="#"  class="active" id="register-form-link"><spring:message code="login.register"/></a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
	<form:form  method="POST" modelAttribute="userDto" id="register-form">
	<form:errors path="*" cssClass="alert alert-danger" element="div"/>
									<div class="form-group">
									<spring:message code="login.username" var="username"/>
										<form:input type="email" path="username" id="username" tabindex="1" class="form-control" placeholder="${username}"/>
									</div>
									<div class="form-group">
									<spring:message code="login.password" var="password"/>
										<form:input type="password" path="password" id="password" tabindex="2" class="form-control" placeholder="${password}"/>
									</div>
									<div class="form-group">
									<spring:message code="login.confirmpassword" var="confirmpassword"/>
										<form:input type="password" path="confirmPassword" id="confirm-password" tabindex="2" class="form-control" placeholder="${confirmpassword}"/>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
											<spring:message code="login.registernow" var="RegisterNow"/>
												<input type="submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="${RegisterNow}">
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>