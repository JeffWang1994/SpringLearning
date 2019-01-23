<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<h1><s:message code="com.jeffwang.welcome" /></h1>
<p>This is the homepage!</p>
<a href="<c:url value="/spittles"/> ">Spittles</a>|
<a href="<c:url value="/spitter/register"/> ">Spitters</a>

