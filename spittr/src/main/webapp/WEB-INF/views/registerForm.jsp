<%--
  Created by IntelliJ IDEA.
  User: wangjiangfeng
  Date: 2019-01-21
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css"/>
<html>
<head>
    <title>Register As A Spitter!</title>
</head>
<body>
    <h1>Register As A Spitter!</h1>

    <!--
    <form method="post">
        First Name: <input type="text" name="firstName" /><br/>
        Last Name: <input type="text" name="lastName" /><br/>
        Username: <input type="text" name="username" /><br/>
        Password: <input type="text" name="password" /><br/>
        <input type="submit" value="Register" />
    </form>
    -->

    <sf:form method="post">
        <sf:errors path="*" element="div" cssClass="errors"/>
        <sf:label path="firstName"
                  cssErrorClass="error">First Name</sf:label>
            <sf:input path="firstName" cssErrorClass="error"/><br/>
        <sf:label path="lastName"
                  cssErrorClass="error">Last Name</sf:label>
        <sf:input path="lastName" cssErrorClass="error"/><br/>
        <sf:label path="username"
                  cssErrorClass="error">Username</sf:label>
        <sf:input path="username" cssErrorClass="error"/><br/>
        <sf:label path="password"
                  cssErrorClass="error">Password</sf:label>
        <sf:password path="password" cssErrorClass="error"/><br/>
        <input type="submit" value="Register" />
    </sf:form>

</body>
</html>
