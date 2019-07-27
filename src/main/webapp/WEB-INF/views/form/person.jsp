<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 22.06.19
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>person</title>
</head>
<body>
<t1>Person Page</t1>
<%--<form method="POST">--%>
    <%--name: <input type="text" name="login"><br>--%>
    <%--password: <input type="text" name="password"><br>--%>
    <%--email: <input type="text" name="email"><br>--%>
    <%--<input type="submit" value="save">--%>
<%--</form>--%>



<form:form method="POST" modelAttribute="person">
    name:<form:input path="login"></form:input><br>
    password:<form:input path="password"></form:input><br>
    email:<form:input path="email"></form:input><br>
    <input type="submit" value="save">
</form:form>
</body>
</html>
