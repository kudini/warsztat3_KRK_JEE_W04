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
        <h2>Add Group</h2>
        <div class="sub-content">
            <form action="/app/admin/group/edit" , method="POST" id="group_form">
                <span>Group name</span>
                <input type="text" value="${usersGroups.getName()}" placeholder="user group name">
                <div>
                    <button type="submit" form="group_form" class="accept-btn">Submit</button>
                </div>
            </form>
        </div>

    </div>

</div>

</body>
</html>