<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
    <link rel="stylesheet" href="./css/addEmployee.css">
</head>

<body>
    <h1 class="employeeTitle">Add Employee</h1>
    <div class="form-container">
        <form action="employee" method="post" class="employee-form">
            <input type="hidden" name="action" value="create">

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" class="input-field" required>
            <br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" class="input-field" required>
            <br>

            <label for="post">Post:</label>
            <input type="text" id="post" name="post" class="input-field" required>
            <br>

            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" class="input-field" required>
            <br>

            <label for="position">Position:</label>
            <input type="text" id="position" name="position" class="input-field" required>
            <br>

            <input type="submit" value="Add Employee" class="submit-button">
        </form>
    </div>
</body>

</html>
