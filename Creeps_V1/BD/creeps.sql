-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-08-2024 a las 07:57:46
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `creeps`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id_genero` int(11) NOT NULL,
  `descripcion` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id_genero`, `descripcion`) VALUES
(1, 'Masculino'),
(2, 'Femenino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `talla` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `url_imagen` text DEFAULT NULL,
  `id_genero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `talla`, `precio`, `stock`, `url_imagen`, `id_genero`) VALUES
(3, 'Prueba', 'L', 250.00, 5, 'https://storage.googleapis.com/creeps-2f924.appspot.com/creeps/producto/img0000000000000000003CreepsLogo.JPG?GoogleAccessId=firebase-adminsdk-wrdz7@creeps-2f924.iam.gserviceaccount.com&Expires=2036378026&Signature=gjDjhjh42IXNoSGBEZ%2FtVsnZy%2Bomgmj4YnJIPbhyrIvw3O9c7KNELoLgLy3J2kX77%2FYHOkaOYB2zJFu5L1Qmh%2BUDVkAg5a%2BJmvpitzJK1iMobkHK7nh3TRj5xUqC%2Bu3vsRn7mUVe3wGpePAGN3aCvMUcm2Kk7EAXBQsivmsrqLblNTqbK%2FRQEVgyPYgQfwdac0ZHXw%2B1Pa5T4IVEDqa6b83XfwZ78147CWtgmgHMYHy4%2Bja%2BQxgzq656WogjpSq3CJY5D7RmY2HoUMJZCq6scMVP8cRsvU%2BVDBrHG7arTrZyqpRg2n6lRRVO3yQKvQzcQxa9y%2BWH4VTL7%2BSAI5L5%2Fw%3D%3D', 1),
(4, 'Prueba2', '3', 500.00, 10, 'https://storage.googleapis.com/creeps-2f924.appspot.com/creeps/producto/img0000000000000000004camisa-oxford-para-mujer.png?GoogleAccessId=firebase-adminsdk-wrdz7@creeps-2f924.iam.gserviceaccount.com&Expires=2036439586&Signature=QGaGNiTLYHQIG0oVRLcb%2FE7iyUgi8jf%2BLRPMCWKFXtVE58c%2B3MR%2BEWGsFSAt27ofsXIWNFe5MFPidHbSP87jvyW0W2Tti%2FJ2GyXpXyLBncjOtVvVDzrl91vfJe2YRfxSNiWv0xAkFSW54b6xA%2BC3vGh3sOKvctNM05TkBp2aU2wyfxW6QyQ2A%2BlJLnLPu03B%2BaVT8pMvmSTWdQHnzseO8sDCbVCJVn15kxmPUhv6M6g1WMfarCPV6gF2%2FYWGoqG6daz9T3zbtuLH0VHJPIMAMUKZwybd7KFjzLwqhzJ2YfrdO%2B%2FweFpijpF90nl%2BH7oa6WKOHMR6C67DUhpEXb%2BNOQ%3D%3D', 1),
(5, 'Prueba3', '2', 15000.00, 25, 'https://storage.googleapis.com/creeps-2f924.appspot.com/creeps/producto/img0000000000000000005ropa2.jpg?GoogleAccessId=firebase-adminsdk-wrdz7@creeps-2f924.iam.gserviceaccount.com&Expires=2037495603&Signature=GykPHkB%2BUrPkMCMIFTOcv%2BQmkSP81EQH7%2FpiJTEALE2%2Bg0uc%2BbczuLvr7uhH729LrmaGFkctTb3aneFv6lBaRLGTJh%2FeWVZ4%2BjjAMdku%2BpeiArUGXJPbQN8lZc9miuJI%2B0EbHzN2tSeHPI36C4rtkKjDDEseEi6Gyl5sEXwKzMa2u8hVMk6eZoyhL55g%2FK3%2B9o6RvyFCQfEfJ0i%2BXkAAO8YXn015ypuQwok2lw5DD%2B1kkwEiyLTGKJIErcGf%2Bc0aeHmN5aNfAAtPRARjQPgXZ2sJ2ioapinUbO9Ob%2FTgvealB2KAK%2FPoXx0UGdeL4x8ccsS1jbC7yhqcBweeEUIbnw%3D%3D', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(512) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `correo` varchar(25) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id_factura`),
  ADD KEY `fk_factura_usuario` (`id_usuario`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id_genero`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `fk_genero` (`id_genero`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `fk_ventas_factura` (`id_factura`),
  ADD KEY `fk_ventas_producto` (`id_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id_genero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_factura_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_genero` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`);

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `rol_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_ventas_factura` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`),
  ADD CONSTRAINT `fk_ventas_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
