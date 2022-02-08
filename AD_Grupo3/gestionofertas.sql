-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2022 a las 09:36:14
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.23

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
(1, 'CICLODAM', 'ESTUDIOS'),
(2, 'CICLODAS', '12');

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
(27);

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
(1, '2022-02-18', 0, 1),
(2, '2022-01-15', 1, 1),
(3, '2022-01-20', 4, 1),
(4, '2022-01-22', 5, 16);

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
(22, 'Calculadora 1', 'calculator.PNG', 'Calculadora', 1),
(23, 'Calculadora 2', 'calculator.PNG', 'Calculadora', 1),
(24, 'Calculadora 3', 'calculator.PNG', 'Calculadora', NULL);

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
  `usuario_id` bigint(20) DEFAULT NULL,
  `cicloid` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`id`, `descripcion`, `fechamax`, `num_candidatos`, `requisitos`, `titular`, `usuario_id`, `cicloid`) VALUES
(0, 'ES', '2022-02-05', 3, 'ES', 'ES', 14, 1),
(1, 'qwerty', '2022-01-18', 123, 'ASDFG', 'TYUIO', 15, 2),
(3, 'OF1', '2022-02-09', 123, 'Cursar informática', 'Oferta informático', 15, 2),
(4, 'OF2', '2022-02-09', 123, 'Cursar informática 2', 'Oferta informático 2', 15, 2),
(5, 'OF3', '2022-02-09', 123, 'Cursar informática 3', 'Oferta informático 3', 14, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `cicloid` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `activo`, `apellidos`, `email`, `empresa`, `nombre`, `password`, `role`, `telefono`, `cicloid`) VALUES
(3, b'1', 'ADMIN', 'admin@admin.com', 'DAM', 'Admin', '$2a$10$SW./P.d4WAEAKQ4F/p3WseBGN9XUo/ECi1q9.RGhOqBCEhod6y3BG', 'ROLE_ADMIN', '123456789', 1),
(15, b'1', 'Pavón2', 'yerayd992@gmail.com', 'DAS', 'Yeray2', '$2a$10$drSDenwGrwU1Ml3vmQOhpu05fGJi4hy01aUtqCdNarzVa0daZKxL.', 'ROLE_RRHH', '690647914', 1),
(14, b'1', 'Pavón', 'yerayd99@gmail.com', 'DAS', 'Yeray', '$2a$10$drSDenwGrwU1Ml3vmQOhpu05fGJi4hy01aUtqCdNarzVa0daZKxL.', 'ROLE_RRHH', '690647914', 1),
(1, b'1', 'DP', 'Yerayd@gmail.com', 'DAW', 'Y', '$2a$10$drSDenwGrwU1Ml3vmQOhpu05fGJi4hy01aUtqCdNarzVa0daZKxL.', 'ROLE_ALUMNO', '090909', 1),
(16, b'1', 'DP2', 'Yeray2d@gmail.com', 'DAW', 'Y2', '$2a$10$drSDenwGrwU1Ml3vmQOhpu05fGJi4hy01aUtqCdNarzVa0daZKxL.', 'ROLE_ALUMNO', '090909', 1);

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
