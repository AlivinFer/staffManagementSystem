/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.25 : Database - sms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sms` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `sms`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int NOT NULL,
  `dname` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `department` */

insert  into `department`(`id`,`dname`) values (1510,'教学部'),(1511,'市场部'),(1512,'教研部'),(1513,'运营部'),(1514,'后勤部');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `did` int NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `did` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `employee` */

insert  into `employee`(`eid`,`ename`,`email`,`gender`,`createTime`,`did`,`updateTime`) values (1,'费费','456852@qq.com',0,'2021-07-08 00:00:00',1510,'2021-07-29 11:15:50'),(2,'憨憨','357951@163.com',1,'2021-07-08 00:00:00',1511,'2021-07-29 11:15:50'),(3,'猪猪','369741@gmail.com',0,'2021-07-08 00:00:00',1512,'2021-07-29 11:15:50'),(4,'呆呆','468153@qq.com',1,'2021-07-08 00:00:00',1513,'2021-07-29 11:15:50'),(5,'尤尤','258146@163.com',0,'2022-02-01 00:00:00',1510,'2021-07-29 11:15:50'),(7,'嘿嘿','907406152@163.com',1,'2022-02-01 00:00:00',1510,'2021-07-29 11:15:50'),(8,'小黑','457516@foxmail.com',1,'2021-07-29 15:01:09',1512,'2021-07-29 15:01:09'),(9,'','457516@foxmail.com',1,'2021-07-29 15:26:39',1514,'2021-07-29 15:26:39');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
