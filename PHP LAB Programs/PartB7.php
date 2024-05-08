<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "phpLab";
$conn = new mysqli($servername, $username, $password, $database);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

function calculateDiscount($bookCode, $price, $quantity)
{
    switch ($bookCode) {
        case 101:
            $discountRate = 0.15;
            break;
        case 102:
            $discountRate = 0.20;
            break;
        case 103:
            $discountRate = 0.25;
            break;
        default:
            $discountRate = 0.05;
    }
    $discountAmount = $price * $quantity * $discountRate;
    return $discountAmount;
}

function calculateNetBill(
    $price,
    $quantity,
    $discountAmount
) {
    $totalAmount = $price * $quantity;
    $netBill = $totalAmount - $discountAmount;
    return $netBill;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $bookNumber = $_POST['book_number'];
    $bookTitle = $_POST['book_title'];
    $price = $_POST['price'];
    $quantity = $_POST['quantity'];
    $bookCode = $_POST['book_code'];
    $discountAmount = calculateDiscount(
        $bookCode,
        $price,
        $quantity
    );
    $netBill = calculateNetBill(
        $price,
        $quantity,
        $discountAmount
    );
    $sql = "INSERT INTO bookshop (booknumber, booktitle, price, quantity, discountamount, netbill) VALUES ('$bookNumber', '$bookTitle', '$price', '$quantity', '$discountAmount', '$netBill')";
    if ($conn->query($sql) === TRUE) {
        echo "Bill data inserted successfully. <br>";
        echo "Discount Amount: $" . $discountAmount . "<br>";
        echo "Net Bill Amount: $" . $netBill . "<br>";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}
$conn->close();
?>
<html>

<head>
    <title>Book Shopping Form</title>
</head>

<body>
    <h2>Book Shopping Form</h2>
    <form method="post">
        Book Number: <input type="text" name="book_number"><br><br>
        Book Title: <input type="text" name="book_title"><br><br>
        Price: <input type="text" name="price"><br><br>
        Quantity: <input type="text" name="quantity"><br><br>
        Book Code:
        <select name="book_code">
            <option value="101">101</option>
            <option value="102">102</option>
            <option value="103">103</option>
            <option value="other">Other</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>

</html>