<!DOCTYPE html>
<html>

<head>
  <style>
    body {
      height: 100vh;
      display: flex;
      justify-content: center;
      font-family: Arial, Helvetica, sans-serif;
      text-align: center;
    }

    form {
      padding-top: 100px;
      display: flex;
      flex-direction: column;
      gap: 5px;
    }

    label,
    input[type='submit'] {
      font-weight: 600;
    }

    input {
      font-family: inherit;
      padding: 5px 10px;
      border-radius: 5px;
      border: 2px solid black;
    }
  </style>
</head>

<body>
  <?php
  error_reporting(1);
  $day = 0;
  $yr = 0;
  $mon = 0;
  if (isset($_POST['submit'])) {

    $d1 = new DateTime("now");
    $d2 = new DateTime($_POST['dob']);
    $diff = $d1->diff($d2);

    $yr = $diff->y;
    $mon = $diff->m;
    $day = $diff->d;
  }
  ?>

  <form method="post">
    <h1>AGE CALCULATOR</h1>
    <label for="dob">Date of Birth</label>
    <input type="date" name="dob" id="dob" />
    <input type="submit" value="Submit" name="submit" />
    <?php if($yr != 0) echo '<p>Your Age: ' . $yr . ' years ' . $mon . ' months ' . $day . ' days</p>'; $yr = 0; ?>
  </form>
</body>

</html>