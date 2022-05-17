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
                <th class="col">Assessment</th>
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
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
