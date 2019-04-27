/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : testChaopengwang

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-12 21:02:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `vip`
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '名称',
  `desc` varchar(32) NOT NULL COMMENT '备注',
  `statusId` int(11) NOT NULL COMMENT '状态Id',
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1', '超级用户', '最高权限用户', '1', '2018-09-30 01:16:03', '2018-09-30 01:16:05');
INSERT INTO `vip` VALUES ('2', '钻石会员', '等级比较高', '1', '2018-09-28 10:06:37', '2018-09-28 10:06:39');
INSERT INTO `vip` VALUES ('3', '黄金会员', '等级比大众会员高,比钻石会员低', '1', '2018-09-28 10:07:11', '2018-09-28 10:07:14');
INSERT INTO `vip` VALUES ('4', '大众会员', '最低等级', '1', '2018-09-28 10:07:30', '2018-09-28 10:07:33');
