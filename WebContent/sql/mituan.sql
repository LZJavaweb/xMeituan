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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`addrId`,`userId`,`addrName`,`addrPhone`,`addrProv`,`addrCity`,`addrReal`,`addrFlag`) values 
(4,1,'量均州','14718158227','广东','广州','海珠区仲恺农业工程学院',0),
(5,9,'量均州','14718158227','广东','广州','海珠区仲恺农业工程学院',0),
(6,9,'量均州','13533801121','广东','高州','海珠区仲恺农业工程学院',0),
(8,1,'zhoujunliang','13533801121','广东','高州','asdfasdfasdfasdfasdfasd',0);

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminId` int(20) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `adminName` varchar(20) NOT NULL COMMENT '管理员姓名',
  `adminPass` varchar(20) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`adminId`,`adminName`,`adminPass`) values 
(1,'adminroot','adminroot11');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `business` */

insert  into `business`(`busiId`,`busiName`,`busiPhone`,`busiPass`,`busiAddr`,`busiShopName`,`busiLogo`,`busiNotice`,`busiFlag`,`busiBan`) values 
(1,'武大郎','13533801121','zhoujun1','仲恺农业工程学院','一般般',NULL,'烧饼修改器',1,0),
(2,'武当','13512345678','wudalang','广东省广州市','武大郎烧饼(广州店)',NULL,NULL,1,1),
(3,'张三','13533802211','zhangsan11','广西省','鱼蛋粉',NULL,NULL,1,1),
(4,'周军良','14718158227','zhou1996','广东省广州市','米团',NULL,NULL,1,1);

/*Table structure for table `dingdan` */

DROP TABLE IF EXISTS `dingdan`;

CREATE TABLE `dingdan` (
  `orderId` int(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `userId` int(20) NOT NULL COMMENT '用户ID',
  `busiId` int(20) NOT NULL COMMENT '商家ID',
  `addrId` int(20) NOT NULL COMMENT '地址ID',
  `orderMoney` double NOT NULL COMMENT '订单金额',
  `orderState` varchar(40) NOT NULL COMMENT '订单状态',
  `orderBegin` datetime NOT NULL COMMENT '下单时间',
  `orderReceive` datetime DEFAULT NULL COMMENT '接单时间',
  `orderFinish` datetime DEFAULT NULL COMMENT '完成时间',
  `orderCancel` datetime DEFAULT NULL COMMENT '自动取消时间',
  `orderRemark` varchar(100) DEFAULT NULL COMMENT '订单备注',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `dingdan` */

insert  into `dingdan`(`orderId`,`userId`,`busiId`,`addrId`,`orderMoney`,`orderState`,`orderBegin`,`orderReceive`,`orderFinish`,`orderCancel`,`orderRemark`) values 
(1,1,1,1,64,'已评价','2018-06-18 20:38:50','2018-06-19 20:39:08','2018-06-19 20:39:17',NULL,'不要辣'),
(2,1,2,1,76,'已完成','2018-06-19 20:53:24','2018-06-19 20:53:26','2018-06-19 20:53:28',NULL,NULL),
(3,1,2,3,88.8,'已完成','2018-06-18 20:38:50','2018-06-19 20:53:26','2018-06-19 20:53:28',NULL,NULL),
(4,1,1,1,2.33,'已完成','2018-06-20 09:13:25','2018-06-20 15:19:21','2018-06-20 15:19:21',NULL,NULL),
(5,1,1,1,2.34,'已完成','2018-06-20 09:42:37','2018-06-21 20:04:20','2018-06-21 20:04:56',NULL,'加辣'),
(6,1,1,1,2.35,'已完成','2018-06-20 09:43:25','2018-06-21 20:04:23','2018-06-21 20:04:59',NULL,NULL),
(7,1,1,1,2.35,'已完成','2018-06-20 15:19:21','2018-06-21 20:04:25','2018-06-21 20:05:01',NULL,NULL),
(8,1,1,1,0,'已完成','2018-06-21 15:22:32','2018-06-21 20:04:27','2018-06-21 20:05:07',NULL,'不要加辣'),
(9,1,1,1,0,'已接单','2018-06-21 15:24:39','2018-06-21 20:04:36',NULL,NULL,'麻辣烫'),
(10,1,1,1,18,'已完成','2018-06-21 16:13:10','2018-06-21 20:04:38','2018-06-28 09:42:46',NULL,'不要加辣'),
(11,1,1,1,18,'已评价','2018-06-21 16:17:43','2018-06-21 20:04:42','2018-06-21 21:33:57',NULL,'麻辣烫'),
(13,1,1,1,18,'已接单','2018-06-21 16:21:48','2018-06-28 11:28:56',NULL,NULL,'麻辣烫甲乙'),
(14,1,1,1,18,'已接单','2018-06-21 16:24:30','2018-06-28 11:28:54',NULL,NULL,'麻辣烫丙丁'),
(15,1,1,1,18,'已接单','2018-06-21 16:26:11','2018-06-28 11:28:51',NULL,NULL,'是个身体'),
(16,1,1,1,18,'已评价','2018-06-21 16:26:27','2018-06-21 20:06:22','2018-06-21 21:47:12',NULL,'玩儿业务而言'),
(17,1,1,1,18,'已接单','2018-06-21 21:05:53','2018-06-28 11:28:49',NULL,NULL,'是个身体'),
(18,1,1,1,18,'已评价','2018-06-21 21:18:10',NULL,'2018-06-21 21:33:23',NULL,'玩儿业务而言123'),
(19,1,1,1,18,'已评价','2018-06-21 21:38:40','2018-06-21 21:42:44','2018-06-21 21:43:04',NULL,'不要加辣'),
(20,1,1,1,120,'已评价','2018-06-21 23:36:31','2018-06-21 23:36:40','2018-06-28 09:39:11',NULL,'我想吃好吃的'),
(21,1,1,1,120,'已接单','2018-06-22 01:33:08','2018-06-28 11:28:47',NULL,NULL,'不要加辣'),
(22,1,1,1,19,'已接单','2018-06-22 01:33:22','2018-06-28 11:28:45',NULL,NULL,'是个身体'),
(23,1,1,1,19,'已接单','2018-06-22 01:41:07','2018-06-28 11:28:42',NULL,NULL,'麻辣烫'),
(24,1,1,1,38,'已接单','2018-06-22 02:12:28','2018-06-28 11:28:39',NULL,NULL,'麻辣烫'),
(25,1,1,1,200,'已接单','2018-06-22 02:19:54','2018-06-28 11:28:38',NULL,NULL,'麻辣烫'),
(26,1,1,1,19,'已接单','2018-06-22 09:27:50','2018-06-28 11:28:36',NULL,NULL,'麻辣烫'),
(27,9,1,6,19,'已接单','2018-06-22 10:03:47','2018-06-28 11:28:34',NULL,NULL,'是个身体'),
(28,9,4,5,200,'已评价','2018-06-22 10:09:08','2018-06-22 10:09:21','2018-06-22 10:09:27',NULL,'好贵啊'),
(29,9,1,5,39,'已接单','2018-06-22 10:20:38','2018-06-28 11:28:33',NULL,NULL,''),
(30,1,1,1,100,'已接单','2018-06-22 13:49:20','2018-06-28 11:28:31',NULL,NULL,'不要加辣'),
(31,1,1,1,119,'已评价','2018-06-22 15:17:00','2018-06-22 15:18:38','2018-06-22 15:18:46',NULL,'不要加辣'),
(34,1,1,1,19,'已接单','2018-06-27 22:51:43','2018-06-28 11:28:30',NULL,NULL,'是个身体'),
(35,1,1,1,19,'已接单','2018-06-27 22:56:10','2018-06-28 11:28:28',NULL,NULL,'麻辣烫甲乙'),
(36,1,1,1,19,'已接单','2018-06-27 22:57:43','2018-06-28 11:28:26',NULL,NULL,'不要加辣'),
(37,1,1,1,200,'已接单','2018-06-27 22:58:38','2018-06-28 11:28:24',NULL,NULL,'不要加辣'),
(38,1,1,1,320,'已接单','2018-06-27 22:59:13','2018-06-28 11:28:22',NULL,NULL,'不要加辣'),
(39,1,1,1,20,'已接单','2018-06-27 23:08:40','2018-06-28 11:28:21',NULL,NULL,'不要加辣'),
(40,1,1,1,380,'已接单','2018-06-27 23:11:04','2018-06-28 11:28:20',NULL,NULL,'不要加辣'),
(41,1,1,1,200,'已接单','2018-06-27 23:17:07','2018-06-28 11:28:19',NULL,NULL,'不要加辣'),
(42,1,1,1,358,'已接单','2018-06-28 09:30:02','2018-06-28 11:28:19',NULL,NULL,'不要加辣');

/*Table structure for table `evaluation` */

DROP TABLE IF EXISTS `evaluation`;

CREATE TABLE `evaluation` (
  `evalId` int(20) NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  `orderId` int(20) NOT NULL COMMENT '订单ID',
  `evalContent` varchar(100) NOT NULL COMMENT '评价内容',
  `evalStar` int(2) NOT NULL COMMENT '评价星级',
  PRIMARY KEY (`evalId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `evaluation` */

