<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica8_Ejercicio4</title>
</head>
<body>
    <h1>Práctica8_Ejercicio4</h1>
    <form method="get" action="">
        Nombre = <input type="text" name="nombre">
        Comentario = <input type="text" name="comentario">
        <input type="submit" value="Enviar">
    </form>
    <?php
    $comentario = "<script>alert(1)('Buen Producto')</script>";
    $comentario_limpio = filter_var($comentario, FILTER_SANITIZE_FULL_SPECIAL_CHARS);
    // Es importante sanear los datos con filter_var y FILTER_SANITIZE_FULL_SPECIAL_CHARS 
    // antes de mostrarlos para evitar ataques de tipo XSS (Cross-Site Scripting), 
    // impidiendo que el navegador interprete etiquetas HTML o JavaScript maliciosas introducidas por el usuario.
    echo $comentario_limpio;
    ?>
    
</body>
</html>