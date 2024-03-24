<!DOCTYPE html>
<html>

<head>
  <title>Calculator</title>
  <style>
    body {
      font-family: Arial, Helvetica, sans-serif;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    form {
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 300px;
    }

    h2 {
      color: #333;
    }

    label {
      display: block;
      margin: 10px 0 0;
      color: #555;
    }

    input[type="number"],
    select,
    input[type="submit"] {
      width: 100%;
      padding: 10px;
      margin: 5px 0;
      border-radius: 4px;
      border: 2px solid black;
      box-sizing: border-box;
    }

    select {
      cursor: pointer;
      font-size: large;
    }

    input[type="submit"] {
      background-color: #4caf50;
      color: #fff;
      border: none;
      padding: 10px 20px;
      font-size: 16px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }

    p {
      margin-top: 15px;
      font-size: 18px;
      color: #333;
      text-align: center;
    }
  </style>
</head>

<body>
  <?php
  if (isset($_POST['submit'])) {
    $num1 = $_POST['num1'];
    $num2 = $_POST['num2'];
    $operator = $_POST['operator'];
    switch ($operator) {
      case '+':
        $res = $num1 + $num2;
        break;
      case '-':
        $res = $num1 - $num2;
        break;
      case '*':
        $res = $num1 * $num2;
        break;
      case '/':
        if ($num2 == 0) {
          $res = "Not divisible by zero";
        } else {
          $res = $num1 / $num2;
        }
        break;
    }
  }
  ?>

  <form method="post">
    <h2>CALCULATOR</h2>
    <label for="num1">First Number:</label>
    <input type="number" name="num1" value="<?php if (!empty($num1)) echo $num1; ?>" required>

    <label for="num2">Second Number:</label>
    <input type="number" name="num2" value="<?php if (!empty($num2)) echo $num2; ?>" required>

    <label for="operator">Select Operation:</label>
    <select name="operator" value="<?php echo $num2; ?>" required>
    <option><?php echo $operator; ?></option>
      <option>+</option>
      <option>-</option>
      <option>*</option>
      <option>/</option>
    </select>

    <input type="submit" value="Result" name="submit">
    <p><?php if (@$res != "Not divisible by zero" && @$res) {
          echo @$num1 . " " . @$operator . " " . @$num2 . " = " .  @$res;
        } else {
          echo @$res;
        }
        ?></p>
  </form>
</body>

</html>