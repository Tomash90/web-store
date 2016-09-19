 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ page contentType="text/html; charset=utf-8"%> 
 <li><a href= "<spring:url value="/products" />" >Strona główna</a></li>
 <li><a href= "<spring:url value="/products/" />" >Produkty</a></li>
 <li><a href= "<spring:url value="/products/add" />" >Dodaj produkt</a></li>
 <li><a href= "<spring:url value="/cart/" />" >Koszyk</a></li>