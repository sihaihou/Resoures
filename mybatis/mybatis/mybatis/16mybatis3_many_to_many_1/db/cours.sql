/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-08-28 17:29:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cours`
-- ----------------------------
DROP TABLE IF EXISTS `cours`;
CREATE TABLE `cours` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cours
-- ----------------------------
INSERT INTO `cours` VALUES ('1', 'JavaSE');
INSERT INTO `cours` VALUES ('2', 'JavaEE');
INSERT INTO `cours` VALUES ('3', 'Android');
