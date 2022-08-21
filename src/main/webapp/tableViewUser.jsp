<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<h3><fmt:message key="username"/>: <c:out value="${user}"/></h3>

<%--<button class="buttonError" onclick="history.back()" type="button"><fmt:message key="back"/></button>--%>
<%--<button onclick="location.href='${pageContext.request.contextPath}/index.jsp'" type="button"><fmt:message key="back"/></button>--%>
<button id="back" type="button"><fmt:message key="back"/></button>
