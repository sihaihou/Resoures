/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : testDYW

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-12 21:14:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `status`
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '状态名称',
  `desc` varchar(32) NOT NULL COMMENT '备注',
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', '正常', '状态正常/已通过审核 ', '2018-09-28 09:58:45', '2018-09-28 09:58:47');
INSERT INTO `status` VALUES ('2', '删除', '状态删除', '2018-09-28 09:59:20', '2018-09-28 09:59:22');
INSERT INTO `status` VALUES ('3', '禁用', '状态禁用', '2018-09-28 10:00:12', '2018-09-28 10:00:15');
INSERT INTO `status` VALUES ('4', '审核中', '状态审核中', '2018-09-28 10:00:51', '2018-09-28 10:00:55');
INSERT INTO `status` VALUES ('5', '未通过', '审核未通过', '2018-09-28 10:01:40', '2018-09-28 10:01:43');
