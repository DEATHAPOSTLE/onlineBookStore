/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `commodity_base` (
	`commodityId` int (11),
	`commodityName` varchar (135),
	`commodityPicture` varchar (3072),
	`commodityType` varchar (135),
	`commodityPrice` double ,
	`commodityIntroduce` varchar (3072),
	`commoditySurplus` int (11),
	`commodityRate` varchar (135),
	`commodityShelves` varchar (6),
	`commodityPress` varchar (135),
	`commodityAuthor` varchar (135)
); 
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('8','java编程思想','333','科技','123','1','1','1','1','北京出版社','孙凯然');
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('9','c++编程思想',NULL,'科技','13',NULL,'1',NULL,NULL,'天津出版社','孙凯然');
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('10','军事杂谈',NULL,'军事','111',NULL,'1',NULL,NULL,'北京出版社','李聿恒');
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('11','坦克图鉴',NULL,'军事','22',NULL,'33',NULL,NULL,'河北出版社','王雨威');
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('15','表情包','QQ截图20190325142943.jpg','娱乐','123','QQ图片201902131632222245.jpg','27','','1','石景山出版社','qhr');
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('16','明朝那些事','QQ截图20190325142943.jpg','历史','69','QQ图片201902131632222245.jpg','14',NULL,'1','北京出版社','孙凯然');
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('17','三国志','QQ截图20190325142943.jpg','历史','35','QQ图片201902131632222245.jpg','23',NULL,'1','北京出版社','孙凯然');
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('18','史记','QQ截图20190325142943.jpg','历史','64','QQ图片201902131632222245.jpg','53',NULL,'1','北京出版社','孙凯然');
insert into `commodity_base` (`commodityId`, `commodityName`, `commodityPicture`, `commodityType`, `commodityPrice`, `commodityIntroduce`, `commoditySurplus`, `commodityRate`, `commodityShelves`, `commodityPress`, `commodityAuthor`) values('19','西游记','QQ截图20190325142943.jpg','历史','276','QQ图片201902131632222245.jpg','12',NULL,'1','北京出版社','孙凯然');
