<!DOCTYPE html>
<html>
<body>
  <h1>Ejercicio 3: Tercer Formulario</h1>
	<form method="get" action="">
  Nombre: <input type="text" name="nombre">
  Email: <input type="email" name="email">
  Mensaje: <textarea name="mensaje"></textarea>
  <input type="submit" value="Enviar">
  </form>
  <p>
  <?php
  if (isset($_GET["nombre"], $_GET["email"], $_GET["mensaje"])) {
  if (empty($_GET["nombre"])) {
    echo "El nombre está vacío";
  }
  elseif (empty($_GET["email"])) {
    echo "El email está vacío";
  }
  elseif (empty($_GET["mensaje"])) {
    echo "El mensaje está vacío";
  }else {
    echo ("Todos los datos han sido recibidos correctamente: ". "<br>");
    echo "Nombre: " . $_GET["nombre"] . "<br>";
    echo "Email: " . $_GET["email"] . "<br>";
    echo "Mensaje: " . $_GET["mensaje"] . "<br>";
  }
  }
	?>
  </p>
 
</body>
</html>