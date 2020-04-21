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
            <a href="${pageContext.request.contextPath}/groups">Users Groups</a>
            <a href="${pageContext.request.contextPath}/users">Users</a>
            <a href="${pageContext.request.contextPath}/exercises">Exercises</a>
            <c:if test="${user.getUserGroupId()==1}">
                <a href="${pageContext.request.contextPath}/admin/panel">Admin Panel</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </c:if>


    </div>

</div>