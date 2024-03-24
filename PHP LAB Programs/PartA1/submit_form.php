<body style="display: flex; justify-content:center; align-items:center;">
  <?php
  if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $message = $_POST['message'];

    echo "<div><h2>Form Submission Result</h2>
    <p><b>Name: </b>$name</p>
    <p><b>Email: </b>$email</p>
    <p><b>Message: </b>$message</p>
    </div>";
  } else {
    echo "<p>Access denied</p>";
  }
  ?>
</body>