<!DOCTYPE html>
<html>

<head>
    <title>Word Frequency Counter</title>
</head>

<body>
    <h1>Word Frequency Counter</h1>
    <form method="post" action="<?php echo $_SERVER['PHP_SELF'] ?>">
        <label for="text">Enter a string:</label><br>
        <textarea type="text" id="text" name="text" rows="4" cols="50" value="<?php if (!empty($_POST['input_string'])) echo $_POST['input_string']; ?>" required></textarea><br><br>
        <input type="submit" value="Submit">
    </form>
    <?php
    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        $text = $_POST['text'];
        $text = strtolower($text);
        $words = explode(' ', $text);
        $wordCounts = array_count_values($words);
        arsort($wordCounts);

        echo "<h3>Word Frequencies: </h3";
        foreach ($wordCounts as $word => $count) {
            echo "$word: $count<br>";
        }

        $mostUsedWord = key($wordCounts);
        echo "<h3>Most Used Word: </h3";
        echo "$mostUsedWord:{$wordCounts[$mostUsedWord]}<br>";

        $leastUsedWord = key(array_slice($wordCounts, -1, 1, true));
        echo "<h3>Least Used Word: </h3";
        echo "$leastUsedWord:{$wordCounts[$leastUsedWord]}<br>";

        echo '<form method="post" action="' . $_SERVER['PHP_SELF'] . '">';
        echo '<input type="hidden" name="text" value="' . htmlspecialchars($text) . '">';
        echo '<input type="submit" name="sort_asc" value="Sort Ascending"></form>';

        echo '<form method="post" action="' . $_SERVER['PHP_SELF'] . '">';
        echo '<input type="hidden" name="text" value="' . htmlspecialchars($text) . '">';
        echo '<input type="submit" name="sort_desc" value="Sort Descending"></form>';

        if (isset($_POST['sort_asc'])) {
            ksort($wordCounts);
            echo "<h3>Word Frequencies (Ascending Order)</h3>";
            foreach ($wordCounts as $word => $count) {
                echo "$word: $count <br>";
            }
        } else if (isset($_POST['sort_desc'])) {
            ksort($wordCounts);
            echo "<h3>Word Frequencies (Descending Order)</h3>";
            foreach ($wordCounts as $word => $count) {
                echo "$word: $count <br>";
            }
        }
    }
    ?>
</body>

</html>