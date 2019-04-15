/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `rejected` (
	`rejectedId` int (11),
	`orderId` int (11),
	`userId` int (11),
	`rejectedStatus` varchar (135),
	`rejectedDTime` varchar (135)
); 
insert into `rejected` (`rejectedId`, `orderId`, `userId`, `rejectedStatus`, `rejectedDTime`) values('1','20','1','1','2019-04-15 15:09:59');
insert into `rejected` (`rejectedId`, `orderId`, `userId`, `rejectedStatus`, `rejectedDTime`) values('2','22','1','2','2019-04-15 17:13:20');
insert into `rejected` (`rejectedId`, `orderId`, `userId`, `rejectedStatus`, `rejectedDTime`) values('3','20','1','7','2019-04-15 17:14:30');
