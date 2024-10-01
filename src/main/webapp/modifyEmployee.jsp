<!DOCTYPE html>
<html>

<head>
    <title> Modify Employee</title>
</head>

<body>
    <h1>Modify Employee</h1>

    <form action="employee" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${employee.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" value="${employee.name}" name="name" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" value="${employee.email}" name="email" required>
        <br>
        <label for="post">Post:</label>
        <input type="post" id="post" value="${employee.post}" name="post" required>
        <br>
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" value="${employee.phone}" name="phone" required>
        <br>
        <label for="position">Position:</label>
        <input type="tel" id="position" value="${employee.position}" name="position" required>
        <br>
        <input type="submit" value="modify Employee">
    </form>