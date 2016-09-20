<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE>
<html lang="pl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<tiles:insertAttribute name="navigation"/>
			</ul>
				
			<h3 class="text-muted">Sklep internetowy</h3>
			<div style="padding-right:50px">
			<a href="?language=pl">polski</a> | <a href="?language=en">english</a>
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