<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: s-afe
  Date: 19.05.2022
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<h1>New Assessment</h1>

<fieldset>
    <form action="newAssessment" method="post">

        Student: <select name="studentId">
        <c:forEach var="students" items="${students}" varStatus="status">
            <option value="${students.id}">${students.studentName}</option>
        </c:forEach>
    </select>
        Mark: <select name="mark">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
        <option>10</option>
    </select><br>
        <p><b>Feedback:</b></p>
        <p><textarea name="feedback"></textarea></p>
        <input type='submit' value='Create'>
    </form>
</fieldset>
</body>
</html>
