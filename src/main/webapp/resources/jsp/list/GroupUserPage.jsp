<%--
  Created by IntelliJ IDEA.
  User: katsu
  Date: 19.04.2020
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>

<html>
<%@ include file="../utils/Header.jsp" %>

<body>

<%@ include file="../utils/NavBar.jsp" %>
<div class="main-content">
    <div class="main-field">
        <div><h2 class="main-header">${groupName} group users:</h2></div>
        <div class="sub-content">
            <table class="table-main-style">
                <thead class="table-main-style-header">
                <tr>
                    <td>Name</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody class="table-main-style-body">

                <c:forEach items="${usersList}" var="exercise">
                    <tr>
                        <td>${exercise.getUsername()}</td>
                        <td>
                            <div class="details-btn">
                                <a href="${pageContext.request.contextPath}/app/groups/group/user?user_id=${exercise.getId()}">Details</a>
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
