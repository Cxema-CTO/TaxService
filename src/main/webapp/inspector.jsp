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
    <div class="content" id="content"></div>
</div>


<script defer type="text/javascript">
    let users = document.getElementById("users").addEventListener("click", sendRequestUsers);
    let content = document.getElementById("content");
    let url = "inspector?sendRequest=";
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url + "users&page=current", true);
    xhr.send();

    function sendRequestUsers() {
        xhr.open("GET", url + "users&page=current", true);
        xhr.send();
    }

    xhr.onload = function (e) {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // console.log(xhr.responseText);
                console.log("чуднінькО");
                content.innerHTML = xhr.responseText;
                addPaginationButtonListener();

            } else {
                console.error(xhr.statusText + " error");
            }
        }
    }

    function addPaginationButtonListener() {
        setTimeout(function () { //древній волохатий костиль
            try {
                document.getElementById("paginationButtonBefore").addEventListener("click", beforeButtonClick);
                document.getElementById("paginationButtonBefore").style = "styles";
            } catch {
            }
            try {
                document.getElementById("paginationButtonNext").addEventListener("click", nextButtonClick);
                document.getElementById("paginationButtonNext").style = "styles";
            } catch {
            }
            document.addEventListener("keydown", arrowKeyClick)
            window.addEventListener('wheel', mouseWheel)
        }, 33)
    }

    function mouseWheel(e) {
        if (e.deltaY < 0) beforeButtonClick()
        if (e.deltaY > 0) nextButtonClick()
    }

    function arrowKeyClick(e) {
        if (e.keyCode === 37) beforeButtonClick()
        if (e.keyCode === 39) nextButtonClick()
    }

    function beforeButtonClick() {
        xhr.open("GET", url + "users&page=before", true);
        xhr.send();
    }

    function nextButtonClick() {
        xhr.open("GET", url + "users&page=next", true);
        xhr.send();
    }
</script>
