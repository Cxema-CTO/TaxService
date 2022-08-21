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
        <button onclick="location.href='${pageContext.request.contextPath}/registration.jsp'" type="button"><fmt:message
                key="newUser"/></button>

        <%--<button type="submit"><fmt:message key="submit"/></button>--%>
    </div>
    <div class="content" id="content"></div>
</div>


<script defer type="text/javascript">
    //for tableViewUser.jsp
    let users = document.getElementById("users").addEventListener("click", sendRequestUsers);
    let content = document.getElementById("content");
    let url = "inspector?sendRequest=";
    let xhr = new XMLHttpRequest();
    if (sessionStorage.getItem("lastURL") == null) {
        xhr.open("GET", url + "users&page=current", true);
    } else {
        xhr.open("GET", sessionStorage.getItem("lastURL"))
    }
    xhr.send();

    function sendRequestUsers() {
        xhr.open("GET", url + "users&page=current", true);
        sessionStorage.setItem("lastURL", url + "users&page=current")
        xhr.send();
    }

    xhr.onload = function (e) {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // console.log(xhr.responseText);
                console.log("чуднінькО");
                content.innerHTML = xhr.responseText;
                addPaginationButtonListener();
                addBackButtonListener()
            } else {
                console.error(xhr.statusText + " error");
            }
        }
    }

    function getUserFromTable() {
        console.log(this.children[1].innerText)
        let getUser = this.children[1].innerText
        xhr.open("GET", url + "user&userName=" + getUser, true);
        sessionStorage.setItem("lastURL", url + "user&userName=" + getUser)
        xhr.send();
    }

    function addPaginationButtonListener() {
        setTimeout(function () { //древній волохатий костиль "debounce"
            try {
                document.getElementById("paginationButtonBefore").addEventListener("click", beforeButtonClick);
            } catch {
            }
            try {
                document.getElementById("paginationButtonNext").addEventListener("click", nextButtonClick);
            } catch {
            }

            try {
                document.addEventListener("keydown", arrowKeyClick);
                let elements = document.getElementsByClassName("rows");
                for (let i = 0; i < elements.length; i++) {
                    elements[i].addEventListener("click", getUserFromTable);
                }
            } catch {
            }
        }, 33)
        try {
            // window.addEventListener('wheel', mouseWheel);
            document.getElementById("tableHeader").addEventListener('wheel', mouseWheel);
        } catch {
        }
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

    //for tableViewUsers.jsp

    //for tableViewUser.jsp
    function addBackButtonListener() {
        try {
            document.getElementById("back").addEventListener("click", backToIndex)
        } catch {
            // console.log("backButtonDon'tReceiveListener")
        }
    }

    function backToIndex() {
        console.log("op")
        sessionStorage.setItem("lastURL", url + "users&page=current")
        location.href='${pageContext.request.contextPath}/index.jsp'
    }
    //for tableViewUser.jsp
</script>
