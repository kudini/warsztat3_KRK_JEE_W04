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
        <h2 class="main-header">Add Solution</h2>
        <div class="sub-content">
            <form action="${pageContext.request.contextPath}/app/user/solution/add" method="POST" id="group_form">
                <span>Write your solution </span>
                <label for="solution-description">Solution Description</label>
                <textarea name="solution" id="solution-description" rows="10" cols="60" placeholder="Enter your solution here..." ></textarea>
            </form>
            <br>
            <div>
                <button type="submit" form="group_form" class="accept-btn">Submit</button>
            </div>
        </div>

    </div>

</div>

</body>
</html>
