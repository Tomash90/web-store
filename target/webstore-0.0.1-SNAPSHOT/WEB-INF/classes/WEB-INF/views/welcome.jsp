<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webstore/resource/css/bootstrap.css">
<script src="/webstore/resource/js/bootstrap.js"></script>
<title>Witaj</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting} </h1>
				<p>${tagline} </p>
			</div>
		</div>
	</section>
</body>
</html>