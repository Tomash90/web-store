 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ page contentType="text/html; charset=utf-8"%> 
 <sec:authorize access="hasRole('ROLE_ANONYMOUS')"><li><a href= "<spring:url value="/login" />" ><spring:message code="navigation.login"/></a></li></sec:authorize>
 <sec:authorize access="hasRole('ROLE_ANONYMOUS')"><li><a href= "<spring:url value="/registration" />" ><spring:message code="navigation.signup"/></a></li></sec:authorize>
 <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href= "<spring:url value="/products/add" />" ><spring:message code="navigation.addProduct"/></a></li></sec:authorize>
 <li><a href= "<spring:url value="/products" />" ><spring:message code="navigation.home"/></a></li>
 <li><a href= "<spring:url value="/products/" />" ><spring:message code="navigation.products"/></a></li>
 <li><a href= "<spring:url value="/cart/" />" ><spring:message code="navigation.cart"/><span class="badge"> ${sessionScope.cartSize}</span></a></li>