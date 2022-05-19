<%--
  Created by IntelliJ IDEA.
  User: Note
  Date: 13.05.2022
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.course}">
    <div class="row mx-2">
    <h1>Course</h1>
    <table class="table">
        <thead>
        <tr>
            <th class="col">№</th>
            <th class="col">ID</th>
            <th class="col">Course name</th>
            <th class="col">Edit</th>
            <th class="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${course}" varStatus="status">
            <tr>
                <td class="col">${status.index+1}</td>
                <td class="col">${course.id}</td>
                <td class="col">${course.courseProgram}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
