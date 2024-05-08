<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Student Registration Details</title>
</head>

<body>
    <h1>Student Registration Details</h1>
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $first_name = $_POST["first_name"];
        $last_name = $_POST["last_name"];
        $address = $_POST["address"];
        $email = $_POST["email"];
        $mobile = $_POST["mobile"];
        $city = $_POST["city"];
        $state = $_POST["state"];
        $gender = $_POST["gender"];
        $hobbies = implode(", ", $_POST["hobbies"]);
        $blood_group = $_POST["blood_group"];
        echo " <h2>Personal Information</h2>";
        echo "<table> <tr><td>First Name: </td><td>$first_name</td></tr>";
        echo "<tr><td>Last Name: </td><td>$last_name</td></tr>";
        echo "<tr><td>Address: </td><td>$address</td></tr>";
        echo "<tr><td>E-Mail: </td><td>$email</td></tr>";
        echo "<tr><td>Mobile No: </td><td>$mobile</td></tr>";
        echo "<tr><td>City: </td><td>$city</td></tr>";
        echo "<tr><td>State: </td><td>$state</td></tr>";
        echo "<tr><td>gender: </td><td>$gender</td></tr>";
        echo "<tr><td>hobbies: </td><td>$hobbies</td></tr>";
        echo "<tr><td>blood group: </td><td>$blood_group</td></tr>";
    }
    ?>
</body>

</html>