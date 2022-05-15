<%--
  Created by IntelliJ IDEA.
  User: Note
  Date: 13.05.2022
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <button class="btn"><i class="bi bi-trash"></i></button>
                        </form>
                    </td>
                    <td class="col-1">
                        <form action="${pageContext.request.contextPath}/home?pageName=mentor" name="deleting"
                              method="post">
                            <c:set var="id" value=" ${mentor.id}"/>
                            ${pageContext.request.setAttribute('delete',id)}
                            <c:out value="${pageContext.session.getAttribute('delete')}"/>
                            <%--<input name="delete" value="${mentor.id}">--%>
                                <button class="btn"><i class="bi bi-pencil"></i></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
