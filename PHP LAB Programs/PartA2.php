<html>

<head>
  <style>
    body {
      display: flex;
      min-height: 100vh;
      padding-top: 100px;
      align-items: center;
      flex-direction: column;
      text-align: center;
      font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    }

    input,
    button {
      padding: 5px 10px;
      border-radius: 5px;
      border: 2px solid black;
      font-family: inherit;
    }

    button {
      font-weight: 600;
      cursor: pointer;
    }
  </style>
</head>

<body>
  <form action="" method="post">
    <label for="number">Enter a number:</label>
    <input type="number" name="number" value="<?php echo isset($_POST['number']) ? htmlspecialchars($_POST['number']) : ''; ?>" required>
    <button type="submit">check</button>
  </form>
  <?php
  function isArmstrong($num)
  {
    $originalNum = $num;
    $sum = 0;
    $digits = strlen($num);
    while ($num > 0) {
      $digit = $num % 10;
      $sum += pow($digit, $digits);
      $num = (int)($num / 10);
    }
    return $originalNum == $sum;
  }
  if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $inputNumber = $_POST["number"];
    if (is_numeric($inputNumber) && $inputNumber > 0 && $inputNumber == (int)$inputNumber) {
      echo "<h3>Results:</h3>";
      if (isArmstrong($inputNumber)) {
        echo "<p>$inputNumber is an Armstrong number.</p>";
        echo "<p>Armstrong numbers in the range from 1 to $inputNumber:</p>";
        for ($i = 1; $i <= $inputNumber; $i++) {
          if (isArmstrong($i)) {
            echo "$i ";
          }
        }
      } else {
        echo "<p>$inputNumber is not an Armstrong number.</p>";
      }
    } else {
      echo "<p>Please enter a positive integer.</p>";
    }
  }
  ?>
</body>

</html>