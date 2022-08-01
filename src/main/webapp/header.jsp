<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 31.07.2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

    .langButton {
        margin: 8px;
        background-size: contain;
        padding: 4px;
    }

    .langButton a {
        color: white;
        padding: 4px 16px;
        font-size: medium;
        text-shadow: 0 0 8px #0b1d1d, 0 0 12px #0b1d1d;
        font-weight: bold;
        text-decoration: none;
    }

    #langButtonUA {
        background: url('ADD/flagUA.png') no-repeat center center;
    }

    #langButtonUK {
        background: url('ADD/flagUK.png') no-repeat center center ;
        background-size: cover;
    }
</style>


<title>Tax Service</title>

<div class="header">
    <h1><%= "Tax Service" %>
    </h1>
    <div>
        <div class="langButton" id="langButtonUA">
            <a href="hello-servlet">Укр</a>
        </div>

        <div class="langButton" id="langButtonUK">
            <a href="hello-servlet">Eng</a>
        </div>
    </div>
</div>
