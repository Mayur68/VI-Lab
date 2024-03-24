<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: PartA3.php');
    exit();
}
if (isset($_POST['logout'])) {
    session_destroy();
    header('Location: PartA3.php');
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
</head>

<body>
    <h2>Welcome <?php echo $_SESSION['username']; ?></h2>
    <strong>you have logged in</strong>
    <form method="post" action="">
        <input type="submit" value="logout" name="logout"/>
    </form>
</body>

</html>