insert  into `evaluation`(`evalId`,`orderId`,`evalContent`,`evalStar`) values 
(1,2,'很难吃',5),
(2,3,'haohaochi',5),
(3,4,'very good',1),
(4,1,'henbuhaochi',5),
(10,16,'hahaha',4),
(11,28,'果然是狗肉',5),
(12,31,'时间按到了房间爱上了的解放了',5),
(13,20,'',5),
(14,11,'1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`foodId`,`busiId`,`foodName`,`foodDesc`,`foodPrice`,`foodStock`,`foodPic`,`foodType`,`foodSale`) values 
(9,1,'鱼蛋粉','潮州鱼蛋粉',19,90,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\152959410816623378.jpg',NULL,NULL),
(10,1,'素食','健康饮食',20,90,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\152959438847613591.jpg',NULL,NULL),
(11,1,'烧烤','美味烧烤',100,12,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\152959442146483518.jpg',NULL,NULL),
(12,1,'羊肉','挂羊头卖狗肉',200,90,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\152959473526074534.jpg',NULL,NULL),
(13,1,'糕点','美味甜点',19,90,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\15295951193927071.png',NULL,NULL),
(14,4,'鱼蛋粉','好吃鱼蛋粉',19,90,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\152963323987751018.jpg',NULL,NULL),
(15,4,'素食主义','不长胖',20,90,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\152963326987014948.jpg',NULL,NULL),
(16,4,'羊肉','这是狗肉',200,99,'D:\\xMeituan\\WebContent\\resources\\BusiPic\\152963329563239092.jpg',NULL,NULL);

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `itemId` int(40) NOT NULL AUTO_INCREMENT COMMENT '订单项Id',
  `orderId` int(20) NOT NULL COMMENT '订单ID',
  `foodId` int(20) NOT NULL COMMENT '食品ID',
  `foodNum` int(2) NOT NULL COMMENT '食品数量',
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`itemId`,`orderId`,`foodId`,`foodNum`) values 
(1,1,8,8),
(2,2,7,7),
(3,1,2,3),
(4,1,1,3),
(5,1,1,3),
(6,10,8,1),
(7,11,8,1),
(8,12,8,1),
(9,13,8,1),
(10,14,8,1),
(11,15,8,1),
(12,16,8,1),
(13,17,8,1),
(14,18,8,1),
(15,19,8,1),
(16,20,10,1),
(17,20,11,1),
(18,21,10,1),
(19,21,11,1),
(20,22,9,1),
(21,23,9,1),
(22,24,9,1),
(23,24,13,1),
(24,25,12,1),
(25,26,13,1),
(26,27,13,1),
(27,28,16,1),
(28,29,9,1),
(29,29,10,1),
(30,30,11,1),
(31,31,9,1),
(32,31,11,1),
(35,34,9,2),
(36,35,9,2),
(37,36,9,2),
(38,37,11,2),
(39,38,10,1),
(40,38,11,1),
(41,38,12,1),
(42,39,10,1),
(43,40,9,20),
(44,41,12,1),
(45,42,9,1),
(46,42,10,1),
(47,42,11,1),
(48,42,12,1),
(49,42,13,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `userPhone` varchar(11) NOT NULL COMMENT '用户注册电话',
  `userPass` varchar(20) NOT NULL COMMENT '用户密码',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`userPhone`,`userPass`,`userName`) values 
(1,'14718158227','zhoujun1','zhoujun1'),
(5,'14718158220','zhoujunliang','zhou'),
(6,'14718158228','zhoujunliang1','良军周1'),
(7,'14711111111','zhoiu1996','量均州'),
(8,'14722222222','zhou1996','良君'),
(9,'14718158229','zhou1996','量均州'),
(13,'14718158333','zhoujun1','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
