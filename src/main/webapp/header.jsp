<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--запам'ятати вибір мови на час який триває активна сесія--%>
<c:if test="${param.lang != null}">
    <c:set value="${param.lang}" var="language" scope="session"/>
</c:if>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>


<title><fmt:message key="title.tax_service"/></title>


<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
<div class="header">
    <a href="index.jsp"><h1><fmt:message key="title.tax_service"/></h1>
    </a>
    <div>
        <div class="langButton" id="langButtonUA">
            <a href="?lang=ukr">Укр</a>
        </div>
        <div class="langButton" id="langButtonUK">
            <a href="?lang=default">Eng</a>
        </div>
    </div>
</div>


<%----%>
<%----%>
<%----%>
<%----%>
<style>
    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding-left: 24px;
        height: 100px;
        background: url("ADD/backgroundSmall.png");
        color: white;
        text-align: center;
    }

    #langButton {
        background-color: white;
        padding: 6px 12px;
        width: 72px;
        margin-right: 24px;
        color: #263b5d;
        border: none;
        cursor: pointer;
        font-weight: bolder;
        transition: all 0.3s ease;
    }

    #langButton:hover {
        background-color: #ff8c00;
        color: white;
        transition: all 0.3s ease;
    }

    .langButton {
        margin: 16px;
        background-size: contain;
    }

    .header a {
        color: white;
        padding: 6px 16px;
        font-size: medium;
        text-shadow: 0 0 8px #0b1d1d, 0 0 12px #0b1d1d;
        font-weight: bold;
        text-decoration: none;
    }

    #langButtonUA {
        background: url('ADD/flagUA.png') no-repeat center center;
    }

    #langButtonUK {
        background: url('ADD/flagUK.png') no-repeat center center;
        background-size: cover;
    }
</style>
