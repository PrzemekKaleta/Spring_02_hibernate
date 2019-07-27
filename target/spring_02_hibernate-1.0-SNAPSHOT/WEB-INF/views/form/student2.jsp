<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 22.06.19
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>student2</title>
</head>
<body>
<form:form method="POST" modelAttribute="studentNew">
    Name:<form:input path="firstName"></form:input><br>
    Surname:<form:input path="lastName"></form:input><br>
    Group:<form:select path="studentGroup" items="${groups}"
                 itemValue="id" itemLabel="name"/>

    <input type="submit" value="save">
</form:form>

</body>
</html>
