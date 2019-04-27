/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : testChaopengwang

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-12 21:02:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '类别名称',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '类别  有多少个视频',
  `desc` varchar(32) DEFAULT NULL,
  `status` int(1) NOT NULL COMMENT '状态',
  `gmtCreate` datetime NOT NULL COMMENT '创建时间',
  `gmtModified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '偷拍', '2', '偷拍', '0', '2018-09-01 00:00:00', '2018-11-03 21:25:22');
INSERT INTO `category` VALUES ('2', '日韩', '0', '日韩', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('3', '高清', '0', '高清', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('4', '无码', '0', '无码', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('5', '欧美', '0', '欧美', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('6', '动漫', '0', '动漫', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('7', '国语', '0', '国语', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('8', 'nginx视频', '0', 'nginx学习', '0', '2018-09-27 23:03:17', '2018-10-02 21:58:23');
