/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.36 : Database - pms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pms` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pms`;

/*Table structure for table `charger` */

DROP TABLE IF EXISTS `charger`;

CREATE TABLE `charger` (
  `cardtype` varchar(20) DEFAULT NULL,
  `stationtype` varchar(20) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `charge` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `charger` */

/*Table structure for table `park` */

DROP TABLE IF EXISTS `park`;

CREATE TABLE `park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardid` int(11) DEFAULT NULL,
  `stationid` int(11) DEFAULT NULL,
  `startpark` datetime DEFAULT NULL,
  `endpark` datetime DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `park` */

/*Table structure for table `sitinfor` */

DROP TABLE IF EXISTS `sitinfor`;

CREATE TABLE `sitinfor` (
  `stationid` int(11) NOT NULL,
  `stationtype` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sitinfor` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `carId` varchar(20) DEFAULT NULL,
  `tel` varchar(13) DEFAULT NULL,
  `usertype` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
