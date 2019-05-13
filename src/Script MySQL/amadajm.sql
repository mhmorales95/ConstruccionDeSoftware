-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 13-05-2019 a las 04:00:59
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
(19007287, '19.007.287-8', 'Mauricio', '945889627', 'Curicó');

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
  `horaEntrega` time NOT NULL,
  `codigoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidodetalle`
--

CREATE TABLE `pedidodetalle` (
  `codigo` int(11) NOT NULL,
  `codigoProducto` varchar(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `comentario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `stock` float NOT NULL,
  `minimo` float NOT NULL,
  `mueve` tinyint(1) NOT NULL,
  `incluye` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `familia`, `medida`, `neto`, `iva`, `bruto`, `margen`, `total`, `stock`, `minimo`, `mueve`, `incluye`) VALUES
('1', 'TORTA JAMON QUESO', '', 'UN', 0, 0, 0, 0, 1000, 15, 2, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `producto` varchar(20) NOT NULL,
  `productoreceta` varchar(20) NOT NULL,
  `cantidad` float NOT NULL
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
(0, 'Diego', '12345', 1, 1, 1),
(0, 'Mauricio', '1', 1, 1, 1),
(0, 'Marchant', '1', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventadetalle`
--

CREATE TABLE `ventadetalle` (
  `codigoVenta` int(11) NOT NULL,
  `codigoProducto` varchar(20) NOT NULL,
  `cantidad` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventaresumen`
--

CREATE TABLE `ventaresumen` (
  `codigo` int(11) NOT NULL,
  `correlativo` int(11) NOT NULL,
  `tipo` varchar(10) NOT NULL,
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
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `codigo` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `ventaresumen`
--
ALTER TABLE `ventaresumen`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
