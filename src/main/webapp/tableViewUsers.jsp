<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<h3><fmt:message key="users"/>:</h3>

<table id="tableUsers">
    <tr id="tableHeader">
        <th>id</th>
        <th>name</th>
        <th>pass</th>
        <th>inspector</th>
        <th>legal</th>
    </tr>
    <c:forEach items="${users}" var="i">
        <tr class="rows">
            <td>${i.id}</td>
            <td>${i.userName}</td>
            <td>${i.password}</td>
                <%--            https://stackoverflow.com/questions/6854866/how-to-get-boolean-property-with-expression-language--%>
                <%--            <td>${i.isInspector()}</td>--%>
                <%--            <td>${i.isLegal()}</td>--%>
            <td>${i.inspector}</td>
            <td>${i.legal}</td>
        </tr>
    </c:forEach>
</table>

<c:if test="${pagination=='yes'}">
    <div id="paginationButtonView">
        <button type="submit" id="paginationButtonBefore">←</button>
        <button type="submit" id="paginationButtonNext">→</button>
    </div>
</c:if>
<h3><fmt:message key="total"/>: <c:out value="${size}"/></h3>


