<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<div class="userTop">
    <img class="userIcon" src="assets/userLogo.png">
    <div class="userName">${sessionScope.user_name}</div>
    <a class="userTop" href="exit"><img id="userTopCloseButton" src="assets/exit.png"></a>
</div>
<div class="left_sidebar">
<button type="submit"><fmt:message key="submit"/></button>
<button type="submit"><fmt:message key="submit"/></button>
<button type="submit"><fmt:message key="submit"/></button>
<button type="submit"><fmt:message key="submit"/></button>
<button type="submit"><fmt:message key="submit"/></button>
<button type="submit"><fmt:message key="submit"/></button>
<button type="submit"><fmt:message key="submit"/></button>
<button type="submit"><fmt:message key="submit"/></button>
</div>
