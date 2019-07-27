<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 22.06.19
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>book</title>

    <form:form method="POST" modelAttribute="book">
        Title:<form:input path="title"></form:input><br>
        <form:errors path="title" cssClass="error"/>
        Publisher:<form:select path="publisher" items="${publishers}"
                           itemValue="id" itemLabel="name"/>

        <input type="submit" value="save">
    </form:form>

</head>
<body>

</body>
</html>
