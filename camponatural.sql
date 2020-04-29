
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
