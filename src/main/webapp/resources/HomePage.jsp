<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">

<%@ include file="Header.jsp" %>

<body>

<%@ include file="NavBar.jsp" %>

<div class="main-content">
    <div class="main-content-header">
        <h2 class="main-header">Last submissions</h2>
        <div class="sub-content">
            <table class="table-main-style">
                <thead class="table-main-style-header">
                <tr>
                    <td>Exercise Name</td>
                    <td>Solution author</td>
                    <td>Date</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody class="table-main-style-body">
                <c:forEach items="${solutionList}" var="user">
                    <tr>
                        <td>${user.getExerciseName()}</td>
                        <td>${user.getUsername()}</td>
                        <td>${user.getUpdated()}</td>
                        <td>
                            <div class="details-btn">
                                <a href="${pageContext.request.contextPath}/solutions/details?solution_id=${user.getSolutionId()}">Details</a>
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