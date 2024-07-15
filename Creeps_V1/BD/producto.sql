-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-07-2024 a las 23:43:13
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
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `talla` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `url_imagen` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `genero`, `talla`, `precio`, `stock`, `url_imagen`) VALUES
(3, 'Prueba', '1', '2', 250.00, 5, 'https://storage.googleapis.com/creeps-2f924.appspot.com/creeps/producto/img0000000000000000003CreepsLogo.JPG?GoogleAccessId=firebase-adminsdk-wrdz7@creeps-2f924.iam.gserviceaccount.com&Expires=2036378026&Signature=gjDjhjh42IXNoSGBEZ%2FtVsnZy%2Bomgmj4YnJIPbhyrIvw3O9c7KNELoLgLy3J2kX77%2FYHOkaOYB2zJFu5L1Qmh%2BUDVkAg5a%2BJmvpitzJK1iMobkHK7nh3TRj5xUqC%2Bu3vsRn7mUVe3wGpePAGN3aCvMUcm2Kk7EAXBQsivmsrqLblNTqbK%2FRQEVgyPYgQfwdac0ZHXw%2B1Pa5T4IVEDqa6b83XfwZ78147CWtgmgHMYHy4%2Bja%2BQxgzq656WogjpSq3CJY5D7RmY2HoUMJZCq6scMVP8cRsvU%2BVDBrHG7arTrZyqpRg2n6lRRVO3yQKvQzcQxa9y%2BWH4VTL7%2BSAI5L5%2Fw%3D%3D'),
(4, 'Prueba2', '2', '3', 500.00, 10, 'https://storage.googleapis.com/creeps-2f924.appspot.com/creeps/producto/img0000000000000000004camisa-oxford-para-mujer.png?GoogleAccessId=firebase-adminsdk-wrdz7@creeps-2f924.iam.gserviceaccount.com&Expires=2036439586&Signature=QGaGNiTLYHQIG0oVRLcb%2FE7iyUgi8jf%2BLRPMCWKFXtVE58c%2B3MR%2BEWGsFSAt27ofsXIWNFe5MFPidHbSP87jvyW0W2Tti%2FJ2GyXpXyLBncjOtVvVDzrl91vfJe2YRfxSNiWv0xAkFSW54b6xA%2BC3vGh3sOKvctNM05TkBp2aU2wyfxW6QyQ2A%2BlJLnLPu03B%2BaVT8pMvmSTWdQHnzseO8sDCbVCJVn15kxmPUhv6M6g1WMfarCPV6gF2%2FYWGoqG6daz9T3zbtuLH0VHJPIMAMUKZwybd7KFjzLwqhzJ2YfrdO%2B%2FweFpijpF90nl%2BH7oa6WKOHMR6C67DUhpEXb%2BNOQ%3D%3D');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
