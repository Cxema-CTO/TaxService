<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="ADD/styles.css">

<head>
    <jsp:include page="header.jsp"/>
</head>

<body>
<br/>
<a href="hello-servlet">Hello Servlet</a>


<form method="post">
    <div class="container">
        <div id = "loginFormLabel">Log in</div>
        <input type="text" placeholder="Username" name="username" required>
        <input type="password" placeholder="Password" name="password" required>
        <button type="submit">Submit</button>
        <input type="checkbox"> Remember me
        <button type="button" class="cancelbtn">Cancel</button>
        Forgot <a href="#"> password? </a>
        <div><a href="#"> Sign UP </a></div>
    </div>
</form>
</body>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</html>