<%--
  Created by IntelliJ IDEA.
  User: przemo
  Date: 23.06.19
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>validation</title>
</head>
<body>
<t1>Validation Page</t1>

<p>

    <c:forEach items="${info}" var="inf">

        ${inf}<br>

    </c:forEach>
</p>

</body>
</html>
