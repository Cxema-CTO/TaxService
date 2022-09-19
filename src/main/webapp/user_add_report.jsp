<%@ page import="com.example.taxservice.entity.User" %>
<%@ page import="com.example.taxservice.dao.UserDAO" %>
<%@ page import="java.sql.SQLException" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles.css">

<head>
    <jsp:include page="header.jsp"/>
</head>

<%--   бікоз - вибір мови у хедері   --%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<div class="userTop">
    <img class="userIcon" src="assets/userLogo.png">
    <div id="userNameTop" class="userName">${sessionScope.user_name}</div>
    <a class="userTop" href="${pageContext.request.contextPath}/controller?open=EXIT">
        <img id="userTopCloseButton" src="assets/exit.png"></a>
</div>

<body>
<form action="${pageContext.request.contextPath}/controller?open=DB_ADD_REPORT" method="post">
    <div class="container">
        <div id="loginFormLabel"><fmt:message key="title.user.add.report"/></div>

        <textarea id="report" name="report" minlength="10" maxlength="554" required></textarea><br>

        <input type="radio" id="monthly" name="report_type" value="0" checked>
        <label for="monthly"><fmt:message key="report.monthly"/></label><br>
        <input type="radio" id="quarterly" name="report_type" value="1">
        <label for="quarterly"><fmt:message key="report.quarterly"/></label><br>
        <input type="radio" id="annual" name="report_type" value="2">
        <label for="annual"><fmt:message key="report.annual"/></label>
        <%--        <input type="hidden" id="hidden" name="user_name" value="${sessionScope.user_name}">--%>

        <button type="submit"><fmt:message key="submit"/></button>
        <button onclick="history.back()" type="button"><fmt:message key="back"/></button>
    </div>



</form>
</body>


<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</html>