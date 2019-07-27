<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 23.06.19
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>author</title>
</head>
<body>
<t1>Author Page</t1>

<form:form method="POST" modelAttribute="author">
    First name:<form:input path="firstName"></form:input><br>
    <form:errors path="firstName"/><br>
    Last name:<form:input path="lastName"></form:input><br>
    <form:errors path="lastName"/><br>
    PESEL name:<form:input path="pesel"></form:input><br>
    <form:errors path="pesel"/><br>
    Email name:<form:input path="email"></form:input><br>
    <form:errors path="email"/><br>

    <input type="submit" value="save">
</form:form>

</body>
</html>
