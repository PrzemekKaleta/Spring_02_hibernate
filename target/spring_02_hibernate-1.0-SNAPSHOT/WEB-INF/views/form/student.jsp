<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 22.06.19
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>student</title>
</head>
<body>
<h1>student</h1>

<form:form method="POST" modelAttribute="student">
    Name:<form:input path="firstName"></form:input><br>
    Surname:<form:input path="lastName"></form:input><br>
    Sex   Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/><br>
    Country:<form:select path="country" items="${countries}"/><br>
    Notes:<form:textarea path="notes"></form:textarea><br>
    Mailing List:<form:checkbox path="mailingList" /><br>
    Programing Skils:<form:select path="programingList" items="${programingSkills}" multiple="true"/><br>
    Hobbies: <form:checkboxes items="${hobbies}" path="hobbies" /><br>
    <input type="submit" value="save">
</form:form>


</body>
</html>
