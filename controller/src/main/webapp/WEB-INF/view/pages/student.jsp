<%--
  Created by IntelliJ IDEA.
  User: yusikov_av
  Date: 13.05.2022
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row mx-2">
    <c:if test="${not empty sessionScope.students}">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">ID</th>
                <th class="col">Student name</th>
                <th class="col">Assessment count</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${student.id}</td>
                    <td class="col">${student.studentName}</td>
                    <td class="col">${student.assessmentCount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
