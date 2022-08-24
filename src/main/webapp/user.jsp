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

<div class="workspace">
<div class="left_sidebar">
<button type="submit"><fmt:message key="add"/></button>
<button type="submit"><fmt:message key="edit"/></button>
<button type="submit"><fmt:message key="delete"/></button>
</div>

<div class="content" id="content"></div>
</div>
</div>