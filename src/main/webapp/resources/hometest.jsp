<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: katsu
  Date: 09.04.2020
  Time: 00:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr class="d-flex">
        <th class="col-1">ID</th>
        <th class="col-2">NAME</th>
        <th class="col-7">DESCRIPTION</th>
        <th class="col-2 center">AKCJE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${solutionList}" var="group">
        <tr>
            <th scope="row">${group.getId()}</th>
            <td> ${group.getExcerciseId()} </td>
            <td> ${group.getDescription()} </td>
            <td>
                <a href="#"
                         class="b0tn btn-info square-0 text-light m-1">Details</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
