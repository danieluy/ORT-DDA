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
  `oid` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `nombrecompleto` varchar(60) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `administradores` */

insert  into `administradores`(`oid`,`nombre`,`nombrecompleto`,`password`) values 
(5,'daniel','Daniel Sosa','pass'),
(6,'eduardo','Eduardo Cardozo','pass');

/*Table structure for table `casilleros` */

DROP TABLE IF EXISTS `casilleros`;

CREATE TABLE `casilleros` (
  `nro` int(11) NOT NULL,
  `nroMovimiento` int(11) NOT NULL,
  `oidPartida` int(11) NOT NULL,
  `mina` char(1) DEFAULT NULL,
  PRIMARY KEY (`nro`,`nroMovimiento`,`oidPartida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `casilleros` */

insert  into `casilleros`(`nro`,`nroMovimiento`,`oidPartida`,`mina`) values 
(0,0,33,NULL),
(0,1,33,NULL),
(0,2,33,NULL),
(0,3,33,NULL),
(0,4,33,NULL),
(0,5,33,NULL),
(0,6,33,NULL),
(0,7,33,NULL),
(1,0,33,NULL),
(1,1,33,NULL),
(1,2,33,NULL),
(1,3,33,NULL),
(1,4,33,NULL),
(1,5,33,NULL),
(1,6,33,NULL),
(1,7,33,NULL),
(2,0,33,NULL),
(2,1,33,NULL),
(2,2,33,NULL),
(2,3,33,NULL),
(2,4,33,NULL),
(2,5,33,NULL),
(2,6,33,NULL),
(2,7,33,NULL),
(3,0,33,NULL),
(3,1,33,NULL),
(3,2,33,NULL),
(3,3,33,NULL),
(3,4,33,NULL),
(3,5,33,NULL),
(3,6,33,NULL),
(3,7,33,NULL),
(4,0,33,NULL),
(4,1,33,NULL),
(4,2,33,NULL),
(4,3,33,NULL),
(4,4,33,NULL),
(4,5,33,'T'),
(4,6,33,'T'),
(4,7,33,'T'),
(5,0,33,NULL),
(5,1,33,NULL),
(5,2,33,NULL),
(5,3,33,NULL),
(5,4,33,NULL),
(5,5,33,NULL),
(5,6,33,'S'),
(5,7,33,'S'),
(6,0,33,NULL),
(6,1,33,NULL),
(6,2,33,NULL),
(6,3,33,NULL),
(6,4,33,NULL),
(6,5,33,NULL),
(6,6,33,NULL),
(6,7,33,'E'),
(7,0,33,NULL),
(7,1,33,NULL),
(7,2,33,NULL),
(7,3,33,NULL),
(7,4,33,NULL),
(7,5,33,NULL),
(7,6,33,NULL),
(7,7,33,'T'),
(8,0,33,NULL),
(8,1,33,NULL),
(8,2,33,NULL),
(8,3,33,NULL),
(8,4,33,NULL),
(8,5,33,NULL),
(8,6,33,NULL),
(8,7,33,'S');

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

/*Table structure for table `movimientos` */

DROP TABLE IF EXISTS `movimientos`;

CREATE TABLE `movimientos` (
  `nro` int(11) NOT NULL,
  `oidPartida` int(11) NOT NULL,
  `jugador` int(11) NOT NULL,
  `pozo` double NOT NULL,
  `numeroTurno` int(11) NOT NULL,
  PRIMARY KEY (`nro`,`oidPartida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `movimientos` */

insert  into `movimientos`(`nro`,`oidPartida`,`jugador`,`pozo`,`numeroTurno`) values 
(0,33,2,20,0),
(1,33,1,20,0),
(2,33,2,20,1),
(3,33,1,20,1),
(4,33,2,20,2),
(5,33,1,20,2),
(6,33,2,20,3),
(7,33,2,20,3);

/*Table structure for table `oid` */

DROP TABLE IF EXISTS `oid`;

CREATE TABLE `oid` (
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`valor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oid` */

insert  into `oid`(`valor`) values 
(33);

/*Table structure for table `partidas` */

DROP TABLE IF EXISTS `partidas`;

CREATE TABLE `partidas` (
  `oid` int(11) NOT NULL,
  `tamano` int(11) NOT NULL,
  `ganador` int(11) NOT NULL,
  `jugador1` int(11) NOT NULL,
  `jugador2` int(11) NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `partidas` */

insert  into `partidas`(`oid`,`tamano`,`ganador`,`jugador1`,`jugador2`) values 
(33,3,1,2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
