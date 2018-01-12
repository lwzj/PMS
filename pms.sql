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

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`password`) values (1,'admin','admin');

/*Table structure for table `charger` */

DROP TABLE IF EXISTS `charger`;

CREATE TABLE `charger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardtype` varchar(20) DEFAULT NULL,
  `stationtype` varchar(20) DEFAULT NULL,
  `charge` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `charger` */

insert  into `charger`(`id`,`cardtype`,`stationtype`,`charge`) values (1,'c1','s1',4),(2,'c2','s1',3),(3,'c3','s1',2),(4,'c4','s1',1),(5,'c1','s2',5),(6,'c2','s2',4),(7,'c3','s2',3),(8,'c4','s2',2),(9,'c1','s3',6),(10,'c2','s3',5),(11,'c3','s3',4),(12,'c4','s3',3);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `park` */

insert  into `park`(`id`,`carId`,`stationid`,`startpark`,`endpark`,`fee`) values (1,'123',1,'2018-01-04 10:35:40','2018-01-03 12:35:46',2),(5,'qq123',2,'2018-01-09 14:07:03','2018-01-09 14:13:47',0);

/*Table structure for table `sitinfor` */

DROP TABLE IF EXISTS `sitinfor`;

CREATE TABLE `sitinfor` (
  `stationid` int(11) NOT NULL,
  `stationtype` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sitinfor` */

insert  into `sitinfor`(`stationid`,`stationtype`) values (1,'s1'),(2,'s2'),(3,'s3'),(5,'s1'),(6,'s1'),(7,'s1'),(8,'s1'),(9,'s1'),(10,'s2'),(11,'s2'),(12,'s2'),(13,'s2'),(14,'s3'),(15,'s3'),(16,'s3'),(17,'s3'),(18,'s3'),(19,'s3'),(20,'s3');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`money`,`carId`,`tel`,`usertype`) values (1,'tt','123',22,'qq123','18816547895','c4'),(2,'你好','123123',NULL,'晋K-123456','123123','c2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
