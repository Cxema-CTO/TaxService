<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles.css">
<head>
    <title>Test</title>
</head>
<%--   бікоз - вибір мови у хедері   --%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<body>
<h1 class="inCenter">Hui Pizda Djigurda</h1>
<button class="buttonError" onclick="history.back()" type="button"><fmt:message key="back"/></button>
</body>
</html>
