<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 23.06.19
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>publisher</title>
</head>
<body>
<t1>Publisher page</t1>

<form:form method="POST" modelAttribute="publisher">
    Name:<form:input path="name"></form:input><br>
    NIP:<form:input path="nip"></form:input><br>
    REGON:<form:input path="regon"></form:input><br>
    BOOKS:<br>
    <input type="submit" value="save">

</form:form>

</body>
</html>
