<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.example.taxservice.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>


<div class="userTop">
    <img class="userIcon" src="assets/inspectorLogo.png" alt="user">
    <div class="userName">${sessionScope.user_name}</div>
    <a class="userTop" href="exit"><img id="userTopCloseButton" src="assets/exit.png" alt="exit"></a>
</div>


<div class="workspace">
    <div class="left_sidebar">
        <button id="users" type="submit"><fmt:message key="users"/></button>
        <button type="submit"><fmt:message key="reports"/></button>
        <%--<button type="submit"><fmt:message key="submit"/></button>--%>
    </div>
    <div class="content" id="content">
    </div>
</div>


<script defer type="text/javascript">
    let users = document.getElementById("users").addEventListener("click", sendRequestUsers);
    let content = document.getElementById("content");
    let url = "inspector?sendRequest=";
    let xhr = new XMLHttpRequest();

    function sendRequestUsers() {
        xhr.open("GET", url + "users", true);
        xhr.send();
    }

    xhr.onload = function (e) {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
                content.innerHTML = xhr.responseText;
            } else {
                console.error(xhr.statusText + " error");
            }
        }
    };
</script>