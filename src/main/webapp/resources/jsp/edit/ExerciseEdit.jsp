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
        <h2 class="main-header">Edit Exercise</h2>
        <div class="sub-content">

            <form action="${pageContext.request.contextPath}/app/admin/exercise/edit" method="POST" id="group_form">
                <table>
                    <tr>
                        <td>
                            <span>Edit your Exercise </span>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name="title" id="exercise-title" placeholder="Write Title"
                                   value="${exercise.getTitle()}">
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <label for="exercise-description">Exercise Description</label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <textarea name="description" id="exercise-description" rows="10" cols="60"
                                      placeholder="Enter your description here...">${exercise.getDescription()}</textarea>
                        </td>
                    </tr>
                </table>
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
