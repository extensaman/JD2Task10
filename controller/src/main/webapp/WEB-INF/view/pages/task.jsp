<%--
  Created by IntelliJ IDEA.
  User: Note
  Date: 13.05.2022
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row mx-2">
    <h1>Task</h1>
    <c:if test="${not empty sessionScope.tasks}">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">ID</th>
                <th class="col">Task name</th>
                <th class="col">Curse</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="task" items="${tasks}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${task.id}</td>
                    <td class="col">${task.name}</td>
                    <td class="col">${task.curse}</td>
                    <td class="col">
                        <a class="col" data-bs-toggle="collapse" href="#collapseExample${status.index+1}">Assessment</a>
                    </td>
                    <div class="collapse" id="collapseExample${status.index+1}">
                            ${task.assessments}
                           <%-- ${task.assessment.toString}--%>
               <%-- <c:forEach var="assessment" items="${task.assessment}" varStatus="status">
                    <tr>
                        <td class="col">${status.index+1}</td>
                        <td class="col">${assessment.id}</td>
                    </tr>
                </c:forEach>--%>
                    </div>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
