<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Welcome to Spittr</h1>
        <p>This is the homepage!</p>
        <a href="<c:url value="/spittles" />">Spittles</a> |
        <a href="<c:url value="/spitter/register"/> ">Register</a>
    </body>
</html>
