<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica9_Ejercicio 3</title>
</head>
<body>
    <h1>Práctica9_Ejercicio3</h1>
    <?php
    $frase = "Hoy es un buen día para programar en PHP";
    $frase_dividida = explode(" ", $frase);
    //esto se usa para ver que el array funcionó con el explode
    echo "<p>Array de palabras separadas:</p>";
    echo "<pre>";
    print_r($frase_dividida);
    echo "</pre>";
    $palabras_totales = count($frase_dividida);
    echo "<p>Las palabras totales son: $palabras_totales</p>";
    echo "<p>La frase es: $frase</p>";
    $frase_unida = implode("-", $frase_dividida);
    echo "<p>La frase unida es: $frase_unida</p>";
    $existe_palabra = strpos($frase, "programar");
    if ($existe_palabra !== false) {
        echo "<p>La palabra 'programar' existe en la frase.</p>";
    } else {
        echo "<p>La palabra 'programar' no existe en la frase.</p>";
    }

    ?>
    
</body>
</html>