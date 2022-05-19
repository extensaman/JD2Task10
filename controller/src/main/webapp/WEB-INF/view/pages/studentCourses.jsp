<%--
  Created by IntelliJ IDEA.
  User: s-afe
  Date: 15.05.2022
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
<div class="row mx-2">
    <h1>Courses</h1>
    <c:if test="${empty sessionScope.courses}">
        <h1>no data</h1>
    </c:if>
    <c:if test="${not empty sessionScope.courses}">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">ID</th>
                <th class="col">Course program</th>
                <th class="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="courses" items="${courses}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${courses.id}</td>
                    <td class="col">${courses.courseProgram}</td>
                    <c:if test="${not empty courses.studentId}">
                        <td class="col">
                            <button class="btn-link" onclick="location.href='leaveCourse?courseId=${courses.id}&studentId=${studentId}'">Leave course</button>
                        </td>
                    </c:if>
                    <c:if test="${empty courses.studentId}">
                        <td class="col">
                            <button class="btn-link" onclick="location.href='joinCourse?courseId=${courses.id}&studentId=${studentId}'">Join course</button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
