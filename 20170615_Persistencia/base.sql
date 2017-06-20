/*
SQLyog Community v11.52 (32 bit)
MySQL - 5.0.51b-community-nt-log : Database - dda
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

/*Table structure for table `cabezal` */

DROP TABLE IF EXISTS `cabezal`;

CREATE TABLE `cabezal` (
  `oid` int(11) NOT NULL,
  `numero` int(11) NOT NULL auto_increment,
  `datos` varchar(50) NOT NULL,
  PRIMARY KEY  (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `cabezal` */

insert  into `cabezal`(`oid`,`numero`,`datos`) values (27,1,'DATOS FACTURA 1'),(28,2,'DATOS FACTURA 2'),(29,3,'DATOS FACTURA 3');

/*Table structure for table `identificador` */

DROP TABLE IF EXISTS `identificador`;

CREATE TABLE `identificador` (
  `valor` int(11) NOT NULL,
  PRIMARY KEY  (`valor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `identificador` */

insert  into `identificador`(`valor`) values (29);

/*Table structure for table `linea` */

DROP TABLE IF EXISTS `linea`;

CREATE TABLE `linea` (
  `oid` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `cantidad` int(11) default NULL,
  `producto` varchar(50) NOT NULL,
  PRIMARY KEY  (`oid`,`producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `linea` */

insert  into `linea`(`oid`,`numero`,`cantidad`,`producto`) values (27,1,3,'chicle'),(27,2,14,'escoba'),(27,3,25,'monitor'),(28,2,18,'almohada'),(28,1,30,'mercedes'),(29,1,3,'papas'),(29,2,8,'zapallos');

/*Table structure for table `tarjeta` */

DROP TABLE IF EXISTS `tarjeta`;

CREATE TABLE `tarjeta` (
  `oid` int(11) default NULL,
  `numero` int(11) NOT NULL,
  `vencimiento` date NOT NULL,
  PRIMARY KEY  (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tarjeta` */

insert  into `tarjeta`(`oid`,`numero`,`vencimiento`) values (23,6546546,'2017-06-08'),(24,6546547,'2017-06-08'),(25,6546548,'2017-06-08');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `oid` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY  (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`oid`,`nombre`,`password`) values (16,'gonzalo38','38'),(18,'gonzalo39','38'),(20,'nuevo','pn'),(21,'nuevo89','pn8'),(13,'otro para g','opg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
