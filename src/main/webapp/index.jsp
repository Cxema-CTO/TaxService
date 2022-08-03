<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>

<link rel="stylesheet" href="ADD/styles.css">

<head>
    <jsp:include page="header.jsp"/>
</head>

<%--   бікоз - вибір мови у хедері   --%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<body>
<br/>
<a href="hello-servlet">Hello Servlet</a>

${sessionScope.language}

<form>
    <div class="container">
        <div id="loginFormLabel"><fmt:message key="title.login"/></div>
        <input type="text" placeholder=<fmt:message key="username"/> name="username" required>
        <input type="password" placeholder=<fmt:message key="password"/> name="password" required>
        <button type="submit"><fmt:message key="submit"/></button>
        <input type="checkbox"> <fmt:message key="rememberMe"/>
        <button type="button" class="cancelbtn"><fmt:message key="newUser"/></button>
    </div>
</form>
</body>


<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</html>