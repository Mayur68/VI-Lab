<?php
$servername = "localhost";
$userName = "root";
$password = "";
$database = "phpLab";
$conn = new mysqli($servername, $userName, $password, $database);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
function validate_credentials($conn, $userName, $password)
{
    $sql = "SELECT * FROM masterTable WHERE userName='$userName' AND password='$password'";
    $result = $conn->query($sql);
    if ($result && $result->num_rows > 0) {
        return true;
    } else {
        return false;
    }
}
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $userName = $_POST['userName'];
    $password = $_POST['password'];
    if (validate_credentials($conn, $userName, $password)) {
        echo "Login successful. Welcome, $userName!";
    } else {
        echo "Invalid userName or password. Please try again.";
    }
}
?>
<html>

<head>
    <title>Login Form</title>
</head>

<body>
    <h2>Login Form</h2>
    <form method="post" name="Form">
        <label>UserName:</label><br>
        <input type="text" name="userName" required><br>
        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>
        <input type="submit" id="login" value="Login">
    </form>
</body>

</html>

<?php
$conn->close();
?>