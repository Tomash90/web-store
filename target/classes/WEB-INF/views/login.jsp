<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="/webstore/resource/css/log.css" rel="stylesheet">
		<div class="row">
			<div class="col-sm-5 col-sm-offset-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Zaloguj Się</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br/>
							</div>
					</c:if>
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" id="login-form-link"><spring:message code="login.login"/></a>
							</div>
							<div class="col-xs-6">
								<a href="registration"  class="active" id="register-form-link"><spring:message code="login.register"/></a>
							</div>
						</div>
						<hr>
					</div>
					 <c:set var="loginUrl"><c:url value="/login"/></c:set>
					<form action="${loginUrl}" method="post" role="form">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Login" name="username" type="text">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Hasło" name="password" type="password" value="">
							</div>
							<input class="btn btn-lg btn-success btn-block" type="submit" value="Zaloguj się">
						</fieldset>	
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
					</form>
				</div>
			</div>
		</div>	
	</div>