/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-08-27 10:02:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '18');
INSERT INTO `user` VALUES ('2', '程飞扬', '18');
INSERT INTO `user` VALUES ('3', '飞扬', '18');
INSERT INTO `user` VALUES ('4', '程飞扬', '18');
INSERT INTO `user` VALUES ('5', '徐风', '18');
INSERT INTO `user` VALUES ('6', '程飞扬', '18');
INSERT INTO `user` VALUES ('7', '程飞扬', '18');
