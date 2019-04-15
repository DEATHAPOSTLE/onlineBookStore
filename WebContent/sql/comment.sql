/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `comment` (
	`commentId` int (11),
	`commodityId` int (11),
	`userID` int (11),
	`commentContent` varchar (600),
	`commentDTime` varchar (135)
); 
