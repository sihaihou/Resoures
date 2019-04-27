/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-08-28 09:12:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `minister`
-- ----------------------------
DROP TABLE IF EXISTS `minister`;
CREATE TABLE `minister` (
  `mid` int(10) NOT NULL AUTO_INCREMENT,
  `mname` varchar(40) DEFAULT NULL,
  `country_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of minister
-- ----------------------------
INSERT INTO `minister` VALUES ('1', 'aa', '1');
INSERT INTO `minister` VALUES ('2', 'bb', '1');
INSERT INTO `minister` VALUES ('3', 'cc', '2');
INSERT INTO `minister` VALUES ('4', 'dd', '2');
INSERT INTO `minister` VALUES ('5', 'ee', '1');
