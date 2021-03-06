<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">

<%@ include file="../utils/Header.jsp" %>

<body>

<%@ include file="../utils/NavBar.jsp" %>

<div class="main-content">
    <div class="main-content-header">
        <h2 class="main-header">Users in database:</h2>
        <div class="sub-content">
            <table class="table-main-style">
                <thead class="table-main-style-header">
                <tr>
                    <td>Username</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody class="table-main-style-body">
                <c:forEach items="${usersList}" var="users">
                    <tr>
                        <td>${users.getUsername()}</td>
                        <td>
                            <div class="details-btn">
                                <a href="${pageContext.request.contextPath}/app/admin/users/edit?user_id=${users.getId()}">Edit</a>
                            </div>
                            <div class="delete-btn">
                                <a href="${pageContext.request.contextPath}/app/admin/users/delete?user_id=${users.getId()}">Delete</a>
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