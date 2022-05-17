<%--
  Created by IntelliJ IDEA.
  User: yusikov_av
  Date: 17.05.2022
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="${pageContext.request.contextPath}/home?pageName=mentor" name="inserting"
      method="post">
    <div class="gy-5">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6 text-secondary form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com">
                <label for="floatingInput">&nbspMentor name</label>
            </div>
        </div>

        <c:choose>
            <c:when test="${not empty sessionScope.courses}">
                <c:forEach var="course" items="${courses}" varStatus="status">
                    <div class="row">
                        <div class="col-4"></div>
                        <div class="col-5 form-check form-switch">
                            <input class="col-1 form-check-input"
                                   type="checkbox"
                                   role="switch"
                                   name="courseId"
                                   value="${course.id}"
                                   id="flexSwitchCheckCourse">
                            <label class="col-4 form-check-label"
                                   for="flexSwitchCheckCourse">${course.courseProgram}</label>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <span class="border-primary text-danger">No courses without mentor</span>
            </c:otherwise>
        </c:choose>
        <c:forEach var="admin" items="${admins}" varStatus="status">
            <div class="row">
                <div class="col-4"></div>

                <div class="col-5 form-check">
                    <input class="form-check-input"
                           type="radio"
                           name="mentorId"
                           value="${admin.id}"
                           id="flexRadioDefault1">
                    <label class="col-4 form-check-label"
                           for="flexRadioDefault1">
                            ${admin.adminName}
                    </label>
                </div>


                    <%--
                                    <div class="col-5 form-check form-switch">
                                        <input class="col-1 form-check-input"
                                               type="checkbox"
                                               role="switch"
                                               name="mentorId"
                                               value="${admin.id}"
                                               id="flexSwitchCheckAdmin">
                                        <label class="col-4 form-check-label" for="flexSwitchCheckAdmin">${admin.adminName}</label>
                                    </div>
                    --%>
            </div>
        </c:forEach>
        <button class="btn btn-outline-primary"><i class="bi bi-save"></i>&nbsp;Save</button>
    </div>
</form>

