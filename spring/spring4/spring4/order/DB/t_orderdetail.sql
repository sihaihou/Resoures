/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-08-26 14:33:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `t_orderdetail`;
CREATE TABLE `t_orderdetail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `orderId` int(10) DEFAULT NULL,
  `menuId` int(10) DEFAULT NULL,
  `num` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderdetail
-- ----------------------------
INSERT INTO `t_orderdetail` VALUES ('1', '1', '3', '1');
INSERT INTO `t_orderdetail` VALUES ('2', '1', '5', '1');
INSERT INTO `t_orderdetail` VALUES ('3', '2', '1', '1');
INSERT INTO `t_orderdetail` VALUES ('4', '2', '3', '1');
INSERT INTO `t_orderdetail` VALUES ('5', '3', '4', '1');
INSERT INTO `t_orderdetail` VALUES ('6', '3', '3', '1');
