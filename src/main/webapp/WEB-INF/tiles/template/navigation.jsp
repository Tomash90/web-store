 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ page contentType="text/html; charset=utf-8"%> 
 <sec:authorize access="hasRole('ROLE_ANONYMOUS')"><li><a href= "<spring:url value="/login" />" >Zaloguj</a></li></sec:authorize>
  <sec:authorize access="hasRole('ROLE_ANONYMOUS')"><li><a href= "<spring:url value="/registration" />" >Zarejestruj się</a></li></sec:authorize>
 <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href= "<spring:url value="/products/add" />" >Dodaj produkt</a></li></sec:authorize>
 <li><a href= "<spring:url value="/products" />" >Strona główna</a></li>
 <li><a href= "<spring:url value="/products/" />" >Produkty</a></li>
 <li><a href= "<spring:url value="/cart/" />" >Koszyk</a></li>