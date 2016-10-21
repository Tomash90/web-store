<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html lang="pl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<link href="/webstore/resource/css/log.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="header">
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">	
			<div class = "pull-right" style="padding-right:40px">
			<c:url var="logoutUrl" value="/logout"/> 
			<form action="${logoutUrl}" method="post"> 
  				<input class ="btn btn-danger btn-mini pull-right"  type="submit" value="<spring:message code="addProduct.form.logout.submit"/>  [<sec:authentication property="principal.username" />]" />
  				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			</div>
			</sec:authorize>
			<ul class="nav nav-pills pull-right">
				<tiles:insertAttribute name="navigation"/>
			</ul>
			<h3 class="text-muted"><spring:message code="baseLayout.webstore"/></h3>
			<div style="padding-right:50px">
			<tiles:insertAttribute name="language"/><br>
			</div>
		</div>
		<div class="jumbotron">
			<h2>
				<tiles:insertAttribute name="heading" />
			</h2>
			<p>
				<tiles:insertAttribute name="tagline" />
			</p>
		</div>
		<div class="row">
			<tiles:insertAttribute name="content"/>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>
</body>
</html>