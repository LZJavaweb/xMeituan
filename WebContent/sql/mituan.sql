/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.20-log : Database - mituan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mituan` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mituan`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `addrId` int(20) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `userId` int(20) NOT NULL COMMENT '用户id',
  `addrName` varchar(20) NOT NULL COMMENT '收货人姓名',
  `addrPhone` varchar(11) NOT NULL COMMENT '收货人电话',
  `addrProv` varchar(20) NOT NULL COMMENT '省',
  `addrCity` varchar(20) NOT NULL COMMENT '市',
  `addrReal` varchar(100) NOT NULL COMMENT '详细地址',
  `addrFlag` int(2) NOT NULL COMMENT '是否为常用地址',
  PRIMARY KEY (`addrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `address` */

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `busiId` int(20) NOT NULL AUTO_INCREMENT COMMENT '商家id',
  `busiName` varchar(20) NOT NULL COMMENT '商家姓名',
  `busiPhone` varchar(11) NOT NULL COMMENT '商家电话',
  `busiPass` varchar(20) NOT NULL COMMENT '商家密码',
  `busiAddr` varchar(20) NOT NULL COMMENT '商家地址',
  `busiShopName` varchar(20) NOT NULL COMMENT '店铺名',
  `busiLogo` varchar(100) DEFAULT NULL COMMENT '商家logo',
  `busiNotice` varchar(100) DEFAULT NULL COMMENT '商家公告',
  `busiFlag` int(2) DEFAULT NULL COMMENT '是否开业',
  `busiBan` int(2) DEFAULT NULL COMMENT '商家是否被禁止',
  PRIMARY KEY (`busiId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `business` */

insert  into `business`(`busiId`,`busiName`,`busiPhone`,`busiPass`,`busiAddr`,`busiShopName`,`busiLogo`,`busiNotice`,`busiFlag`,`busiBan`) values 
(1,'武大郎','1234567898','wudalang','镇关西','武大郎烧饼(镇关西店)',NULL,NULL,NULL,NULL),
(2,'武当','1234567890','wudalang','广东省广州市','武大郎烧饼(广州店)',NULL,NULL,NULL,NULL);

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `foodId` int(20) NOT NULL AUTO_INCREMENT COMMENT '食品Id',
  `busiId` int(20) NOT NULL COMMENT '商家Id',
  `foodName` varchar(20) NOT NULL,
  `foodDesc` varchar(100) NOT NULL COMMENT '食品描述',
  `foodPrice` double NOT NULL COMMENT '食品价格',
  `foodStock` int(11) NOT NULL COMMENT '食品库存',
  `foodPic` varchar(200) NOT NULL COMMENT '食品图片',
  `foodType` varchar(20) DEFAULT NULL COMMENT '食品类型',
  `foodSale` int(2) DEFAULT NULL COMMENT '是否上架',
  PRIMARY KEY (`foodId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`foodId`,`busiId`,`foodName`,`foodDesc`,`foodPrice`,`foodStock`,`foodPic`,`foodType`,`foodSale`) values 
(8,1,'红烧猪肉','红色的烧过的猪肉',18,99,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\152913807536247931.png',NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `userPhone` varchar(11) NOT NULL COMMENT '用户注册电话',
  `userPass` varchar(20) NOT NULL COMMENT '用户密码',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`userPhone`,`userPass`,`userName`) values 
(1,'14718158227','zhoujunliang1','周军良'),
(5,'14718158220','zhoujunliang','zhou'),
(3,'13119119284','lin','metaloe123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
