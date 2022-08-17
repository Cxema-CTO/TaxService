<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>pass</th>
        <th>inspector</th>
        <th>legal</th>
    </tr>
    <c:forEach items="${users}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.userName}</td>
            <td>${i.password}</td>
<%--            <td>${i.isInspector}</td>--%>
<%--            <td>${i.isLegal}</td>--%>
        </tr>
    </c:forEach>
</table>

