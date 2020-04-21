<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">

<%@ include file="../utils/Header.jsp" %>

<body>

<%@ include file="../utils/NavBar.jsp" %>

<div class="main-content">
    <div class="main-content-header">
        <h2 class="main-header">Exercise List</h2>
        <div class="sub-content">
            <table class="table-main-style">
                <thead class="table-main-style-header">
                <tr>
                    <td>Exercise Name</td>
                    <td>Description</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody class="table-main-style-body">
                <c:forEach items="${exercises}" var="users">
                    <tr>
                        <td>${users.getTitle()}</td>
                        <td>${users.getDescription()}</td>
                        <td class="actions-table-1">
                            <div class="details-btn">
                                <a href="${pageContext.request.contextPath}/app/solutions/list?exercise_id=${users.getId()}">List</a>
                            </div>
                            <div class="add-btn-table">
                                <a href="${pageContext.request.contextPath}/app/user/solution/add?exercise_id=${users.getId()}">Add</a>
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