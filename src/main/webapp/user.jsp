<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<div class="userTop">
    <img class="userIcon" src="assets/userLogo.png">
    <div id="userNameTop" class="userName">${sessionScope.user_name}</div>
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


<script defer type="text/javascript">
    let content = document.getElementById("content");
    let url = "user?sendRequest=";
    let xhr = new XMLHttpRequest();
    getUserReportFromTable()

    xhr.onload = function (e) {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // console.log(xhr.responseText);
                console.log("чуднінькО user");
                content.innerHTML = xhr.responseText;
                addPaginationButtonListener();
                // addBackButtonListener();
            } else {
                console.error(xhr.statusText + " error");
            }
        }
    }

    function getUserReportFromTable() {
        let getUser = document.getElementById("userNameTop").innerText
        xhr.open("GET", url + "user&userName=" + getUser, true);
        sessionStorage.setItem("lastURL", url + "user&userName=" + getUser)
        xhr.send();
    }

</script>