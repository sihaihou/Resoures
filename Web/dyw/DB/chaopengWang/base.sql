
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `base`;
CREATE TABLE `base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


INSERT INTO `base` VALUES ('1', 'sihai.hou', '123456');
INSERT INTO `base` VALUES ('2', 'reyco', '123456');
