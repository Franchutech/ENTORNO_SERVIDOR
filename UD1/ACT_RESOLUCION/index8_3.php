<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica8_Ejercicio3</title>
</head>
<body>
    <h1>Práctica8_Ejercicio3</h1>
    <form method="get" action="">
    Edad = <input type="text" name="edad">
    </form>
    <?php
    if (isset($_GET["edad"])) {
        $edad = $_GET["edad"];
        if (is_numeric($edad)) {
            echo '<p>La edad es válida.</p>';
            $edadvalidada = intval($edad);
            if ($edadvalidada > 0 && $edadvalidada < 18) {
                echo '<p>La edad es menor de edad.</p>';
            } elseif ($edadvalidada >= 18 && $edadvalidada < 65) {
                echo '<p>La edad es adulta.</p>';
            } else {
                echo '<p>Edad lista para jubilarse jaja.</p>';
            }
        } else {
            echo '<p>La edad no es válida.</p>';
        }
    }
    ?>
</body>
</html>