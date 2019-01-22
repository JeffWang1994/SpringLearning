<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1><s:message code="com.jeffwang.welcome" /></h1>
        <p>This is the homepage!</p>
        <s:url value="/spitter/register" var="registerUrl" scope="request" />
        <s:url value="/spittles" htmlEscape="true">
            <s:param name="max" value="60" />
            <s:param name="count" value="20" />
        </s:url>
        <a href="<s:url value="/spittles" />">Spittles</a> |
        <a href="${registerUrl}"> ">Register</a>
    </body>
</html>
