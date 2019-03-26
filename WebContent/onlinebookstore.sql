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
  `commentId` int(11) NOT NULL COMMENT '评论ID(主键自增长)',
  `commodityId` int(11) DEFAULT NULL COMMENT '商品ID',
  `userID` int(11) DEFAULT NULL COMMENT '用户ID',
  `commentContent` varchar(200) DEFAULT NULL COMMENT '评论文字内容',
  `commentDTime` varchar(45) DEFAULT NULL COMMENT '评论时间',
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
  `commodityId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID(主键自增长)',
  `commodityName` varchar(45) DEFAULT NULL COMMENT '商品名称',
  `commodityPicture` varchar(1024) DEFAULT NULL COMMENT '商品图片',
  `commodityType` varchar(45) DEFAULT NULL COMMENT '商品类型',
  `commodityPrice` double DEFAULT NULL COMMENT '商品价格',
  `commodityIntroduce` varchar(1024) DEFAULT NULL COMMENT '商品介绍',
  `commoditySurplus` int(11) DEFAULT NULL COMMENT '商品剩余数量',
  `commodityRate` varchar(45) DEFAULT NULL COMMENT '商品评分',
  `commodityShelves` varchar(2) DEFAULT NULL COMMENT '商品上下架标记',
  PRIMARY KEY (`commodityId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_base`
--

LOCK TABLES `commodity_base` WRITE;
/*!40000 ALTER TABLE `commodity_base` DISABLE KEYS */;
/*!40000 ALTER TABLE `commodity_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID(主键自增长)',
  `commodityID` int(11) DEFAULT NULL COMMENT '商品ID',
  `orderPrice` double DEFAULT NULL COMMENT '商品价格',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `orderStatus` varchar(45) DEFAULT NULL COMMENT '订单状态',
  `orderDTime` varchar(45) DEFAULT NULL COMMENT '下单时间',
  `deliveryDTime` varchar(45) DEFAULT NULL COMMENT '发货时间',
  `receiveDTime` varchar(45) DEFAULT NULL COMMENT '收货时间',
  `orderRate` varchar(45) DEFAULT NULL COMMENT '订单评分',
  `phoneNumber` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `orderAddr` varchar(200) DEFAULT NULL COMMENT '送货地址',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rejected`
--

DROP TABLE IF EXISTS `rejected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rejected` (
  `rejectedId` int(11) NOT NULL AUTO_INCREMENT COMMENT '退货单号',
  `orderId` int(11) DEFAULT NULL COMMENT '订单编号',
  `userId` int(11) DEFAULT NULL COMMENT '用户编号',
  `rejectedStatus` varchar(45) DEFAULT NULL COMMENT '退货状态',
  `rejectedDTime` varchar(45) DEFAULT NULL COMMENT '退货时间',
  PRIMARY KEY (`rejectedId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejected`
--

LOCK TABLES `rejected` WRITE;
/*!40000 ALTER TABLE `rejected` DISABLE KEYS */;
/*!40000 ALTER TABLE `rejected` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_cart` (
  `shoppingCartId` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车ID(主键自增长)',
  `commodityId` int(11) DEFAULT NULL COMMENT '商品ID',
  `userId` varchar(45) DEFAULT NULL COMMENT '用户ID',
  `commodityNumber` varchar(45) DEFAULT NULL COMMENT '商品数量',
  `registeredDTime` varchar(45) DEFAULT NULL COMMENT '加入购物车时间',
  PRIMARY KEY (`shoppingCartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID(主键自增长)',
  `userPassword` varchar(45) DEFAULT NULL COMMENT '用户密码',
  `userType` varchar(45) DEFAULT NULL COMMENT '用户权限（管理员/普通/会员）',
  `userPhoneNumber` varchar(45) DEFAULT NULL COMMENT '用户电话',
  `userAddr1` varchar(45) DEFAULT NULL COMMENT '用户地址1',
  `userAddr2` varchar(45) DEFAULT NULL COMMENT '用户地址2',
  `userAddr3` varchar(45) DEFAULT NULL COMMENT '用户地址3',
  `userAddr4` varchar(45) DEFAULT NULL COMMENT '用户地址4',
  `userAddr5` varchar(45) DEFAULT NULL COMMENT '用户地址5',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2019-03-25 21:54:51
