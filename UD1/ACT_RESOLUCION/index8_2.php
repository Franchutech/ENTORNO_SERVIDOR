<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica8_Ejercicio2</title>
</head>
<body>
    <h1>Práctica8_Ejercicio2</h1>
    <?php
    $email = 'francella@mail.com';

    if (filter_var($email, FILTER_VALIDATE_EMAIL)){
            echo '<p>El email es válido.</p>';
        } else {
            echo '<p>El email no es válido.</p>';
        }
    ?>
</body>
</html>