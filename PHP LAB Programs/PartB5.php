<?php
$host = "localhost";
$username = "root";
$password = "";
$database = "phplab";

$conn = mysqli_connect($host, $username, $password, $database);

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
function insert_feedback($conn, $name, $email, $subject, $message)
{
    $query = "INSERT INTO feedback (name, email, subject, message) VALUES ('name', '$email', '$subject', '$message')";
    if (mysqli_query($conn, $query)) {
        return true;
    } else {
        return false;
    }
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST["name"];
    $email = $_POST["email"];
    $subject = $_POST["subject"];
    $message = $_POST["message"];

    if (insert_feedback($conn, $name, $email, $subject, $message)) {
        echo "Feedback submitted successfully!";
    } else {
        echo "Error: Feedback submission failed.";
    }
}

mysqli_close($conn);
?>
<html>

<head>
    <title>Feedback Form</title>
</head>

<body>
    <h2>Feedback Form</h2>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
        <label>Name:</label><br>
        <input type="text" name="name" required><br>
        <label>Email:</label><br>
        <input type="email" name="email" required><br>
        <label>Subject:</label><br>
        <input type="text" name="subject" required><br>
        <label>Message:</label><br>
        <textarea id="message" name="message" rows="4" required></textarea><br><br>
        <input type="submit" value="Submit">
    </form>
</body>

</html>