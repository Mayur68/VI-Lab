<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>
</head>

<body>
    <h1>Student Registration</h1>
    <form method="post" action="Display.php">
        <label for="first_name">First Name:</label><br>
        <input type="text" id="first_name" name="first_name" required><br><br>
        <label for="last_name">Last Name:</label><br>
        <input type="text" id="last_name" name="last_name" required><br><br>
        <label for="address">Address:</label><br>
        <textarea id="address" name="address" rows="4" cols="50"></textarea><br><br>
        <label for="email">E-Mail:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        <label for="mobile">Mobile No:</label><br>
        <input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" required><br><br>
        <label for="city">City:</label><br>
        <input type="text" id="city" name="city" required><br><br>
        <label for="state">State:</label><br>
        <input type="text" id="state" name="state" required><br><br>
        <label for="gender">Gender:</label><br>
        <input type="radio" id="male" name="gender" value="Male" required> Male
        <input type="radio" id="female" name="gender" value="Female" required> Female<br><br>
        <label for="hobbies">Hobbies:</label><br>
        <input type="checkbox" id="hobby_reading" name="hobbies[]" value="Reading"> Reading
        <input type="checkbox" id="hobby_sports" name="hobbies[]" value="Sports"> Sports
        <input type="checkbox" id="hobby_music" name="hobbies[]" value="Music"> Music<br><br>
        <label for="blood_group">Blood Group:</label><br>
        <select id="blood_group" name="blood_group" required>
            <option value="">Select</option>
            <option value="A+">A+</option>
            <option value="A-">A-</option>
            <option value="B+">B+</option>
            <option value="B-">B-</option>
            <option value="AB+">AB+</option>
            <option value="AB-">AB-</option>
            <option value="O+">O+</option>
            <option value="O-">O-</option>
        </select><br><br>
        <input type="submit" value="Register">
    </form>
</body>

</html>