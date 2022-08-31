<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<h3><fmt:message key="user"/>: <c:out value="${user.userName}"/></h3>


<table id="tableReports">
    <tr id="tableHeader">
        <th>id</th>
        <th>name</th>
        <th>content</th>
        <th>accepted</th>
        <th>refusal</th>
        <th>date</th>
        <th>type</th>
        <th>send</th>
    </tr>
    <c:forEach items="${reports}" var="i">
        <tr class="rows">
            <td>${i.id}</td>
            <td>${i.userName}</td>
            <td>${i.reportContent}</td>
            <td>${i.accepted}</td>
            <td>${i.reasonOfRefusal}</td>
            <td>${i.submissionDate}</td>
            <td>${i.type}</td>
            <td>${i.send}</td>
                <%-- https://stackoverflow.com/questions/6854866/how-to-get-boolean-property-with-expression-language--%>
        </tr>
    </c:forEach>
</table>

<c:if test="${pagination=='yes'}">
    <div id="paginationButtonView">
        <button type="submit" id="paginationButtonBefore">←</button>
        <button type="submit" id="paginationButtonNext">→</button>
    </div>
</c:if>
<h3><fmt:message key="total"/>: <c:out value="${sizeReports}"/></h3>

