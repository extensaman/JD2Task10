<%--
  Created by IntelliJ IDEA.
  User: yusikov_av
  Date: 13.05.2022
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <h1>Student</h1>
    <div class='d-flex justify-content-start'>
        <form action='#' onclick='javascript:
              window.open("newStudent", "_blank", "scrollbars=1,resizable=1,height=300,width=450");'
              name="getForm" method="post">
            <button class="btn btn-outline-primary">
                <i class="bi bi-plus-square">&nbsp&nbspAdd Student</i>
            </button>
        </form>
    </div>
</div>
<div class="row mx-2">
    <c:if test="${not empty sessionScope.students}">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">ID</th>
                <th class="col">Student name</th>
                <th class="col">Assessment count</th>
                <th class="col">Courses</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${student.id}</td>
                    <td class="col">${student.studentName}</td>
                    <td class="col">${student.assessmentCount}</td>
                    <td class="col-1">
                        <a href='#' onclick='javascript:
                                window.open("assessment?studentId=${student.id}", "_blank", "scrollbars=1,resizable=1,height=300,width=450");
                                ' title='Assessment'>Assessment</a>
                    <td class="col-1">
                    <td class="col">
                        <div class="dropdown">
                            <a class="btn btn-outline-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="bi bi-list">&nbsp&nbspChoose</i>
                            </a>

                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </div>
                    </td>

                    <td class="col">
                        <a href='#' onclick='javascript:
                                window.open("studentCourses?studentId=${student.id}", "_blank", "scrollbars=1,resizable=1,height=300,width=450");
                                ' title='Courses'>Courses</a>
                    </td>

                    <td class="col-1">
                        <form action="${pageContext.request.contextPath}/deleteStudent" name="deleting"
                              method="get">
                            <input type="hidden" name="studentId" value="${student.id}"/>
                            <button class="btn btn-outline-secondary"><i class="bi bi-trash"></i></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
