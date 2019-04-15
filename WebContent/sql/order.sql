/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `orders` (
	`orderId` int (11),
	`commodityID` int (11),
	`orderPrice` double ,
	`userId` int (11),
	`orderStatus` varchar (135),
	`orderDTime` varchar (135),
	`deliveryDTime` varchar (135),
	`receiveDTime` varchar (135),
	`orderRate` varchar (135),
	`phoneNumber` varchar (135),
	`orderAddr` varchar (600)
); 
insert into `orders` (`orderId`, `commodityID`, `orderPrice`, `userId`, `orderStatus`, `orderDTime`, `deliveryDTime`, `receiveDTime`, `orderRate`, `phoneNumber`, `orderAddr`) values('20','8','123','1','8','2019-04-11 16:39:10','2019-04-11 16:39:10','2019-04-11 16:39:10','3','123','as');
insert into `orders` (`orderId`, `commodityID`, `orderPrice`, `userId`, `orderStatus`, `orderDTime`, `deliveryDTime`, `receiveDTime`, `orderRate`, `phoneNumber`, `orderAddr`) values('21','15','246','1','3','2019-04-15 16:34:31','2019-04-15 16:51:01','2019-04-15 17:13:15','','3344','北京');
insert into `orders` (`orderId`, `commodityID`, `orderPrice`, `userId`, `orderStatus`, `orderDTime`, `deliveryDTime`, `receiveDTime`, `orderRate`, `phoneNumber`, `orderAddr`) values('22','15','246','1','7','2019-04-15 16:47:48','2019-04-15 16:51:04','','','3344','北京');
insert into `orders` (`orderId`, `commodityID`, `orderPrice`, `userId`, `orderStatus`, `orderDTime`, `deliveryDTime`, `receiveDTime`, `orderRate`, `phoneNumber`, `orderAddr`) values('23','15','123','1','1','2019-04-15 17:47:42','','','','3344','北京');
insert into `orders` (`orderId`, `commodityID`, `orderPrice`, `userId`, `orderStatus`, `orderDTime`, `deliveryDTime`, `receiveDTime`, `orderRate`, `phoneNumber`, `orderAddr`) values('24','15','123','4','1','2019-04-15 17:50:21','','','','233','河北');
