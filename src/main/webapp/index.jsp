<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/form.css">
</head>
<body>

<jsp:include page="alert.jsp" />
    <h1>Manager the employees</h1>

<c:choose>
 <c:when test="${empty employees}">
        <div class="message">
            <a href="employee?action=list" class="btn">Get Started</a>
        </div>
    </c:when>


<c:when test="${!message}">

    <form action="employee" method="get" class="search-form">
        <input type="hidden" name="action" value="search">
        <input type="text" name="keyword" placeholder="Search for Name or Email..." class="input-text">
        <input type="submit" value="Search" class="submit-button">
    </form>

    <div class="filter">
    <a href="employee?action=list">All</a>
    <a href="employee?action=filter&post=dev">dev</a>
    <a href="employee?action=filter&position=test">test</a>
    <a href="addEmployee.jsp"> Add Employee</a>
    </div>

  <div class="table-container">
   <table class="container">
	<thead>
		<tr>
			<th><h1>Name</h1></th>
			<th><h1>Email</h1></th>
			<th><h1>Phone</h1></th>
			<th><h1>Department</h1></th>
			<th><h1>Position</h1></th>
			<th><h1>Actions</h1></th>
		</tr>
	</thead>
	<tbody>
    <c:forEach var="employee" items="${employees}">
		<tr>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>${employee.post}</td>
            <td>${employee.position}</td>
            <td>
                <a class="edit" href="employee?action=edit&id=${employee.id}">Edit </a>
                <a class="delete" href="employee?action=delete&id=${employee.id}"> Delete</a>
            </td>
		</tr>
    </c:forEach>
	</tbody>
</table>
</div>
</c:when>
</c:choose>

</body>
</html>
