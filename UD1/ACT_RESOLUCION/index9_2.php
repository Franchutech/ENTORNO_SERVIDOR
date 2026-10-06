<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica9_Ejercicio2</title>
</head>
<body>
    <h1>Práctica9_Ejercicio2</h1>
    <?php
    $frase = "Era una vez un programador que quería aprender PHP";
    $fraseModificada = str_replace("programador", "desarrollador", $frase);
    echo " $fraseModificada";
    $fraseDiezCaracteres = substr($frase,0,10);
    echo "<p>Los diez primeros caracteres son: $fraseDiezCaracteres</p>";
    $fraseConEspacios = " Era una vez un programador que quería aprender PHP ";
    $fraseConEspacios = trim($fraseConEspacios);
    echo "<p>La frase con espacios eliminados es: $fraseConEspacios</p>";
    ?>
</body>
</html>