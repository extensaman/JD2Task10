<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.admin}">

    <table class="table">
        <thead>
        <tr>
            <th class="col">№</th>
            <th class="col">ID</th>
            <th class="col">Mentor name</th>
            <th class="col">Edit</th>
            <th class="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="adminMentor" items="${adminMentor}" varStatus="status">
            <tr>
                <td class="col">${status.index+1}</td>
                <td class="col">${adminMentor.id}</td>
                <td class="col">${adminMentor.nameMentor}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</div>

