-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-04-2020 a las 20:12:39
-- Versión del servidor: 5.7.26-0ubuntu0.16.04.1
-- Versión de PHP: 7.3.7-1+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `appastosemaforo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camponatural`
--

CREATE TABLE `camponatural` (
  `nombrepotrero` varchar(45) NOT NULL,
  `cantidad` varchar(11) NOT NULL,
  `calidad` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `camponatural`
--

INSERT INTO `camponatural` (`nombrepotrero`, `cantidad`, `calidad`) VALUES
('peter', '1', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `camponatural`
--
ALTER TABLE `camponatural`
  ADD PRIMARY KEY (`nombrepotrero`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
