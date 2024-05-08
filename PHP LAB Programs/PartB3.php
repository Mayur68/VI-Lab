<!DOCTYPE html>
<html>

<body>
    <form action="" method="post">
        <h2>Distance Calculator</h2>
        <br>
        Distance 1:
        <br>
        Feet: <input type="number" name="feet1" value="5">
        Inches: <input type="number" name="inches1" value="8">
        <br><br>
        Distance 2:
        <br>
        Feet: <input type="number" name="feet2" value="3">
        Inches: <input type="number" name="inches2" value="9">
        <br><br>
        <input type="submit" value="Calculate">
    </form>
</body>

</html>
<?php
class DistanceCalculator
{
    public $feet1;
    public $inches1;
    public $feet2;
    public $inches2;
    public function __construct($feet1, $inches1, $feet2, $inches2)
    {
        $this->feet1 = $feet1;
        $this->inches1 = $inches1;
        $this->feet2 = $feet2;
        $this->inches2 = $inches2;
    }
    public function getSum()
    {
        $totalInches = $this->inches1 + $this->inches2;
        $feet = $this->feet1 + $this->feet2 + floor($totalInches / 12);
        $inches = $totalInches % 12;
        return "Sum: " . $feet . "'" . $inches . "\"";
    }
    public function getDifference()
    {
        $totalInches1 = $this->feet1 * 12 + $this->inches1;
        $totalInches2 = $this->feet2 * 12 + $this->inches2;
        $differenceInches = $totalInches1 - $totalInches2;
        if ($differenceInches < 0) {
            $differenceFeet = floor(abs($differenceInches) / 12) * -1;
            $differenceInches = abs($differenceInches) % 12;
        } else {
            $differenceFeet = floor($differenceInches / 12);
            $differenceInches = $differenceInches % 12;
        }
        return "Difference: " . $differenceFeet . "'" . $differenceInches . "\"";
    }
}
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $feet1 = $_POST["feet1"];
    $inches1 = $_POST["inches1"];
    $feet2 = $_POST["feet2"];
    $inches2 = $_POST["inches2"];
    $calculator = new DistanceCalculator($feet1, $inches1, $feet2, $inches2);
    $sum = $calculator->getSum();
    $difference = $calculator->getDifference();
    echo "<h2>Distance Calculator</h2>";
    echo "<br>";
    echo "Distance 1:";
    echo "<br>";
    echo "Feet: $feet1";
    echo "<br>";
    echo "Inches: $inches1";
    echo "<br><br>";
    echo "Distance 2:";
    echo "<br>";
    echo "Feet: $feet2";
    echo "<br>";
    echo "Inches: $inches2";
    echo "<br><br>";
    echo $sum;
    echo "<br>";
    echo $difference;
}
?>