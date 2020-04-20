<%--
  Created by IntelliJ IDEA.
  User: katsu
  Date: 19.04.2020
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ include file="../utils/Header.jsp" %>

<body>

<%@ include file="../utils/NavBar.jsp" %>
<div class="main-content">
    <div class="main-content-header">
        <div class="main-content-nav">
            <div class="back-btn">
                <a href="/users">Back</a>
            </div>
        </div>
        <p>
        <h2 class="main-header">${user.getUsername()} user details:</h2></p>
        <p>Name: ${user.getUsername()}</p>
        <p>Email: ${user.getEmail()}</p>
    </div>
    <div class="main-field">

        <div class="sub-content">
            <div><h4>Added task Solutions:</h4></div>
            <table class="table-main-style">
                <thead class="table-main-style-header">
                <tr>
                    <td>Exercise Name</td>
                    <td>Date</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody class="table-main-style-body">

                <c:forEach items="${solutions}" var="user">
                    <tr>
                        <td>${user.getExerciseName()}</td>
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
