<%--
  Created by IntelliJ IDEA.
  User: katsu
  Date: 19.04.2020
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ include file="../utils/Header.jsp" %>

<body>

<%@ include file="../utils/NavBar.jsp" %>
<div class="main-content">
    <div class="main-content-header">
        <h2 class="main-header">Add Group</h2>
        <div class="sub-content">
            <form action="/app/admin/users/edit" , method="POST" id="group_form">
                <table>
                    <tr>
                        <td>
                            <span>Username</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name="username" type="text" value="${user.getUsername()}" placeholder="Username"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Email</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name="email" type="email" value="${user.getEmail()}" placeholder="Email" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Password</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name="password" type="password" value="${user.getPassword()}" placeholder="Password"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>User Group Id</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select name="user_group_id">
                                <c:forEach items="${groups}" var="group">
                                    <c:if test="${group.getId()==user.getUserGroupId()}">
                                        <option selected value="${group.getId()}">${group.getName()}</option>
                                    </c:if>
                                    <c:if test="${group.getId()!=user.getUserGroupId()}">
                                        <option value="${group.getId()}">${group.getName()}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>

                <div>
                    <button type="submit" form="group_form" class="accept-btn">Submit</button>
                </div>
            </form>
        </div>

    </div>

</div>

</body>
</html>