/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-08-28 12:28:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `newslabel`
-- ----------------------------
DROP TABLE IF EXISTS `newslabel`;
CREATE TABLE `newslabel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `pid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newslabel
-- ----------------------------
INSERT INTO `newslabel` VALUES ('1', '娱乐新闻', '0');
INSERT INTO `newslabel` VALUES ('2', '体育新闻', '0');
INSERT INTO `newslabel` VALUES ('3', 'NBA', '2');
INSERT INTO `newslabel` VALUES ('4', 'CBA', '2');
INSERT INTO `newslabel` VALUES ('5', '火箭', '3');
INSERT INTO `newslabel` VALUES ('6', '湖人', '3');
INSERT INTO `newslabel` VALUES ('7', '北京鸟巢', '4');
INSERT INTO `newslabel` VALUES ('8', '浙江广厦', '4');
INSERT INTO `newslabel` VALUES ('9', '青岛双星', '4');
INSERT INTO `newslabel` VALUES ('10', '港台明星', '1');
INSERT INTO `newslabel` VALUES ('11', '内地影视', '1');
