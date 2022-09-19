<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<%--<h3><fmt:message key="user"/>: <c:out value="${user.userName}"/></h3>--%>
<h3><fmt:message key="reports"/>:</h3>


<table id="tableReports">
    <tr id="tableHeader">
        <th><fmt:message key="report.id"/></th>
        <%--        <th>name</th>--%>
        <th><fmt:message key="report.content"/></th>
        <th><fmt:message key="report.accepted"/></th>
        <th><fmt:message key="report.refusal"/></th>
        <th><fmt:message key="report.date"/></th>
        <th><fmt:message key="report.type"/></th>
        <%--        <th>send</th>--%>
    </tr>
    <c:forEach items="${reports}" var="i">
        <tr class="rows">
            <td>${i.id}</td>
                <%--            <td>${i.userName}</td>--%>
            <td>${i.reportContent}</td>
            <td>
                <c:choose>
                    <c:when test="${i.accepted == true}"><fmt:message key="report.yes"/></c:when>
                    <c:when test="${i.accepted == false}"><fmt:message key="report.no"/></c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${i.reasonOfRefusal == null}"><fmt:message key="report.not_verified"/></c:when>
                    <c:when test="${i.reasonOfRefusal == 'gg'}"><fmt:message key="report.without_comments"/></c:when>
                    <c:otherwise>${i.reasonOfRefusal}</c:otherwise>
                </c:choose>
            </td>
            <td>${i.submissionDate}</td>
            <td>
                <c:choose>
                    <c:when test="${i.type == 0}"><fmt:message key="report.monthly"/></c:when>
                    <c:when test="${i.type == 1}"><fmt:message key="report.quarterly"/></c:when>
                    <c:when test="${i.type == 2}"><fmt:message key="report.annual"/></c:when>
                    <c:otherwise>No comment sir...</c:otherwise>
                </c:choose>
            </td>
                <%--            <td>${i.send}</td>--%>
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

