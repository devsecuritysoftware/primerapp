<?php
error_reporting(0);

$conexion = mysqli_connect("localhost", "usuario", "password", "basededatos");

if (!$conexion) {
    exit("Error al conectar base de datos");
}

$nombre = $_POST["nombrepotrero"];
$cantidad = $_POST["cantidad"];
$calidad = $_POST["calidad"];

$consulta = "insert into camponatural (nombrepotrero,cantidad,calidad) VALUES ('" . $nombre . "'," . $cantidad . "," . $calidad . ")";
$resultado=mysqli_query($conexion,$consulta);

$num=mysqli_affected_rows($conexion);

if($num>0){
    echo "Registro OK";
}else{
    echo "ERROR al guardar";
}

mysqli_close($conexion);

