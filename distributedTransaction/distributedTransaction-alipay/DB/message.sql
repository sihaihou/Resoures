DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `price` int(11) NOT NULL DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '1',
   PRIMARY KEY (`id`),
   CONSTRAINT `fk_accountId_id` FOREIGN KEY (`accountId`) REFERENCES `account` (`id`)   
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;