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
                <a href="/app/admin/exercises">Back</a>
            </div>
        </div>
        <p>
        <h2 class="main-header">Exercise details:</h2></p>
    </div>
    <div class="sub-content">
        <div class="sub-content-table">
            <table>
                <tr>
                    <td>${exercise.getDescription()}</td>
                </tr>
            </table>
        </div>
    </div>
</div>

</body>
</html>
