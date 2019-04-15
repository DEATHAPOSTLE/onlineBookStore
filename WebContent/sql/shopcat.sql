/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `shopping_cart` (
	`shoppingCartId` int (11),
	`commodityId` int (11),
	`userId` varchar (135),
	`commodityNumber` varchar (135),
	`registeredDTime` varchar (135)
); 
insert into `shopping_cart` (`shoppingCartId`, `commodityId`, `userId`, `commodityNumber`, `registeredDTime`) values('2','15','1','1','2019-04-15 17:16:05');
