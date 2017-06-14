/*
SQLyog Community v10.3 
MySQL - 5.7.16-log : Database - dda
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dda` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dda`;

/*Table structure for table `identificador` */

DROP TABLE IF EXISTS `identificador`;

CREATE TABLE `identificador` (
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`valor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `identificador` */

insert  into `identificador`(`valor`) values (25);

/*Table structure for table `tarjeta` */

DROP TABLE IF EXISTS `tarjeta`;

CREATE TABLE `tarjeta` (
  `oid` int(11) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `vencimiento` date NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tarjeta` */

insert  into `tarjeta`(`oid`,`numero`,`vencimiento`) values (23,6546546,'2017-06-08'),(24,6546547,'2017-06-08'),(25,6546548,'2017-06-08');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `oid` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`oid`,`nombre`,`password`) values (16,'gonzalo38','38'),(18,'gonzalo39','38'),(20,'nuevo','pn'),(21,'nuevo89','pn8'),(13,'otro para g','opg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
