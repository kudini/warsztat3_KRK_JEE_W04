<!DOCTYPE html>
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">

<%@ include file="../utils/Header.jsp" %>

<body>

<%@ include file="../utils/NavBar.jsp" %>
<div class="main-content">
    <div class="main-content-header">
        <h2 class="main-header">Group List</h2>
        <div class="sub-content">
            <table class="table-main-style">
                <thead class="table-main-style-header">
                <tr>
                    <td>Group Name</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody class="table-main-style-body">

                <c:forEach items="${usersGroups}" var="users">
                    <tr>
                        <td>${users.getName()}</td>
                        <td>
                            <div class="details-btn">
                                <a href="${pageContext.request.contextPath}/app/groups/group?user_group_id=${users.getId()}&group_name=${users.getName()}">Users</a>
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