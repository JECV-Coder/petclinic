-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-03-2019 a las 17:12:55
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11
<<<<<<< HEAD
-- Con mucho amor, del equipo los Charizcos
=======
>>>>>>> ec7065e6b355e5129d0e154f9ece3eb88a0c061e

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `petclinic`
--
<<<<<<< HEAD
CREATE DATABASE IF NOT EXISTS `petclinicV2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `petclinicV2`;
=======
CREATE DATABASE IF NOT EXISTS `petclinic` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `petclinic`;
>>>>>>> ec7065e6b355e5129d0e154f9ece3eb88a0c061e

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

DROP TABLE IF EXISTS `citas`;
CREATE TABLE IF NOT EXISTS `citas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `mascota` varchar(50) NOT NULL,
  `especialidad` int(11) DEFAULT NULL,
  `confirmacion` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `especialidad` (`especialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
CREATE TABLE IF NOT EXISTS `especialidades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `especialidades`
--

INSERT INTO `especialidades` (`id`, `nombre`) VALUES
(1, 'Cardiologia'),
(2, 'Dermatologia'),
<<<<<<< HEAD
(3, 'Fisioterapia'),
(4, 'Dentista');
=======
(3, 'Fisioterapia');
>>>>>>> ec7065e6b355e5129d0e154f9ece3eb88a0c061e

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
CREATE TABLE IF NOT EXISTS `medicamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingrediente_activo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `presentacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `medicamento`
--

INSERT INTO `medicamento` (`id`, `ingrediente_activo`, `nombre`, `presentacion`) VALUES
(1, 'ingrediente aaaaactivo', 'nombreeeeee', 'presentaciooooon'),
(2, 'chairez', 'chairicospus', 'nose'),
(3, 'ingrediente aaaaactivo', 'nombreeeeee', 'presentaciooooon'),
(4, 'ingrediente aaaaactivo', 'nombreeeeee', 'presentaciooooon'),
(5, 'ingrediente aaaaactivo', 'nombreeeeee', 'presentaciooooon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `owners`
--

DROP TABLE IF EXISTS `owners`;
CREATE TABLE IF NOT EXISTS `owners` (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `latitud` varchar(255) NOT NULL,
  `longitud` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `owners`
--

INSERT INTO `owners` (`id`, `first_name`, `last_name`, `address`, `city`, `telephone`, `user_id`, `latitud`, `longitud`, `imagen`) VALUES
(2, 'Don owner', 'ownersito', 'Calle Glorioso Lodasal', 'Tuxtlas', '123456', 2, '1', '1', '/resources/images/STCy9ysyTO'),
(3, 'Joe unitario', 'Franklin', '110 W. Liberty St.', 'Madison', '65551023', 11, '1', '1', '/resources/images/Bt19CILih1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pets`
--

DROP TABLE IF EXISTS `pets`;
CREATE TABLE IF NOT EXISTS `pets` (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `type_id` int(4) UNSIGNED NOT NULL,
  `owner_id` int(4) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `FK6teg4kcjcnjhduguft56wcfoa` (`owner_id`),
  KEY `FKtmmh1tq8pah5vxf8kuqqplo4p` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pets`
--

INSERT INTO `pets` (`id`, `name`, `birth_date`, `type_id`, `owner_id`) VALUES
(1, 'Arisquito', '1998-11-22', 4, 2),
(2, 'pruebita', '1998-11-11', 2, 3),
(3, 'Gratus1', '2019-03-05', 1, 2),
(4, 'Gratus2', '2019-02-05', 1, 2),
(5, 'Gratus2', '2019-02-05', 1, 2),
(6, 'Gratus2', '2019-02-05', 1, 2),
(7, 'Gratus2', '2019-02-05', 1, 2),
(8, 'Gratus2', '2019-02-05', 1, 2),
(9, 'Gratus2', '2019-02-05', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilege`
--

DROP TABLE IF EXISTS `privilege`;
CREATE TABLE IF NOT EXISTS `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `privilege`
--

INSERT INTO `privilege` (`id`, `name`) VALUES
(1, 'ADMIN_PRIVILEGE'),
(2, 'OWNER_PRIVILEGE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `description` text CHARACTER SET utf8 NOT NULL,
  `price` float NOT NULL,
  `existence` int(11) NOT NULL,
  `photo` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `price`, `existence`, `photo`) VALUES
(1, 'prueba', 'producto de prueba', 10, 3, 'image');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `records`
--

DROP TABLE IF EXISTS `records`;
CREATE TABLE IF NOT EXISTS `records` (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `record_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `records`
--

INSERT INTO `records` (`id`, `description`, `record_date`, `type`, `user_email`) VALUES
(1, 'Contraseña o usuario incorrectos', '2019-03-29 01:46:12', 'failure', 'test'),
(2, 'Contraseña o usuario incorrectos', '2019-03-29 01:46:17', 'failure', 'admin'),
(3, 'Contraseña o usuario incorrectos', '2019-03-29 01:46:21', 'failure', 'admin'),
(4, 'Contraseña o usuario incorrectos', '2019-03-29 01:48:02', 'failure', 'admin'),
(5, 'Contraseña o usuario incorrectos', '2019-03-29 01:48:09', 'failure', 'admin'),
(6, 'Usuario ingreso al sistema sin problemas', '2019-03-29 01:48:23', 'success', 'admin@admin.com'),
(7, 'Contraseña o usuario incorrectos', '2019-03-29 01:48:53', 'failure', 'owner@owner.com'),
(8, 'Usuario ingreso al sistema sin problemas', '2019-03-29 01:49:03', 'success', 'owner@owner.com'),
(9, 'El usuario esta deshabilitado', '2019-03-29 02:20:39', 'failure', 'disabled@disabled.com'),
(10, 'Usuario ingreso al sistema sin problemas', '2019-03-29 02:20:40', 'success', 'admin@admin.com'),
(11, 'Contraseña o usuario incorrectos', '2019-03-29 02:20:40', 'failure', 'test'),
(12, 'Contraseña o usuario incorrectos', '2019-03-29 02:20:40', 'failure', 'owner@owner.com'),
(13, 'Usuario ingreso al sistema sin problemas', '2019-03-29 02:46:17', 'success', 'admin@admin.com'),
(14, 'Contraseña o usuario incorrectos', '2019-03-29 03:18:50', 'failure', 'disabled@disabled.com'),
(15, 'Usuario ingreso al sistema sin problemas', '2019-03-29 03:18:51', 'success', 'admin@admin.com'),
(16, 'Contraseña o usuario incorrectos', '2019-03-29 03:18:51', 'failure', 'test'),
(17, 'Usuario ingreso al sistema sin problemas', '2019-03-29 03:18:51', 'success', 'owner@owner.com'),
(18, 'El usuario esta deshabilitado', '2019-03-29 03:21:09', 'failure', 'prueba@prueba2.com'),
(19, 'El usuario esta deshabilitado', '2019-03-29 03:24:16', 'failure', 'prueba@prueba2.com'),
(20, 'Usuario ingreso al sistema sin problemas', '2019-03-29 03:24:17', 'success', 'admin@admin.com'),
(21, 'Contraseña o usuario incorrectos', '2019-03-29 03:24:17', 'failure', 'test'),
(22, 'Usuario ingreso al sistema sin problemas', '2019-03-29 03:24:17', 'success', 'owner@owner.com'),
(23, 'El usuario esta deshabilitado', '2019-03-29 03:32:06', 'failure', 'prueba@prueba2.com'),
(24, 'Usuario ingreso al sistema sin problemas', '2019-03-29 03:32:07', 'success', 'admin@admin.com'),
(25, 'Contraseña o usuario incorrectos', '2019-03-29 03:32:07', 'failure', 'test'),
(26, 'Usuario ingreso al sistema sin problemas', '2019-03-29 03:32:07', 'success', 'owner@owner.com'),
(27, 'Usuario ingreso al sistema sin problemas', '2019-03-29 03:55:27', 'success', 'admin@admin.com'),
(28, 'El usuario esta deshabilitado', '2019-03-29 21:46:46', 'failure', 'prueba@prueba2.com'),
(29, 'Usuario ingreso al sistema sin problemas', '2019-03-29 21:46:46', 'success', 'admin@admin.com'),
(30, 'Contraseña o usuario incorrectos', '2019-03-29 21:46:46', 'failure', 'test'),
(31, 'Usuario ingreso al sistema sin problemas', '2019-03-29 21:46:46', 'success', 'owner@owner.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_OWNER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles_privileges`
--

DROP TABLE IF EXISTS `roles_privileges`;
CREATE TABLE IF NOT EXISTS `roles_privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `privilege_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`),
  UNIQUE KEY `privilege_id` (`privilege_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `roles_privileges`
--

INSERT INTO `roles_privileges` (`id`, `role_id`, `privilege_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `specialties`
--

DROP TABLE IF EXISTS `specialties`;
CREATE TABLE IF NOT EXISTS `specialties` (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `specialties`
--

INSERT INTO `specialties` (`id`, `name`) VALUES
(3, 'dentistry'),
(1, 'radiology'),
(2, 'surgery');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `types`
--

DROP TABLE IF EXISTS `types`;
CREATE TABLE IF NOT EXISTS `types` (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `types`
--

INSERT INTO `types` (`id`, `name`) VALUES
(5, 'bird'),
(1, 'cat'),
(2, 'dog'),
(6, 'hamster'),
(3, 'lizard'),
(4, 'snake');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `active` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) NOT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `active`, `email`, `password`, `telephone`, `zipcode`, `city`) VALUES
(1, 'admin', 'admin', '1', 'admin@admin.com', '{bcrypt}$2a$10$iW6qYvcNvLkVvpHHKipjOesInnL1aJ5qJBn2e7RcGNcAUKpZ745Ku', '12345678', '24094', 'Tuxtla Gutierrez'),
(11, 'Joe unitario', 'Franklin', '0', 'prueba@prueba2.com', '{bcrypt}$2a$10$cl2xhTuuIZ/qEE6663NbI.AUvM.eFXIX/giqbAwmLpwtEp3UheWv.', '65551023', '29049', 'Madison'),
(3, 'admin4', 'admin4', '0', 'admin@admin4', '{bcrypt}$2a$10$ldhW8HpJP.KPOCsDptNp.u7.s1jGvQruH71nxDCgOm3W6EWmf96ai', '123', '29010', 'tuxtla gutierrez'),
(2, 'Don owner', 'ownersito', '1', 'owner@owner.com', '{bcrypt}$2a$10$5UivHTZmvVm3CRFSYq3NH.0M7izKNjTsuwiNJjtQAa5LsrmwC0HrK', '123456', '29049', 'Tuxtlas'),
(5, 'Prueba', 'Prueba', '1', 'prueba@prueba.com', '{bcrypt}$2a$10$AgHrOrJgniIaQ55pwwuqu.Nu.DW7fqJYnDZ/jcn3dPWEtf6lEocx.', '123456', '29049', 'Tuxtla'),
(12, 'admin3', 'admin3', '1', 'admin@admin3', '{bcrypt}$2a$10$2DW3tbf4Gz65nI.26CBw1ewA0a1wT14ddR2A71vAq6TU./chvZ.ma', '123', '29010', 'tuxtla gutierrez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE IF NOT EXISTS `users_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `users_roles`
--

INSERT INTO `users_roles` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 1),
(3, 3, 1),
(4, 5, 1),
(8, 11, 2),
(9, 12, 1),
(10, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vets`
--

DROP TABLE IF EXISTS `vets`;
CREATE TABLE IF NOT EXISTS `vets` (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `Schedule` varchar(255) NOT NULL,
  `specialty_id` int(11) NOT NULL,
  `telephone` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vets`
--

INSERT INTO `vets` (`id`, `first_name`, `last_name`, `Schedule`, `specialty_id`, `telephone`) VALUES
(1, 'vet3', 'vet3', '2:40', 1234, '123'),
(2, 'Helen', 'Leary', '', 0, ''),
(3, 'Linda', 'Douglas', '', 0, ''),
(4, 'Rafael', 'Ortega', '', 0, ''),
(5, 'Henry', 'Stevens', '', 0, ''),
(6, 'Sharon', 'Jenkins', '', 0, ''),
(7, 'vet2', 'vet2', '2:40', 1234, '123'),
(8, 'vet2', 'vet2', '2:40', 1234, '123'),
(9, 'vet2', 'vet2', '2:40', 1234, '123'),
(10, 'vet2', 'vet2', '2:40', 1234, '123'),
(11, 'vet2', 'vet2', '2:40', 1234, '123'),
(12, 'vet2', 'vet2', '2:40', 1234, '123'),
(13, 'vet2', 'vet2', '2:40', 1234, '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vet_specialties`
--

DROP TABLE IF EXISTS `vet_specialties`;
CREATE TABLE IF NOT EXISTS `vet_specialties` (
  `vet_id` int(4) UNSIGNED NOT NULL,
  `specialty_id` int(4) UNSIGNED NOT NULL,
  UNIQUE KEY `vet_id` (`vet_id`,`specialty_id`),
  KEY `specialty_id` (`specialty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vet_specialties`
--

INSERT INTO `vet_specialties` (`vet_id`, `specialty_id`) VALUES
(2, 1),
(3, 2),
(3, 3),
(4, 2),
(5, 1);

-- --------------------------------------------------------

--
<<<<<<< HEAD
-- Estructura de tabla para la tabla `order_item`
--

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE IF NOT EXISTS `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `order_id` (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` date DEFAULT NULL,
  `total` float NOT NULL,
  `method_payment` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_id` (`owner_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


--
=======
>>>>>>> ec7065e6b355e5129d0e154f9ece3eb88a0c061e
-- Estructura de tabla para la tabla `visits`
--

DROP TABLE IF EXISTS `visits`;
CREATE TABLE IF NOT EXISTS `visits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visit_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `pet_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6jcifhlqqlsfseu67utlouauy` (`pet_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


<<<<<<< HEAD
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prescriptions`
--

DROP TABLE IF EXISTS `prescriptions`;
CREATE TABLE IF NOT EXISTS `prescriptions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `writing_date` date NOT NULL,
  `visit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `visit_id` (`visit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prescription_details`
--

DROP TABLE IF EXISTS `prescription_details`;
CREATE TABLE IF NOT EXISTS `prescription_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prescription_id` int(11) NOT NULL,
  `drug_id` int(11) NOT NULL,
  `frequency` int(11) DEFAULT NULL,
  `dose` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prescription_id` (`prescription_id`),
  KEY `drug_id` (`drug_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


--
-- Restricciones para tablas volcadas
--
=======
DROP TABLE IF EXISTS `prescripcion`;
CREATE TABLE `prescripcion` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha` date NOT NULL,
  `medicamento` varchar(100) NOT NULL,
  `dosis` varchar(100) NOT NULL,
  `frecuencia` varchar(100) NOT NULL,
  `citaid` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `prescripcion`
--

INSERT INTO `prescripcion` (`id`, `nombre`, `fecha`, `medicamento`, `dosis`, `frecuencia`, `citaid`) VALUES
(1, 'carlos', '2021-02-25', 'paracetamol', '150 miligramos', '1 vez al dia', 0),
(3, 'juan', '2021-02-25', 'Coca', '1 litro', '1 vez al dia', 0),
(9, 'asd', '2021-03-02', 'asd', 'as', 'sad', 0),
(10, 'asadas', '2021-03-02', 'asd', 'asd', 'asdfads', 2),
(14, 'df', '2021-03-12', 'dsf', 'dfs', 'a', 2);--
-- Restricciones para tablas volcadas
--

DROP TABLE IF EXISTS `purchases`;
CREATE TABLE IF NOT EXISTS `purchases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `product` varchar(100) NOT NULL,
  `payment_form` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


>>>>>>> ec7065e6b355e5129d0e154f9ece3eb88a0c061e

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`especialidad`) REFERENCES `especialidades` (`id`);

--
-- Filtros para la tabla `pets`
--
<<<<<<< HEAD

=======
>>>>>>> ec7065e6b355e5129d0e154f9ece3eb88a0c061e
ALTER TABLE `pets`
  ADD CONSTRAINT `FK6teg4kcjcnjhduguft56wcfoa` FOREIGN KEY (`owner_id`) REFERENCES `owners` (`id`),
  ADD CONSTRAINT `FKtmmh1tq8pah5vxf8kuqqplo4p` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`),
  ADD CONSTRAINT `pets_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `owners` (`id`),
  ADD CONSTRAINT `pets_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`);

--
-- Filtros para la tabla `vet_specialties`
--
ALTER TABLE `vet_specialties`
  ADD CONSTRAINT `vet_specialties_ibfk_1` FOREIGN KEY (`vet_id`) REFERENCES `vets` (`id`),
  ADD CONSTRAINT `vet_specialties_ibfk_2` FOREIGN KEY (`specialty_id`) REFERENCES `specialties` (`id`);
<<<<<<< HEAD

--
-- Filtros para la tabla `prescriptions`
--

ALTER TABLE `prescriptions`
  ADD CONSTRAINT `prescriptions_ibfk_1` FOREIGN KEY (`visit_id`) REFERENCES `visits` (`id`);

--
-- Filtros para la tabla `prescription_details`
--

ALTER TABLE `prescription_details`
  ADD CONSTRAINT `prescription_details_ibfk_1` FOREIGN KEY (`prescription_id`) REFERENCES `prescriptions` (`id`),
  ADD CONSTRAINT `prescription_details_ibfk_2` FOREIGN KEY (`drug_id`) REFERENCES `medicamento` (`id`);

--
-- Filtros para la tabla `orders`
--

ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `owners` (`id`);

--
-- Filtros para la tabla `order_item`
--

ALTER TABLE `order_item`
  ADD CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);
COMMIT;
=======
COMMIT;

>>>>>>> ec7065e6b355e5129d0e154f9ece3eb88a0c061e
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;