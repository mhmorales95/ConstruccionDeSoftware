-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 28-05-2019 a las 03:21:03
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `amadajm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anulaciones`
--

CREATE TABLE `anulaciones` (
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `codigoUsuario` int(11) NOT NULL,
  `correlativo` int(11) NOT NULL,
  `motivo` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigo` int(11) NOT NULL,
  `rut` varchar(20) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `telefono` varchar(18) NOT NULL,
  `direccion` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`codigo`, `rut`, `nombre`, `telefono`, `direccion`) VALUES
(19007287, '19.007.287-8', 'Mauricio', '945889627', 'Curicó'),
(19261363, '19.261.363-9', 'Matías', '988539685', 'San Vicente de T.T');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familias`
--

CREATE TABLE `familias` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `familias`
--

INSERT INTO `familias` (`codigo`, `nombre`) VALUES
(1, 'MANJAR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientostock`
--

CREATE TABLE `movimientostock` (
  `codigo` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  `movimiento` varchar(15) NOT NULL,
  `producto` varchar(20) NOT NULL,
  `cantidad` double NOT NULL,
  `hora` time NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `movimientostock`
--

INSERT INTO `movimientostock` (`codigo`, `usuario`, `movimiento`, `producto`, `cantidad`, `hora`, `fecha`) VALUES
(1, 1, 'salida', '92', 12, '00:00:00', '2019-05-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `codigo` int(20) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `estado` varchar(10) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `fechaEntrega` date NOT NULL,
  `horaEntrega` varchar(14) NOT NULL,
  `codigoUsuario` int(11) NOT NULL,
  `precioTotal` int(11) NOT NULL,
  `abono` int(11) NOT NULL,
  `porPagar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`codigo`, `codigoCliente`, `estado`, `fecha`, `hora`, `fechaEntrega`, `horaEntrega`, `codigoUsuario`, `precioTotal`, `abono`, `porPagar`) VALUES
(1, 19007287, 'fin', '2019-05-26', '17:51:46', '2019-05-27', '09:00 - 10:00', 1, 1000, 600, 400),
(2, 19007287, 'NULO', '2019-05-26', '17:55:46', '2019-05-10', '09:00 - 10:00', 1, 5000, 0, 5000),
(3, 19007287, '', '2019-05-26', '17:59:01', '2019-05-31', '09:00 - 10:00', 1, 360000, 1000, 359000),
(4, 19261363, 'fin', '2019-05-26', '18:11:19', '2019-05-03', '09:00 - 10:00', 1, 60000, 4000, 56000),
(5, 19007287, 'fin', '2019-05-26', '19:37:48', '2019-05-31', '11:00 - 12:00', 1, 5000, 3000, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidodetalle`
--

CREATE TABLE `pedidodetalle` (
  `codigo` int(11) NOT NULL,
  `codigoProducto` varchar(20) NOT NULL,
  `cantidad` double NOT NULL,
  `unitario` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `comentario` varchar(100) NOT NULL,
  `codigoPedido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedidodetalle`
--

INSERT INTO `pedidodetalle` (`codigo`, `codigoProducto`, `cantidad`, `unitario`, `total`, `comentario`, `codigoPedido`) VALUES
(1, '1', 1, 0, 0, '', 0),
(2, '1', 5, 0, 0, '', 0),
(3, '5638', 6, 0, 0, '', 0),
(4, '5638', 2, 0, 0, '', 3),
(5, '5638', 2, 0, 0, 'as}', 3),
(6, '1', 5, 1000, 5000, 'HOLA', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `familia` varchar(20) NOT NULL,
  `medida` varchar(2) NOT NULL,
  `neto` int(11) NOT NULL,
  `iva` int(11) NOT NULL,
  `bruto` int(11) NOT NULL,
  `margen` float NOT NULL,
  `total` int(11) NOT NULL,
  `stock` double NOT NULL,
  `minimo` double NOT NULL,
  `mueve` tinyint(1) NOT NULL,
  `incluye` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `familia`, `medida`, `neto`, `iva`, `bruto`, `margen`, `total`, `stock`, `minimo`, `mueve`, `incluye`) VALUES
('5638', 'Torta de tres leches', 'MANJAR', 'UN', 0, 0, 0, 0, 15000, 0, 2, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `producto` varchar(20) NOT NULL,
  `productoreceta` varchar(20) NOT NULL,
  `cantidad` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  `accesoCaja` tinyint(1) NOT NULL,
  `accesoTotal` tinyint(1) NOT NULL,
  `accesoPedido` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`codigo`, `nombre`, `contrasena`, `accesoCaja`, `accesoTotal`, `accesoPedido`) VALUES
(19126000, 'Evelyn', 'mvey2609', 1, 1, 1),
(19261363, 'Matías', '1996', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventadetalle`
--

CREATE TABLE `ventadetalle` (
  `correlativo` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `codigoProducto` varchar(20) NOT NULL,
  `cantidad` double NOT NULL,
  `unitario` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventadetalle`
--

INSERT INTO `ventadetalle` (`correlativo`, `tipo`, `codigoProducto`, `cantidad`, `unitario`, `total`) VALUES
(2, 'boleta', '1', 5, 1000, 5000),
(3, 'boleta', '1', 5, 1000, 5000),
(5, 'boleta', '5638', 2, 0, 0),
(5, 'boleta', '5638', 2, 0, 0),
(6, 'boleta', '1', 1, 1000, 1000),
(7, 'boleta', '1', 1, 1000, 1000),
(8, 'boleta', '1', 1, 1000, 1000),
(9, 'boleta', '1', 1, 1000, 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventaresumen`
--

CREATE TABLE `ventaresumen` (
  `codigo` int(11) NOT NULL,
  `correlativo` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `neto` int(11) NOT NULL,
  `iva` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `estado` varchar(15) NOT NULL,
  `codigoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventaresumen`
--

INSERT INTO `ventaresumen` (`codigo`, `correlativo`, `tipo`, `codigoCliente`, `neto`, `iva`, `total`, `fecha`, `hora`, `estado`, `codigoUsuario`) VALUES
(1, 1, 'boleta', 19007287, -950, 4050, 5000, '2019-05-26', '21:01:16', '', 1),
(2, 2, 'boleta', 19007287, 4050, 950, 5000, '2019-05-26', '21:30:19', '', 1),
(3, 3, 'boleta', 19007287, 4050, 950, 5000, '2019-05-26', '21:50:22', '', 1),
(4, 4, 'boleta', 19261363, 0, 0, 0, '2019-05-26', '22:05:26', '', 1),
(5, 5, 'boleta', 19007287, 0, 0, 0, '2019-05-26', '22:06:10', '', 1),
(6, 6, 'boleta', 0, 810, 190, 1000, '2019-05-26', '22:20:40', '', 1),
(7, 7, 'boleta', 0, 810, 190, 1000, '2019-05-26', '22:20:56', '', 1),
(8, 8, 'boleta', 0, 810, 190, 1000, '2019-05-26', '22:27:18', '', 1),
(9, 9, 'boleta', 0, 810, 190, 1000, '2019-05-26', '22:33:00', '', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anulaciones`
--
ALTER TABLE `anulaciones`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `familias`
--
ALTER TABLE `familias`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- Indices de la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `ventaresumen`
--
ALTER TABLE `ventaresumen`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anulaciones`
--
ALTER TABLE `anulaciones`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `familias`
--
ALTER TABLE `familias`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `codigo` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19261364;
--
-- AUTO_INCREMENT de la tabla `ventaresumen`
--
ALTER TABLE `ventaresumen`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
