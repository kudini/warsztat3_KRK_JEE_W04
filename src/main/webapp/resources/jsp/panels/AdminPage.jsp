<%--
  Created by IntelliJ IDEA.
  User: katsu
  Date: 19.04.2020
  Time: 13:55
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
                <a href="/">Back</a>
            </div>

            <p>
            <h2 class="main-header">Admin Panel</h2></p>
        </div>
    </div>
    <div class="sub-content">
        <div class="sub-content-table">
            <table class="table-main-style-panels">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/app/admin/exercises"><span class="panel-btn">Exercises</span></a>
                    </td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/app/admin/groups"><span class="panel-btn">User Groups</span></a>
                    </td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/app/admin/users"><span
                            class="panel-btn">Users</span></a></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
