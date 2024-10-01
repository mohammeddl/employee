<!DOCTYPE html>
<html>

<head>
    <title> Modify Employee</title>
</head>

<body>
    <h1>Modify Employee</h1>

    <form action="ModifyEmployee" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="post">Post:</label>
        <input type="post" id="post" name="post" required>
        <br>
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" required>
        <br>
        <label for="position">Position:</label>
        <input type="tel" id="position" name="position" required>
        <br>
        

        <input type="submit" value="modify Employee">
    </form>