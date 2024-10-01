<!-- index.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
</head>
<body>
    <h1>${test}</h1>
    
    <c:if test="${not empty employees}">
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Department</th>
                <th>Position</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <%-- <td>${employee.id}</td> --%>
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.post}</td>
                    <td>${employee.position}</td>
                    <td>
                        <a href="employee?action=edit&id=${employee.id}">Edit</a>
                        <a href="employee?action=delete&id=${employee.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
