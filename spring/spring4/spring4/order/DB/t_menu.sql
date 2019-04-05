/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-08-26 14:33:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `price` double(40,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '盖饭', '10');
INSERT INTO `t_menu` VALUES ('2', '盖面', '12');
INSERT INTO `t_menu` VALUES ('3', '炒菜', '20');
INSERT INTO `t_menu` VALUES ('4', '拼盘', '15');
INSERT INTO `t_menu` VALUES ('5', '可乐', '3');
INSERT INTO `t_menu` VALUES ('6', '馒头', '1');
