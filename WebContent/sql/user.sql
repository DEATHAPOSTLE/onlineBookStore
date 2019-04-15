/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`userId` int (11),
	`userName` varchar (135),
	`userPassword` varchar (135),
	`userType` varchar (135),
	`userPhoneNumber` varchar (135),
	`userAddr1` varchar (135),
	`userAddr2` varchar (135),
	`userAddr3` varchar (135),
	`userAddr4` varchar (135),
	`userAddr5` varchar (135),
	`money` varchar (135)
); 
insert into `user` (`userId`, `userName`, `userPassword`, `userType`, `userPhoneNumber`, `userAddr1`, `userAddr2`, `userAddr3`, `userAddr4`, `userAddr5`, `money`) values('1','user','123456','1','3344','北京','河北','31','12','333','477.0');
insert into `user` (`userId`, `userName`, `userPassword`, `userType`, `userPhoneNumber`, `userAddr1`, `userAddr2`, `userAddr3`, `userAddr4`, `userAddr5`, `money`) values('2','shop','123456','4','','','','','','','0.0');
insert into `user` (`userId`, `userName`, `userPassword`, `userType`, `userPhoneNumber`, `userAddr1`, `userAddr2`, `userAddr3`, `userAddr4`, `userAddr5`, `money`) values('3','admin','123456','3','','','','','','','0.0');
insert into `user` (`userId`, `userName`, `userPassword`, `userType`, `userPhoneNumber`, `userAddr1`, `userAddr2`, `userAddr3`, `userAddr4`, `userAddr5`, `money`) values('4','user2','123456','2','233','河北','','','','','501.6');
insert into `user` (`userId`, `userName`, `userPassword`, `userType`, `userPhoneNumber`, `userAddr1`, `userAddr2`, `userAddr3`, `userAddr4`, `userAddr5`, `money`) values('5','user3','123','1','','','','','','','0.0');
