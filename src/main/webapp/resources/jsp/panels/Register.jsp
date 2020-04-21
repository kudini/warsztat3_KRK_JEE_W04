<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">

<%@ include file="../utils/Header.jsp" %>

<body>

<%@ include file="../utils/NavBar.jsp" %>

<div class="main-content">
    <div class="main-content-header">
        <h2 class="main-header">Register</h2>
        <div class="sub-content">
            <form method="POST" , action="/register">
                <table>
                    <tr>
                        <div class="login-username">
                            <td>
                                <span class="login-text">Username:</span>
                            </td>
                            <td>
                                <input id="username" name="username" type="text" placeholder="Enter your Username"
                                       required>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="login-username">
                            <td>
                                <span class="login-text">Email:</span>
                            </td>
                            <td>
                                <input id="login" name="login" type="email" placeholder="Enter your Email" required>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="login-password">
                            <td>
                                <span class="login-text">Password:</span>
                            </td>
                            <td>
                                <input id="password" name="password" type="password" placeholder="Enter your Password"
                                       required>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="login-re-password">
                            <td>
                                <span class="login-text">Repassword:</span>
                            </td>
                            <td>
                                <input id="repassword" name="repassword" type="password" placeholder="Re-enter your Password" required>
                            </td>
                        </div>
                    </tr>
                </table>
                <div class="submit-btn">
                    <input type="submit" value="submit" id="submit-btn-1">
                </div>
            </form>
            <div>${message}</div>
        </div>

    </div>

</div>
</body>
</html>