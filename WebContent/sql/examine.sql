/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `commodity_base_examine` (
	`examineId` int (11),
	`commodityName` varchar (135),
	`commodityPicture` varchar (3072),
	`commodityType` varchar (135),
	`commodityPrice` double ,
	`commodityIntroduce` varchar (3072),
	`commodityExamine` varchar (135),
	`commodityPress` varchar (135),
	`commodityAuthor` varchar (135)
); 
insert into `commodity_base_examine` (`examineId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commodityExamine`, `commodityPress`, `commodityAuthor`) values('8','天上人间','timg12.jpg','黄色','1222','微信图片_20190401152233627.jpg','3','八大胡同出版社','朴一生');
insert into `commodity_base_examine` (`examineId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commodityExamine`, `commodityPress`, `commodityAuthor`) values('9','金瓶梅','QQ图片20190213163045xiaochou233.jpg','古典小说','123','QQ图片20190218142350.png','3','无','无');
insert into `commodity_base_examine` (`examineId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commodityExamine`, `commodityPress`, `commodityAuthor`) values('11','表情包','QQ截图20190325142943.jpg','娱乐·','123','QQ图片201902131632222245.jpg','1','石景山出版社','qhr');
