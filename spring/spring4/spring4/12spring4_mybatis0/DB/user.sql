/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-02-14 22:51:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `pwd` varchar(40) DEFAULT NULL,
  `sex` varchar(40) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `birthday` varchar(40) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `emil` varchar(40) DEFAULT NULL,
  `goods_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '苏碧鑫', '123456', '女', '18', '1997-11-17', '湖北襄阳襄州区', '18307200213', '1648486790@qq.com', '0');
INSERT INTO `user` VALUES ('2', '侯四海', '123456', '男', '19', '1994-04-12', '湖北襄阳襄州区', '18307200213', '1548171008@qq.com', '0');
INSERT INTO `user` VALUES ('3', 'admin', '123456', '男', '19', '1994-04-12', '湖北襄阳', '18307200213', '1548171008@qq.com', '0');
INSERT INTO `user` VALUES ('4', 'hsh', '123456', '男', '18', '1994-04-12', '湖北襄阳襄州区', 'QQ:1548171008', '1548171008@qq.com', '0');
INSERT INTO `user` VALUES ('5', '马岩', '123456', '男', '19', '1998-02-25', '湖北省荆门市', '15872992953', ' 2045579742@qq.com', '0');
INSERT INTO `user` VALUES ('6', '何迪', '123456', '男', '23', '1994-02-15', '湖北省武汉市', '123456789', '123456789@qq.com', '0');
INSERT INTO `user` VALUES ('7', '邱峰', '123456', '男', '21', '1996-10-02', '湖北武汉', '18171231046', '2067455919@qq.com', '0');
