<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<form action="${pageContext.request.contextPath}/controller?open=LOGIN" method="post">
    <div class="container">
        <div id="loginFormLabel"><fmt:message key="title.login"/></div>
        <input type="text" maxlength="30" placeholder=
        <fmt:message key="username"/> name="username" required>
        <input type="password" maxlength="30" placeholder=
        <fmt:message key="password"/> name="password" required>
        <button type="submit"><fmt:message key="submit"/></button>
        <%--        <input type="checkbox"> <fmt:message key="rememberMe"/>--%>
        <button onclick="location.href='${pageContext.request.contextPath}/controller?open=REGISTRATION_PAGE'" type="button"><fmt:message key="newUser"/></button>
    </div>
</form>