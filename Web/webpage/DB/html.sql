/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : webpage

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-09-28 03:06:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `html`
-- ----------------------------
DROP TABLE IF EXISTS `html`;
CREATE TABLE `html` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of html
-- ----------------------------
INSERT INTO `html` VALUES ('1', 'html');
INSERT INTO `html` VALUES ('2', 'css');
INSERT INTO `html` VALUES ('3', 'javascript');
INSERT INTO `html` VALUES ('4', 'jQuery');
INSERT INTO `html` VALUES ('5', 'bootstrap');
INSERT INTO `html` VALUES ('6', 'example');
INSERT INTO `html` VALUES ('7', 'confession');
INSERT INTO `html` VALUES ('8', 'information');
