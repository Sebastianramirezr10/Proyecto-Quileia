-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-09-2020 a las 21:07:22
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agente`
--

CREATE TABLE `agente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `exp` float DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `vias` int(15) NOT NULL,
  `numerovia` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `agente`
--

INSERT INTO `agente` (`id`, `nombre`, `apellido`, `codigo`, `exp`, `sdt`, `vias`, `numerovia`) VALUES
(34, 'henry', 'lozada', 'abcs', 5, 'lopeqw', 0, NULL),
(1, 'sebastian', 'ramirez', 'lñk', 3, 'jhg', 0, NULL),
(35, 'paola', 'ramirez', '159e', 4, '147sa', 0, NULL),
(36, 'paola', 'ramirez', 'abdcx', 5, '147lñk', 0, NULL),
(37, 'sebastian', 'ramirez', 'adsce', 12, '1a2sd1', 0, NULL),
(38, 'sebastian', 'ramirez', '111014', 12, 'abc', 0, NULL),
(39, 'fabian', 'lopez', 'lkñ147', 39, 'kjh147', 0, NULL),
(40, 'sebastian', 'ramirez', '1110141', 213, '3212', 0, NULL),
(41, 'gladys', 'rubiano ', '1563ñlk', 200, 'jhgsn', 0, NULL),
(42, 'sebastian', 'ramirez', '123', 123, 'CBDF', 0, NULL),
(43, 'sebastian', 'ramirez', '564', 123, 'xasdqw', 0, NULL),
(51, 'henry', 'ramirez', '56789', 5, 'rtyui', 0, NULL),
(52, 'daniel', 'velasques', '5678985', 5, 'hgjfd', 0, NULL),
(53, 'sergio', 'novoa', 'Abc', 2, 'werq', 0, NULL),
(54, 'felipe', 'muñoz', '1475lñk', 2, 'ñpoil', 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(55),
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vias`
--

CREATE TABLE `vias` (
  `id` int(11) NOT NULL,
  `tipo_via` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `numerovia` int(15) NOT NULL,
  `congestion` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vias`
--

INSERT INTO `vias` (`id`, `tipo_via`, `direccion`, `numerovia`, `congestion`) VALUES
(44, 'carretera', 'carrera', 15, 24),
(33, 'autopista', 'calle', 0, 50),
(45, 'carretera', 'carrera', 0, 65),
(46, 'carretera', 'carrera', 0, 45),
(47, 'carretera', 'carrera', 0, 12),
(48, 'autopista', 'carrera', 0, 100),
(49, 'autopista', 'calle', 0, 25),
(50, 'autopista', 'calle', 0, 25),
(1, 'principal', 'carrera', 0, 45);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `agente`
--
ALTER TABLE `agente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_via` (`vias`),
  ADD KEY `FKotcpshprjp4svlosnm2k67vm5` (`numerovia`);

--
-- Indices de la tabla `vias`
--
ALTER TABLE `vias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_via` (`numerovia`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
