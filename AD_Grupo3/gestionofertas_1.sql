-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-01-2022 a las 18:31:28
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionofertas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciclo`
--

CREATE TABLE `ciclo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ciclo`
--

INSERT INTO `ciclo` (`id`, `nombre`, `tipo`) VALUES
(1, 'DAM', 'POR'),
(2, 'DAS', 'HUY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscrito`
--

CREATE TABLE `inscrito` (
  `id` int(11) NOT NULL,
  `fecha_inscripcion` date DEFAULT NULL,
  `id_oferta` int(11) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inscrito`
--

INSERT INTO `inscrito` (`id`, `fecha_inscripcion`, `id_oferta`, `id_usuario`) VALUES
(15, '2022-01-24', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticia`
--

CREATE TABLE `noticia` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `ciclo_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `noticia`
--

INSERT INTO `noticia` (`id`, `descripcion`, `imagen`, `titulo`, `ciclo_id`) VALUES
(12, 'ODOO acaba sus servicios', 'Qué-aporta-Odoo-a-mi-negocio.jpg', 'ODOO CIERRA', 1),
(13, 'T', 'SRVR.jpg', 'T', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechamax` date DEFAULT NULL,
  `num_candidatos` int(11) NOT NULL,
  `requisitos` varchar(255) DEFAULT NULL,
  `titular` varchar(255) DEFAULT NULL,
  `cicloid` int(11) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`id`, `descripcion`, `fechamax`, `num_candidatos`, `requisitos`, `titular`, `cicloid`, `usuario_id`) VALUES
(1, 'Noticia 1', '2022-01-06', 123, 'Cursar DAM', 'Oferta Laravel', 1, 3),
(14, 'Trabajo IONIC', '2022-01-31', 211, 'Cursar DAM', 'Oferta IONIC', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `apellidos` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `telefono` varchar(9) NOT NULL,
  `cicloid` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `activo`, `apellidos`, `email`, `empresa`, `nombre`, `password`, `role`, `telefono`, `cicloid`) VALUES
(1, b'1', 'DP', 'Yerayd99@gmail.com', 'DAM', 'Y', '$2a$10$CWQP4osRNfBJVgOl4Y3Omu6TRBoSEwatO4fPbxGU38b5xeW1AdzIS', 'ROLE_ALUMNO', '9090909', 1),
(3, b'1', 'DM', 'Pablo@gmail.com', 'DAM', 'P', '$2a$10$CWQP4osRNfBJVgOl4Y3Omu6TRBoSEwatO4fPbxGU38b5xeW1AdzIS', 'ROLE_RRHH', '989898989', 1),
(4, b'1', 'ADMIN', 'admin@admin.com', 'ADMIN', 'ADMIN', '$2a$10$CWQP4osRNfBJVgOl4Y3Omu6TRBoSEwatO4fPbxGU38b5xeW1AdzIS', 'ROLE_ADMIN', '9090909', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciclo`
--
ALTER TABLE `ciclo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inscrito`
--
ALTER TABLE `inscrito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe0ptcxg0e1mts17wnttgnarok` (`id_oferta`),
  ADD KEY `FKaxga9uxah5k7ng4d3q6qewqtp` (`id_usuario`);

--
-- Indices de la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5ba6qx12lbhhg0gmu6vnax9ad` (`ciclo_id`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf6955dhj3tehx9i3x5b2y7ioi` (`cicloid`),
  ADD KEY `FKg8yo7g3mjudxdsia7qtiqxhv4` (`usuario_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtpmwbeyypc1fety9icdp3t087` (`cicloid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
