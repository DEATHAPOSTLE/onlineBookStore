-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinebookstore
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityId` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `commentContent` varchar(600) DEFAULT NULL,
  `commentDTime` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_base`
--

DROP TABLE IF EXISTS `commodity_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity_base` (
  `commodityId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityName` varchar(135) DEFAULT NULL,
  `commodityPicture` varchar(3072) DEFAULT NULL,
  `commodityType` varchar(135) DEFAULT NULL,
  `commodityPrice` double DEFAULT NULL,
  `commodityIntroduce` varchar(3072) DEFAULT NULL,
  `commoditySurplus` int(11) DEFAULT NULL,
  `commodityRate` varchar(135) DEFAULT NULL,
  `commodityShelves` varchar(6) DEFAULT NULL,
  `commodityPress` varchar(135) DEFAULT NULL,
  `commodityAuthor` varchar(135) DEFAULT NULL,
  `commodityList` varchar(3072) DEFAULT NULL,
  `commodityContent` varchar(3072) DEFAULT NULL,
  `commodityInPrice` double DEFAULT '0',
  PRIMARY KEY (`commodityId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_base`
--

LOCK TABLES `commodity_base` WRITE;
/*!40000 ALTER TABLE `commodity_base` DISABLE KEYS */;
INSERT INTO `commodity_base` VALUES (8,'java编程思想','javabianchengsixiang.jpg','科技',123,'javabianchengsixiang.jpg',100,'1','1','北京出版社','孙凯然',NULL,NULL,NULL),(9,'c++编程思想','javabianchengsixiang.jpg','科技',13,'javabianchengsixiang.jpg',100,NULL,NULL,'天津出版社','孙凯然',NULL,NULL,NULL),(10,'军事杂谈','javabianchengsixiang.jpg','军事',111,'javabianchengsixiang.jpg',100,NULL,NULL,'北京出版社','李聿恒',NULL,NULL,NULL),(11,'坦克图鉴','javabianchengsixiang.jpg','军事',22,'javabianchengsixiang.jpg',31,NULL,NULL,'河北出版社','王雨威',NULL,NULL,NULL),(15,'表情包','javabianchengsixiang.jpg','娱乐',123,'javabianchengsixiang.jpg',26,'','1','石景山出版社','qhr',NULL,NULL,NULL),(16,'明朝那些事','javabianchengsixiang.jpg','历史',69,'javabianchengsixiang.jpg',14,NULL,'1','北京出版社','孙凯然',NULL,NULL,NULL),(17,'三国志','javabianchengsixiang.jpg','历史',35,'javabianchengsixiang.jpg',23,NULL,'1','北京出版社','孙凯然',NULL,NULL,NULL),(18,'史记','javabianchengsixiang.jpg','历史',64,'javabianchengsixiang.jpg',53,NULL,'1','北京出版社','孙凯然',NULL,NULL,NULL),(19,'西游记','javabianchengsixiang.jpg','历史',276,'javabianchengsixiang.jpg',12,NULL,'1','北京出版社','孙凯然',NULL,NULL,NULL),(20,'金瓶梅','javabianchengsixiang.jpg','古典小说',123,'javabianchengsixiang.jpg',100,'','1','无','无',NULL,NULL,NULL),(30,'阿萨德','javabianchengsixiang.jpg','阿阿斯顿',1234,'javabianchengsixiang.jpg',100,'','1','阿萨德','阿萨德',NULL,NULL,NULL),(31,'阿萨德','javabianchengsixiang.jpg','阿萨',1234,'javabianchengsixiang.jpg',100,'','1','阿萨德','阿萨德',NULL,NULL,NULL),(32,'自行车','javabianchengsixiang.jpg','自行车',14,'javabianchengsixiang.jpg',98,'','1','自行车','自行车',NULL,NULL,NULL),(33,'阿萨德','javabianchengsixiang.jpg','阿萨德',125,'javabianchengsixiang.jpg',99,'','1','阿萨德','阿萨德',NULL,NULL,NULL);
/*!40000 ALTER TABLE `commodity_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_base_examine`
--

DROP TABLE IF EXISTS `commodity_base_examine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity_base_examine` (
  `examineId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityName` varchar(135) DEFAULT NULL,
  `commodityPicture` varchar(3072) DEFAULT NULL,
  `commodityType` varchar(135) DEFAULT NULL,
  `commodityPrice` double DEFAULT NULL,
  `commodityIntroduce` varchar(3072) DEFAULT NULL,
  `commodityExamine` varchar(135) DEFAULT NULL,
  `commodityPress` varchar(135) DEFAULT NULL,
  `commodityAuthor` varchar(135) DEFAULT NULL,
  `commodityList` varchar(3072) DEFAULT NULL,
  `commodityContent` varchar(3072) DEFAULT NULL,
  `commodityInPrice` double DEFAULT '0',
  PRIMARY KEY (`examineId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_base_examine`
--

LOCK TABLES `commodity_base_examine` WRITE;
/*!40000 ALTER TABLE `commodity_base_examine` DISABLE KEYS */;
INSERT INTO `commodity_base_examine` VALUES (8,'天上人间','timg12.jpg','黄色',1222,'微信图片_20190401152233627.jpg','2','八大胡同出版社','朴一生',NULL,NULL,0),(9,'金瓶梅','QQ图片20190213163045xiaochou233.jpg','古典小说',123,'QQ图片20190218142350.png','1','无','无',NULL,NULL,0),(11,'表情包','QQ截图20190325142943.jpg','娱乐·',123,'QQ图片201902131632222245.jpg','1','石景山出版社','qhr',NULL,NULL,0),(20,'自行车','无标题.png','自行车',1234,'无标题.png','2','zxc','zxczxc',NULL,NULL,0),(21,'阿萨德','无标题.png','阿萨德',125,'无标题.png','1','阿萨德','阿萨德',NULL,NULL,0);
/*!40000 ALTER TABLE `commodity_base_examine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorites` (
  `favoritesId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `commodityId` varchar(20) DEFAULT NULL,
  `num` int(11) DEFAULT '1',
  PRIMARY KEY (`favoritesId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,1,'8',1);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityID` int(11) DEFAULT NULL,
  `orderPrice` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `orderStatus` varchar(135) DEFAULT NULL,
  `orderDTime` varchar(135) DEFAULT NULL,
  `deliveryDTime` varchar(135) DEFAULT NULL,
  `receiveDTime` varchar(135) DEFAULT NULL,
  `orderRate` varchar(135) DEFAULT NULL,
  `phoneNumber` varchar(135) DEFAULT NULL,
  `orderAddr` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (20,8,123,1,'8','2019-04-11 16:39:10','2019-04-11 16:39:10','2019-04-11 16:39:10','3','123','as'),(21,15,246,1,'3','2019-04-15 16:34:31','2019-04-15 16:51:01','2019-04-15 17:13:15','','3344','北京'),(22,15,246,1,'7','2019-04-15 16:47:48','2019-04-15 16:51:04','','','3344','北京'),(23,15,123,1,'2','2019-04-15 17:47:42','2019-04-15 21:03:12','','','3344','北京'),(24,15,123,4,'1','2019-04-15 17:50:21','','','','233','河北'),(25,15,123,0,'1','2019-04-15 21:02:42','','','','1234567890123','11234'),(26,11,22,0,'1','2019-04-15 21:14:22','','','','1234567890123','11234'),(32,32,14,0,'2','2019-04-15 22:00:22','2019-04-15 22:00:52','','','1234567890123','asd '),(33,32,14,0,'8','2019-04-15 22:00:28','','','','1234567890123','11234'),(34,11,22,0,'4','2019-04-15 22:28:14','2019-04-15 22:29:16','','','1234567890123','11234'),(35,33,125,0,'4','2019-04-15 22:36:36','','','','1234567890123','11234');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rejected`
--

DROP TABLE IF EXISTS `rejected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rejected` (
  `rejectedId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `rejectedStatus` varchar(135) DEFAULT NULL,
  `rejectedDTime` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`rejectedId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejected`
--

LOCK TABLES `rejected` WRITE;
/*!40000 ALTER TABLE `rejected` DISABLE KEYS */;
INSERT INTO `rejected` VALUES (1,20,1,'1','2019-04-15 15:09:59'),(2,22,1,'2','2019-04-15 17:13:20'),(3,20,1,'7','2019-04-15 17:14:30'),(4,33,0,'7','2019-04-15 22:00:31'),(5,33,0,'7','2019-04-15 22:01:40'),(6,34,0,'3','2019-04-15 22:29:44'),(7,35,0,'3','2019-04-15 22:36:38');
/*!40000 ALTER TABLE `rejected` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_cart` (
  `shoppingCartId` int(11) NOT NULL AUTO_INCREMENT,
  `commodityId` int(11) DEFAULT NULL,
  `userId` varchar(135) DEFAULT NULL,
  `commodityNumber` varchar(135) DEFAULT NULL,
  `registeredDTime` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`shoppingCartId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (2,15,'1','1','2019-04-15 17:16:05'),(3,11,'3','1','2019-04-15 21:04:52'),(4,10,'0','1','2019-04-15 21:08:48'),(5,11,'0','1','2019-04-15 21:10:09'),(6,11,'0','1','2019-04-15 21:14:25'),(7,11,'0','1','2019-04-15 21:15:59'),(8,11,'0','1','2019-04-15 21:22:59'),(9,11,'0','1','2019-04-15 22:28:03');
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(135) DEFAULT NULL,
  `userPassword` varchar(135) DEFAULT NULL,
  `userType` varchar(135) DEFAULT NULL,
  `userPhoneNumber` varchar(135) DEFAULT NULL,
  `userAddr1` varchar(135) DEFAULT NULL,
  `userAddr2` varchar(135) DEFAULT NULL,
  `userAddr3` varchar(135) DEFAULT NULL,
  `userAddr4` varchar(135) DEFAULT NULL,
  `userAddr5` varchar(135) DEFAULT NULL,
  `money` varchar(135) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','123456','1','3344','北京','河北','31','12','333','477.0'),(2,'shop','123456','4','','','','','','','0.0'),(3,'admin','123456','3','','','','','','','0.0'),(4,'user2','123456','2','233','河北','','','','','501.6'),(5,'user3','123','1','','','','','','','0.0'),(6,'123','123','2','1234567890123','11234','','','','','743.9999999999999'),(7,'110108199508029903','123456','1','13683363035','','','','','','0.0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-23 23:04:27
