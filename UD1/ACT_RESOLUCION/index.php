<!DOCTYPE html>
<html>
<body>
  <h1>Ejercicio 2: Segundo Formulario</h1>
	<form method="get" action="">
  Nombre: <input type="text" name="nombre">
  Edad: <input type="number" name="edad">
  Ciudad: <input type="text" name="ciudad">
  <input type="submit" value="Enviar">
  </form>
  <ul>
  <?php
  if (isset($_GET["nombre"], $_GET["edad"], $_GET["ciudad"])) {
  echo "<li>" . $_GET["nombre"] . "</li>";
  echo "<li>" . $_GET["edad"] . "</li>";
  echo "<li>" . $_GET["ciudad"] . "</li>";
  }
	?>
  </ul>
 
</body>
</html>