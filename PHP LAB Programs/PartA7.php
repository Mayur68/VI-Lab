<!DOCTYPE html>
<html>

<head>
    <title>String Manipulation</title>
</head>

<body>
    <h1>String Manipulation</h1>
    <form method="post">
        <label for="label_string">Enter a string:</label>
        <input type="text" id="label_string" name="input_string" value="<?php if (!empty($_POST['input_string'])) echo $_POST['input_string']; ?>" required><br><br>
        <input type="submit" name="get_length" value="Get Length">
        <input type="submit" name="replace" value="Replace">
        <input type="submit" name="upper_case" value="Upper Case">
        <input type="submit" name="lower_case" value="Lower Case">
        <input type="submit" name="word_count" value="Word Count">
        <input type="submit" name="shuffle" value="Shuffle">
        <input type="submit" name="check_palindrome" value="Check Palindrome">
        <input type="submit" name="reverse" value="Reverse">
    </form>
    <?php
    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        $input_string = $_POST['input_string'];
        echo "<strong>$input_string</strong><br>";
        if (isset($_POST['get_length'])) {
            echo "<p><strong>Length of String: </strong>" . strlen($input_string) . "</p>";
        }
        if (isset($_POST['replace'])) {
            echo "<p><strong>Replaced string: </strong>" . str_replace("a", "x", $input_string) . "</p>";
        }
        if (isset($_POST["upper_case"])) {
            echo "<p><strong>Upper case: </strong>" . strtoupper($input_string) . "</p>";
        }
        if (isset($_POST["lower_case"])) {
            echo "<p><strong>Lower case: </strong>" . strtolower($input_string) . "</p>";
        }
        if (isset($_POST["word_count"])) {
            echo "<p><strong>Word count: </strong>" . str_word_count($input_string) . "</p>";
        }
        if (isset($_POST["shuffle"])) {
            echo "<p><strong>Shuffle string: </strong>" . str_shuffle($input_string) . "</p>";
        }
        if (isset($_POST["check_palindrome"])) {
            if (strtolower($input_string) === strtolower(strrev($input_string))) {
                echo "<p><strong>Check Palindrome: </strong>The string is a palindrome</p>";
            } else {
                echo "<p><strong>Check Palindrome: </strong>The string is not a palindrome</p>";
            }
        }
        if (isset($_POST["reverse"])) {
            echo "<p><strong>Reversed string: </strong>" . strrev($input_string) . "</p>";
        }
    }
    ?>
</body>

</html>