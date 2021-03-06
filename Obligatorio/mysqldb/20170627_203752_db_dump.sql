/*
SQLyog Community v12.4.2 (64 bit)
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
  `color` varchar(11) NOT NULL,
  PRIMARY KEY (`nro`,`nroMovimiento`,`oidPartida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `casilleros` */

insert  into `casilleros`(`nro`,`nroMovimiento`,`oidPartida`,`mina`,`color`) values 
(0,0,37,NULL,'192,192,192'),
(0,0,38,NULL,'192,192,192'),
(0,1,37,NULL,'0,255,255'),
(0,1,38,NULL,'0,255,255'),
(0,2,37,NULL,'0,255,255'),
(0,2,38,NULL,'0,255,255'),
(0,3,37,NULL,'0,255,255'),
(0,3,38,NULL,'0,255,255'),
(0,4,37,NULL,'0,255,255'),
(0,4,38,NULL,'0,255,255'),
(0,5,38,NULL,'0,255,255'),
(0,6,38,NULL,'0,255,255'),
(0,7,38,NULL,'0,255,255'),
(0,8,38,NULL,'0,255,255'),
(0,9,38,NULL,'0,255,255'),
(1,0,37,NULL,'192,192,192'),
(1,0,38,NULL,'192,192,192'),
(1,1,37,NULL,'192,192,192'),
(1,1,38,NULL,'192,192,192'),
(1,2,37,NULL,'255,255,0'),
(1,2,38,NULL,'255,255,0'),
(1,3,37,NULL,'255,255,0'),
(1,3,38,NULL,'255,255,0'),
(1,4,37,NULL,'255,255,0'),
(1,4,38,NULL,'255,255,0'),
(1,5,38,NULL,'255,255,0'),
(1,6,38,NULL,'255,255,0'),
(1,7,38,NULL,'255,255,0'),
(1,8,38,NULL,'255,255,0'),
(1,9,38,NULL,'255,255,0'),
(2,0,37,NULL,'192,192,192'),
(2,0,38,NULL,'192,192,192'),
(2,1,37,NULL,'192,192,192'),
(2,1,38,NULL,'192,192,192'),
(2,2,37,NULL,'192,192,192'),
(2,2,38,NULL,'192,192,192'),
(2,3,37,NULL,'0,255,255'),
(2,3,38,NULL,'0,255,255'),
(2,4,37,NULL,'0,255,255'),
(2,4,38,NULL,'0,255,255'),
(2,5,38,NULL,'0,255,255'),
(2,6,38,NULL,'0,255,255'),
(2,7,38,NULL,'0,255,255'),
(2,8,38,NULL,'0,255,255'),
(2,9,38,NULL,'0,255,255'),
(3,0,37,NULL,'192,192,192'),
(3,0,38,NULL,'192,192,192'),
(3,1,37,NULL,'192,192,192'),
(3,1,38,NULL,'192,192,192'),
(3,2,37,NULL,'192,192,192'),
(3,2,38,NULL,'192,192,192'),
(3,3,37,NULL,'192,192,192'),
(3,3,38,NULL,'192,192,192'),
(3,4,37,'E','255,0,0'),
(3,4,38,'S','255,0,0'),
(3,5,38,'S','255,0,0'),
(3,6,38,'S','255,0,0'),
(3,7,38,'S','255,0,0'),
(3,8,38,'S','255,0,0'),
(3,9,38,'S','255,0,0'),
(4,0,37,NULL,'192,192,192'),
(4,0,38,NULL,'192,192,192'),
(4,1,37,NULL,'192,192,192'),
(4,1,38,NULL,'192,192,192'),
(4,2,37,NULL,'192,192,192'),
(4,2,38,NULL,'192,192,192'),
(4,3,37,NULL,'192,192,192'),
(4,3,38,NULL,'192,192,192'),
(4,4,37,NULL,'192,192,192'),
(4,4,38,NULL,'192,192,192'),
(4,5,38,'T','255,0,0'),
(4,6,38,'T','255,0,0'),
(4,7,38,'T','255,0,0'),
(4,8,38,'T','255,0,0'),
(4,9,38,'T','255,0,0'),
(5,0,37,NULL,'192,192,192'),
(5,0,38,NULL,'192,192,192'),
(5,1,37,NULL,'192,192,192'),
(5,1,38,NULL,'192,192,192'),
(5,2,37,NULL,'192,192,192'),
(5,2,38,NULL,'192,192,192'),
(5,3,37,NULL,'192,192,192'),
(5,3,38,NULL,'192,192,192'),
(5,4,37,'T','255,0,0'),
(5,4,38,NULL,'192,192,192'),
(5,5,38,NULL,'192,192,192'),
(5,6,38,'T','255,0,0'),
(5,7,38,'T','255,0,0'),
(5,8,38,'T','255,0,0'),
(5,9,38,'T','255,0,0'),
(6,0,37,NULL,'192,192,192'),
(6,0,38,NULL,'192,192,192'),
(6,1,37,NULL,'192,192,192'),
(6,1,38,NULL,'192,192,192'),
(6,2,37,NULL,'192,192,192'),
(6,2,38,NULL,'192,192,192'),
(6,3,37,NULL,'192,192,192'),
(6,3,38,NULL,'192,192,192'),
(6,4,37,NULL,'192,192,192'),
(6,4,38,NULL,'192,192,192'),
(6,5,38,NULL,'192,192,192'),
(6,6,38,NULL,'192,192,192'),
(6,7,38,'T','255,0,0'),
(6,8,38,'T','255,0,0'),
(6,9,38,'T','255,0,0'),
(7,0,37,NULL,'192,192,192'),
(7,0,38,NULL,'192,192,192'),
(7,1,37,NULL,'192,192,192'),
(7,1,38,NULL,'192,192,192'),
(7,2,37,NULL,'192,192,192'),
(7,2,38,NULL,'192,192,192'),
(7,3,37,NULL,'192,192,192'),
(7,3,38,NULL,'192,192,192'),
(7,4,37,'T','255,0,0'),
(7,4,38,NULL,'192,192,192'),
(7,5,38,NULL,'192,192,192'),
(7,6,38,NULL,'192,192,192'),
(7,7,38,NULL,'192,192,192'),
(7,8,38,NULL,'255,255,0'),
(7,9,38,NULL,'255,255,0'),
(8,0,37,NULL,'192,192,192'),
(8,0,38,NULL,'192,192,192'),
(8,1,37,NULL,'192,192,192'),
(8,1,38,NULL,'192,192,192'),
(8,2,37,NULL,'192,192,192'),
(8,2,38,NULL,'192,192,192'),
(8,3,37,NULL,'192,192,192'),
(8,3,38,NULL,'192,192,192'),
(8,4,37,NULL,'192,192,192'),
(8,4,38,NULL,'192,192,192'),
(8,5,38,NULL,'192,192,192'),
(8,6,38,NULL,'192,192,192'),
(8,7,38,NULL,'192,192,192'),
(8,8,38,NULL,'192,192,192'),
(8,9,38,'E','255,0,0');

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
(0,37,2,20,0),
(0,38,2,20,0),
(1,37,1,20,0),
(1,38,3,20,0),
(2,37,2,20,1),
(2,38,2,20,1),
(3,37,1,20,1),
(3,38,3,20,1),
(4,37,1,20,2),
(4,38,2,20,2),
(5,38,3,20,2),
(6,38,2,20,3),
(7,38,3,20,3),
(8,38,2,20,4),
(9,38,2,20,4);

/*Table structure for table `oid` */

DROP TABLE IF EXISTS `oid`;

CREATE TABLE `oid` (
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`valor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oid` */

insert  into `oid`(`valor`) values 
(38);

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
(37,3,2,2,1),
(38,3,3,2,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
