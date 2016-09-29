<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="/webstore/resource/css/log.css" rel="stylesheet">
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-6">
							<a href="#" id="login-form-link" class="active"><spring:message code="login.login"/></a>
						</div>
						<div class="col-xs-6">
							<a href="registration"   id="register-form-link"><spring:message code="login.register"/></a>
						</div>
					</div>
					<hr>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<c:if test="${not empty error}">
								<div class="alert alert-danger">
									<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br/>
								</div>
							</c:if>
					 		<c:set var="loginUrl"><c:url value="/login"/></c:set>
							<form action="${loginUrl}" method="post" role="form">
								<div class="form-group">
									<input class="form-control" placeholder="Login" name="username" type="text" tabindex="1">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Hasło" name="password" type="password" tabindex="2" value="">
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<input class="btn btn-lg btn-success btn-block" type="submit" value="Zaloguj się">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
</div>