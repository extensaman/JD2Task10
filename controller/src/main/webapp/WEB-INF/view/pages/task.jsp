<%--
  Created by IntelliJ IDEA.
  User: Note
  Date: 13.05.2022
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class='d-flex justify-content-start'>
        <form action='#' onclick='javascript:
              window.open("newTask", "_blank", "scrollbars=1,resizable=1,height=300,width=450");'
              name="getForm" method="post">
            <button class="btn btn-outline-primary">
                <i class="bi bi-plus-square">&nbsp&nbspAdd Task</i>
            </button>
        </form>
    </div>
</div>
<div class="row mx-2">
    <c:if test="${not empty sessionScope.tasks}">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">Task name</th>
                <th class="col">Curse</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="task" items="${tasks}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${task.name}</td>
                    <td class="col">${task.curse}</td>
                    <td class="col-1">
                        <a href='#' onclick='javascript:
                                window.open("task?taskId=${task.id}", "_blank"
                                , "scrollbars=1,resizable=1,height=300,width=450");
                                ' title='Assessment'>Assessment</a>
                    <td class="col-1">
                        <form action="${pageContext.request.contextPath}/deleteTask" name="deleting"
                              method="get">
                            <input type="hidden" name="taskId" value="${task.id}"/>
                            <button class="btn btn-outline-secondary"><i class="bi bi-trash"></i></button>
                        </form>
                    </td>
                    </td>
                    <td class="col">
                        <form action='#' onclick='javascript:
                                window.open("updateTask?taskId=${task.id}"
                                , "_blank", "scrollbars=1,resizable=1,height=300,width=450");'
                              name="getForm" method="post">
                            <button class="btn btn-outline-secondary">
                                <i class="bi bi-pencil">&nbsp&nbspUpdate Task</i>
                            </button>
                        </form>
                    </td>
                    <td class="col">
                        <form action='#' onclick='javascript:
                                window.open("newAssessment?taskId=${task.id}"
                                , "_blank", "scrollbars=1,resizable=1,height=300,width=450");'
                              name="getForm" method="post">
                            <button class="btn btn-outline-secondary">
                                <i class="bi bi-pencil">&nbsp&nbspAdd Assessment</i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
