<%--
  Created by IntelliJ IDEA.
  User: Note
  Date: 13.05.2022
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class='d-flex justify-content-start'>
        <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#addMentorModal">
            <i class="bi bi-plus-square">&nbsp&nbspAdd mentor</i>
        </button>
        <!-- Modal -->
        <div class="modal fade" id="addMentorModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row mx-2">
    <c:if test="${not empty sessionScope.mentors}">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">Mentor name</th>
                <th class="col"></th>
                <th class="col">Courses</th>
                <th class="col-1"></th>  <%--DELETE ICON--%>
                <th class="col-1"></th>  <%--EDIT ICON--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="mentor" items="${mentors}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${mentor.mentorName}</td>
                    <td class="col-1">
                        <div class="dropdown">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Choose 'Course'
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <c:forEach var="mentorCourse" items="${mentor.courses}" varStatus="status">
                                    <li><a class="dropdown-item" href="#">${mentorCourse.courseProgram}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </td>
                    <td class="col">fffffffffffffff fffffffff fffffffff</td>
                    <td class="col-1">
                        <form action="${pageContext.request.contextPath}/home?pageName=mentor" name="deleting"
                              method="post">
                            <input type="hidden" name="delete" value="${mentor.id}"/>
                            <button class="btn btn-outline-secondary"><i class="bi bi-trash"></i></button>
                        </form>
                    </td>
                    <td class="col-1">
                        <form action="${pageContext.request.contextPath}/home?pageName=mentor" name="editing"
                              method="post">
                                <input type="hidden" name="edit" value="${mentor.id}"/>
                                <button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#editingModal">
                                    <i class="bi bi-pencil"></i>
                                </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
