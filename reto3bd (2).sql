-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 12-02-2023 a las 15:51:03
-- Versión del servidor: 8.0.30
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reto3bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cines`
--

CREATE TABLE `cines` (
  `id_cine` int NOT NULL,
  `nombreCine` varchar(30) NOT NULL,
  `num_salas` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cines`
--

INSERT INTO `cines` (`id_cine`, `nombreCine`, `num_salas`) VALUES
(1, 'Cines Yelmo', 3),
(2, 'Cines Elorrieta', 2),
(3, 'Cines Muñoz', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `dni` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `contrasena` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`dni`, `nombre`, `Apellidos`, `sexo`, `contrasena`) VALUES
(12345678, 'Juan', 'Mano Calva', 'H', '12345'),
(87654321, 'Manoli', 'Garcia Guti', 'F', '54321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `id_entrada` int NOT NULL,
  `id_sesion` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int NOT NULL,
  `dni` int NOT NULL,
  `num_pedido` int NOT NULL,
  `precioTotal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id_pelicula` int NOT NULL,
  `nombrePelicula` varchar(100) NOT NULL,
  `precio` float NOT NULL,
  `duracion` int NOT NULL,
  `genero` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id_pelicula`, `nombrePelicula`, `precio`, `duracion`, `genero`) VALUES
(1, 'Shrek', 7.5, 90, 'Comedia'),
(2, 'Interestelar', 7.5, 169, 'Drama'),
(3, 'John Wick', 7.5, 101, 'Acción'),
(4, 'Hello Kitty Becomes A Princess', 7.5, 55, 'Terror'),
(5, 'Zatura', 7.5, 101, 'Ciencia Ficción');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `id_sala` int NOT NULL,
  `nombreSalas` varchar(30) NOT NULL,
  `id_cine` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`id_sala`, `nombreSalas`, `id_cine`) VALUES
(1, 'Sala Principal', 1),
(2, 'Sala Secundaria', 1),
(3, 'Sala Tercera', 1),
(4, 'Sala Principal', 2),
(5, 'Sala Secundaria', 2),
(6, 'Sala Principal', 3),
(7, 'Sala Secundaria', 3),
(8, 'Sala Tercera', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesiones`
--

CREATE TABLE `sesiones` (
  `id_sesion` int NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `id_pelicula` int NOT NULL,
  `id_sala` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `sesiones`
--

INSERT INTO `sesiones` (`id_sesion`, `fecha`, `hora`, `id_pelicula`, `id_sala`) VALUES
(1, '2023-02-07', '16:00:00', 1, 1),
(2, '2023-02-17', '18:00:00', 5, 2),
(3, '2023-02-09', '12:30:00', 1, 3),
(4, '2023-02-08', '16:00:00', 2, 4),
(5, '2023-02-08', '18:00:00', 3, 5),
(6, '2023-02-07', '12:30:00', 2, 6),
(7, '2023-02-17', '12:30:00', 4, 7),
(8, '2023-02-08', '12:30:00', 3, 8),
(9, '2023-02-17', '12:30:00', 2, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cines`
--
ALTER TABLE `cines`
  ADD PRIMARY KEY (`id_cine`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`id_entrada`),
  ADD KEY `FK_Sesiones_Entrada` (`id_sesion`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `FK_Cliente_Pedido` (`dni`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id_pelicula`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`id_sala`),
  ADD KEY `FK_Cines_Salas` (`id_cine`);

--
-- Indices de la tabla `sesiones`
--
ALTER TABLE `sesiones`
  ADD PRIMARY KEY (`id_sesion`),
  ADD KEY `FK_Peliculas_Sesiones` (`id_pelicula`),
  ADD KEY `FK_Salas_Sesiones` (`id_sala`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `id_entrada` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `FK_Sesiones_Entrada` FOREIGN KEY (`id_sesion`) REFERENCES `sesiones` (`id_sesion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_Cliente_Pedido` FOREIGN KEY (`dni`) REFERENCES `cliente` (`dni`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `salas`
--
ALTER TABLE `salas`
  ADD CONSTRAINT `FK_Cines_Salas` FOREIGN KEY (`id_cine`) REFERENCES `cines` (`id_cine`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sesiones`
--
ALTER TABLE `sesiones`
  ADD CONSTRAINT `FK_Peliculas_Sesiones` FOREIGN KEY (`id_pelicula`) REFERENCES `peliculas` (`id_pelicula`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Salas_Sesiones` FOREIGN KEY (`id_sala`) REFERENCES `salas` (`id_sala`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
