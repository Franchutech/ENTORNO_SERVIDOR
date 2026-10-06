<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica8_Ejercicio1</title>
</head>
<body>
    <h1>Práctica8_Ejercicio1</h1>
    <?php
    $datos = ['nombre' => '', 'email' => 'ana@mail.com'];
    foreach ($datos as $clave => $value) {
        if (empty($value)) {
            echo ('<p>El campo ' . $clave . ' está vacío</p>');
        } else {
            echo ('<p>El campo ' . $clave . ' tiene el valor: ' . $value . '</p>');
        }
    }
    ?>
</body>
</html>