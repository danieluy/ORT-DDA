/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.18-log : Database - obligatorio_203752
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`obligatorio_203752` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `obligatorio_203752`;

/*Table structure for table `administradores` */

DROP TABLE IF EXISTS `administradores`;

CREATE TABLE `administradores` (
  `oid` INT(11) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `nombrecompleto` VARCHAR(60) NOT NULL,
  `password` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `administradores` */

INSERT  INTO `administradores`(`oid`,`nombre`,`nombrecompleto`,`password`) VALUES 
(5,'daniel','Daniel Sosa','pass'),
(6,'eduardo','Eduardo Cardozo','pass');

/*Table structure for table `jugadores` */

DROP TABLE IF EXISTS `jugadores`;

CREATE TABLE `jugadores` (
  `oid` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `nombrecompleto` varchar(60) NOT NULL,
  `password` varchar(10) NOT NULL,
  `saldo` float NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jugadores` */

insert  into `jugadores`(`oid`,`nombre`,`nombrecompleto`,`password`,`saldo`) values 
(4,'angel','Angel Face','tfc',100),
(2,'marla','Marla Singer','tfc',100),
(3,'robert','Robert Paulson','tfc',100),
(1,'tyler','Tyler Durden','tfc',100);

/*Table structure for table `oid` */

DROP TABLE IF EXISTS `oid`;

CREATE TABLE `oid` (
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`valor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oid` */

insert  into `oid`(`valor`) values 
(6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
