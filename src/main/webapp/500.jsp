<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles.css">

<head>
    <jsp:include page="header.jsp"/>
</head>

<%--   бікоз - вибір мови у хедері   --%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>


<body>
<div class="errorModal">
    <div>
        <h1 class="inCenter"><fmt:message key="error"/></h1>
        <h3 class="inCenter"><fmt:message key="something_wrong"/></h3>
        <div class="inCenter">
            <img src="${pageContext.request.contextPath}/assets/500.gif" height="128px">
        </div>
        <button class="buttonError" onclick="history.back()" type="button"><fmt:message key="back"/></button>
    </div>
</div>
</body>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</html>
