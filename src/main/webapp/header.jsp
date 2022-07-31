<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 31.07.2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        margin-right: 8px;
        padding: 8px;
        background-size: contain;
        background: url('ADD/flagUA.png') no-repeat center center;
    }

    #langButton a {
        color: white;
        font-size: medium;
        text-shadow: 0 0 8px #0b1d1d, 0 0 12px #0b1d1d;
        text-decoration: none;
    }
</style>


<title>Tax Service</title>

<div class="header">
    <h1><%= "Tax Service" %>
    </h1>
    <div id="langButton">
        <a href="hello-servlet">Укр</a></div>
</div>
