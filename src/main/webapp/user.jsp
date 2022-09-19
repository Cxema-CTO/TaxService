<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--   бікоз - вибір мови у хедері   --%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<div class="userTop">
    <img class="userIcon" src="assets/userLogo.png">
    <div id="userNameTop" class="userName">${sessionScope.user_name}</div>
    <a class="userTop" href="${pageContext.request.contextPath}/controller?open=EXIT">
        <img id="userTopCloseButton" src="assets/exit.png"></a>
</div>

<div class="workspace">
    <div class="left_sidebar">
        <button onclick="window.location.href='${pageContext.request.contextPath}/controller?open=USER_ADD_REPORT'">
            <fmt:message key="add"/></button>
        <%--        <button type="submit"><fmt:message key="add"/></button>--%>
        <button type="submit"><fmt:message key="edit"/></button>
        <button type="submit" onclick="openDeleteModal()"><fmt:message key="delete"/></button>
    </div>


    <div class="content" id="content"></div>
</div>
</div>

<div class="hideModal" id="deleteModal">
    <div class="errorModal">
        <div>
            <h1 class="inCenter"><fmt:message key="are_you_sure"/> ?!</h1>
            <button class="buttonError" onclick="deleteReportFromTable()" type="button"><fmt:message
                    key="report.yes"/></button>
            <button class="buttonError" onclick="closeDeleteModal()" type="button"><fmt:message key="report.no"/></button>
        </div>
    </div>
</div>

<%--script--%>
<script defer type="text/javascript">

    let content = document.getElementById("content");
    let getID = 0
    let checkedRow
    let url = "user?sendRequest=";
    let xhr = new XMLHttpRequest();
    getUserReportFromTable()


    xhr.onload = function (e) {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // console.log(xhr.responseText);
                console.log("чуднінькО user");
                content.innerHTML = xhr.responseText;
                addTableListener()
                addPaginationButtonListener();
                // addBackButtonListener();
            } else {
                console.error(xhr.statusText + " error");
            }
        }
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
        }, 33)
    }

    function addTableListener() {
        try {
            let elements = document.getElementsByClassName("rows");
            for (let i = 0; i < elements.length; i++) {
                elements[i].addEventListener("click", getReportID);
            }
        } catch {
        }
    }

    function getReportID() {
        try {
            checkedRow.style.color = "black"
        } catch {
        }
        getID = this.children[0].innerText
        checkedRow = this
        checkedRow.style.color = "red"
    }

    function openDeleteModal() {
        if (getID != 0) {
            let modalDelete = document.getElementById("deleteModal")
            modalDelete.style.visibility = "visible"
        }
    }

    function deleteReportFromTable() {
        let modalDelete = document.getElementById("deleteModal")
        modalDelete.style.visibility = "hidden"
        let link = "${pageContext.request.contextPath}/DeleteReportByID?id=" + getID
        location.href = link
    }

    function closeDeleteModal() {
        let modalDelete = document.getElementById("deleteModal")
        modalDelete.style.visibility = "hidden"
    }


    function getUserReportFromTable() {
        let getUser = document.getElementById("userNameTop").innerText
        xhr.open("GET", url + "user&userName=" + getUser, true);
        sessionStorage.setItem("lastURL", url + "user&userName=" + getUser)
        xhr.send();
    }

</script>