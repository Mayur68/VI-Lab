<?php
session_start();
if (isset($_POST['login'])) {
  $username = $_POST['username'];
  $password = $_POST['password'];

  if ($username === 'admin' && $password === 'password') {
    $_SESSION['username'] = $username;
    header('Location: welcome.php');
    exit();
  } else {
    echo "Invalid username or password. Please try again.";
  }
}
?>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
</head>

<body>
  <h2>Login</h2>
  <form method="post" action="">
    <label>Username:</label><br>
    <input type="text" name="username" required><br><br>
    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>
    <input type="submit" name="login" value="Login">
  </form>
</body>

</html>