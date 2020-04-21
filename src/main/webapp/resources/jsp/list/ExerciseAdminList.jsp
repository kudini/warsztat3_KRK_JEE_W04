<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">

<%@ include file="../utils/Header.jsp" %>

<body>

<%@ include file="../utils/NavBar.jsp" %>

<div class="main-content">
    <div class="main-content-header">
        <div class="main-header-container">

            <h2 class="main-header">Exercises List:</h2>
            <div class="add-btn">
                <a href="${pageContext.request.contextPath}/app/admin/exercise/add${exercise.getId()}">Add</a>
            </div>
        </div>
        <div class="sub-content">
            <table class="table-main-style">
                <thead class="table-main-style-header">
                <tr>
                    <td>Exercise Name</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody class="table-main-style-body">
                <c:forEach items="${exercises}" var="users">
                    <tr>
                        <td>${users.getTitle()}</td>
                        <td class="actions-table-2">
                            <div class="details-btn">
                                <a href="${pageContext.request.contextPath}/app/exercise/details?exercise_id=${users.getId()}">Details</a>
                            </div>
                            <div class="edit-btn">
                                <a href="${pageContext.request.contextPath}/app/admin/exercise/edit?exercise_id=${users.getId()}">Edit</a>
                            </div>
                            <div class="delete-btn">
                                <a href="${pageContext.request.contextPath}/app/admin/exercise/delete?exercise_id=${users.getId()}">Delete</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</div>
</body>
</html>