<!DOCTYPE html>
<html>

<head>
    <title> Modify Employee</title>
    <link rel="stylesheet" href="./css/addEmployee.css">
</head>

<body>
    <h1 class="employeeTitle">Modify Employee</h1>
<div class="form-container">
    <form action="employee" method="post" class="employee-form">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${employee.id}">
        <label for="name">Name:</label>
        <input type="text" class="input-field" value="${employee.name}" name="name" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" class="input-field" value="${employee.email}" name="email" required>
        <br>
        <label for="post">Post:</label>
        <input type="post" class="input-field" value="${employee.post}" name="post" required>
        <br>
        <label for="phone">Phone:</label>
        <input type="tel" class="input-field" value="${employee.phone}" name="phone" required>
        <br>
        <label for="position">Position:</label>
        <input type="tel" class="input-field" value="${employee.position}" name="position" required>
        <br>
        <input type="submit" class="submit-button" value="modify Employee">
    </form>
    </div>

</body>

