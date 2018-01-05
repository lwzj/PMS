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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardtype` varchar(20) DEFAULT NULL,
  `stationtype` varchar(20) DEFAULT NULL,
  `charge` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `charger` */

insert  into `charger`(`id`,`cardtype`,`stationtype`,`charge`) values (1,'11','22',2);

/*Table structure for table `park` */

DROP TABLE IF EXISTS `park`;

CREATE TABLE `park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` varchar(20) DEFAULT NULL,
  `stationid` int(11) DEFAULT NULL,
  `startpark` timestamp NULL DEFAULT NULL,
  `endpark` timestamp NULL DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `park` */

insert  into `park`(`id`,`carId`,`stationid`,`startpark`,`endpark`,`fee`) values (1,'123',1,'2018-01-04 10:35:40','2018-01-03 12:35:46',2);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`money`,`carId`,`tel`,`usertype`) values (1,'tt','123',20,'qq123','123','001');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
