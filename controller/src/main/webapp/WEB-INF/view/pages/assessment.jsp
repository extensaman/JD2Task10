<%--
  Created by IntelliJ IDEA.
  User: s-afe
  Date: 15.05.2022
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css"/>
<div class="row mx-2">
    <h1>${taskName}</h1>
    <c:if test="${empty sessionScope.assessments}">
        <h1>no data</h1>
    </c:if>
    <c:if test="${not empty sessionScope.assessments}">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">Student name</th>
                <th class="col">Mark</th>
                <th class="col">Feedback</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="assessment" items="${assessments}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${assessment.studentName}</td>
                    <td class="col">${assessment.mark}</td>
                    <td class="col">${assessment.feedback}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
