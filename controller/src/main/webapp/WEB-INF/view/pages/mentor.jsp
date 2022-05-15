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
                <th class="col">Courses</th>
<%--                <th class="col">Admin</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="mentor" items="${mentors}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${mentor.mentorName}</td>
<%--                    <td class="col">${mentor.assessmentCount}</td>--%>
                    <td class="col">
                        <div class="dropdown">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown link
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
