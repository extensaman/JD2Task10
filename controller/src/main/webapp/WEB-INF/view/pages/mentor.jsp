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
        <form action="${pageContext.request.contextPath}/home?pageName=mentorinput" name="getForm"
              method="post">
            <input type="hidden" name="action" value="getForm"/>
            <input type="hidden" name="description" value="new"/>
            <button class="btn btn-outline-primary">
                <i class="bi bi-plus-square">&nbsp&nbspAdd mentor</i>
            </button>
        </form>
    </div>
</div>
<div class="row mx-2">
    <c:if test="${not empty sessionScope.mentors}">
        <table class="table">
            <thead>
            <tr>
                <th class="col">№</th>
                <th class="col">Mentor name</th>
                <th class="col">Courses</th>
                <th class="col-1"></th>
                    <%--DELETE ICON--%>
                <th class="col-1"></th>
                    <%--EDIT ICON--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="mentor" items="${mentors}" varStatus="status">
                <tr>
                    <td class="col">${status.index+1}</td>
                    <td class="col">${mentor.mentorName}</td>
                    <td class="col-1">
                        <div class="dropdown">
                            <a class="btn btn-outline-secondary dropdown-toggle" href="#" role="button"
                               id="dropdownMenuLink"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="bi bi-list">&nbsp&nbspChoose</i>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <c:forEach var="mentorCourse" items="${mentor.courses}" varStatus="status">
                                    <c:set var="mentorCourseAdmin" value="${mentorCourse.adminField.adminName}"/>
                                    <li>
                                        <button class="dropdown-item js-course-detail"
                                                data-bs-toggle="modal"
                                                data-bs-target="#courseDetail"
                                                data-course-program="${mentorCourse.courseProgram}"
                                                data-course-admin="${mentorCourseAdmin}"
                                                data-mentor-name="${mentor.mentorName}">
                                                ${mentorCourse.courseProgram}
                                        </button>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </td>
                    <td class="col-1">
                        <form action="${pageContext.request.contextPath}/home?pageName=mentor" name="deleting"
                              method="post">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="description" value="${mentor.id}"/>
                            <button class="btn btn-outline-secondary"><i class="bi bi-trash"></i></button>
                        </form>
                    </td>
                    <td class="col-1">
                        <form action="${pageContext.request.contextPath}/home?pageName=mentor" name="editing"
                              method="post">
                            <input type="hidden" name="action" value="getForm"/>
                            <input type="hidden" name="description" value="edit"/>
                            <button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal"
                                    data-bs-target="#editingModal">
                                <i class="bi bi-pencil"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>



    <!-- Модальное окно -->
    <div class="modal fade" id="courseDetail" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title" id="exampleModalLabel">Info about courses of <span class="dmn"></span></h6>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col">
                            <span class="text-primary">Course description</span>
                        </div>
                        <div class="col">
                            <span class="text-secondary dcp"/>
                        </div>
                    </div>
                    <hr/>
                    <div class="row">
                        <div class="col">
                            <span class="text-primary">Course admin name</span>
                        </div>
                        <div class="col">
                            <span class="text-secondary dca"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(function () {
            $(".js-course-detail").click(
                function () {
                    var dataCourseProgram = $(this).attr('data-course-program');
                    var dataCourseAdmin = $(this).attr('data-course-admin');
                    var dataMentorName = $(this).attr('data-mentor-name');

                    $(".dcp").text(dataCourseProgram);
                    $(".dca").text(dataCourseAdmin);
                    $(".dmn").text(dataMentorName);
                    $("#hide1").attr('value', dataCourseProgram);
                    $("#hide2").attr('value', dataCourseAdmin);
                    $("#hide3").attr('value', dataMentorName);
                })
        });
    </script>
</div>