<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: s-afe
  Date: 18.05.2022
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Update Task</title>
</head>
<body>
<h1>Update Task</h1>

<fieldset>
    <form action="updateTask" method="post">
        Name <input name="Name" class='lf--input' value="${task.name}" type="Name"><br>
        Curse: <select name="Course">
        <option selected="selected" value="1">${task.curse}</option>
        <c:forEach var="course" items="${courses}" varStatus="status">
            <option value="${course.id}">${course.name}</option>
        </c:forEach>
    </select><br>
        <input type='submit' value='Create'>
    </form>
</fieldset>
</body>
</html>