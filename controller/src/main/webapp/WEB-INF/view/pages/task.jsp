<%--
  Created by IntelliJ IDEA.
  User: Note
  Date: 13.05.2022
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class='d-flex justify-content-start'>
        <button class="btn btn-outline-primary js-course-detail"
                data-bs-toggle="modal"
                data-bs-target="#taskForm"
                data-task-name="${task.name}"
                data-task-curse="${task.curse}"
                data-task-action="newTask">
            <i class="bi bi-plus-square">&nbsp&nbspAdd Task</i>
        </button>
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
                    <td class="col">${task.curse.name}</td>
                    <td class="col-1">
                        <div class="dropdown">
                            <button class="btn btn-outline-secondary">
                                <i class="bi bi-list">&nbsp&nbspChoose</i>
                            </button>
                            <div class="dropdown-content">
                                <button class="dropdown-item js-course-detail"
                                        data-bs-toggle="modal"
                                        data-bs-target="#taskForm"
                                        data-task-name="${task.name}"
                                        data-task-id="${task.id}"
                                        data-task-curse="${task.curse.id}"
                                        data-task-action="update"> Update Task
                                </button>
                                <form action="${pageContext.request.contextPath}/home?pageName=assessment" name="del"
                                      method="post">
                                    <input type="hidden" name="taskId" value="${task.id}"/>
                                    <input type="hidden" name="taskName" value="${task.name}"/>
                                    <button class="dropdown-item">Assessment</button>
                                </form>
                                <form action="${pageContext.request.contextPath}/home?pageName=task" name="deleting"
                                      method="post">
                                    <input type="hidden" name="taskId" value="${task.id}"/>
                                    <input type="hidden" name="action" value="delete"/>
                                    <button class="dropdown-item">Delete Task</button>
                                </form>
                            </div>
                        </div>
                    </td>
                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

<div class="modal fade" id="taskForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/home?pageName=task" method="post">
                <div class="modal-body">
                    Name <input id="taskName" name="Name" class='lf--input' type="Name"><br><br>
                    Curse: <select id="taskCurse" name="Course">
                    <c:forEach var="course" items="${courses}" varStatus="status">
                        <option value="${course.id}">${course.name}</option>
                    </c:forEach>
                </select><br>
                    <input id="action" type="hidden" name="action"/>
                    <input id="taskId" type="hidden" name="taskId"/>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<style>
    .dropdown {
        position: relative;
        display: inline-block;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f1f1f1;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        z-index: 1;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {
        background-color: #ddd;
    }

    .dropdown:hover .dropdown-content {
        display: block;
    }
</style>
<script>
    $(function () {
        $(".js-course-detail").click(
            function () {
                var dataTaskName = $(this).attr('data-task-name');
                var dataTaskId = $(this).attr('data-task-id');
                var dataTaskCurse = $(this).attr('data-task-curse');
                var dataTaskAction = $(this).attr('data-task-action');
                $("#taskName").val(dataTaskName)
                $("#taskCurse").val(dataTaskCurse)
                $("#action").val(dataTaskAction)
                $("#taskId").val(dataTaskId)
            })
    });
</script>








