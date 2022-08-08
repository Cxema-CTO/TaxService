<%@ page import="com.example.taxservice.entity.User" %>
<%@ page import="com.example.taxservice.dao.UserDAO" %>
<%@ page import="java.sql.SQLException" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>

<link rel="stylesheet" href="ADD/styles.css">

<head>
    <jsp:include page="header.jsp"/>
</head>

<%--   бікоз - вибір мови у хедері   --%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>


<body>
<jsp:include page="login.jsp"/>
</body>


<%
    //    Boolean checkUser;
//    User user = UserDAO.getUserByLogin("inspector");
//    System.out.println(user);
//    try {
//        UserDAO.createNewUser("Vasia");
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
%>


<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</html>