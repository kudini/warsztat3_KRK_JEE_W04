<%@ page import="pl.coderslab.model.Users" %>
<div id="navbar">
    <div id="main-page-nav">
        <a href="/"><span class="logo-1">CS</span></a>
    </div>
    <div id="main-nav-content">
        <%
            Users user= (Users) session.getAttribute("user");
        %>
        <c:if test="${isLogged==null}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
            <a href="${pageContext.request.contextPath}/register">Register</a>
        </c:if>
        <c:if test="${isLogged!=null}">
            <a href="${pageContext.request.contextPath}/app/groups">Users Groups</a>
            <a href="${pageContext.request.contextPath}/app/users">Users</a>
            <a href="${pageContext.request.contextPath}/app/exercises">Exercises</a>
            <c:if test="${user.getUserGroupId()==initParam['admin-group-id']}">
                <a href="${pageContext.request.contextPath}/app/admin/panel">Admin Panel</a>
            </c:if>
            <c:if test="${user.getUserGroupId()!=initParam['admin-group-id']}">
                <a href="${pageContext.request.contextPath}/app/user/solutions">My Solutions</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </c:if>


    </div>

</div>