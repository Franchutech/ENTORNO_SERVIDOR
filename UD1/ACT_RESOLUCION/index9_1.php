<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica9_Ejercicio1</title>
</head>
<body>
    <h1>Práctica9_Ejercicio1</h1>
    <?php
    $texto = "Hola, estoy practicando PHP";
    echo "<p>El texto es: $texto y tiene " . strlen($texto) . " caracteres</p>";
    echo "<p>El texto en mayúsculas es: " . strtoupper($texto) . "</p>";
    echo "<p>El texto en minúsculas es: ". strtolower($texto) . "</p>";
    ?>
</body>
</html>