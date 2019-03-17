/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : testDYW

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-12 21:14:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '类别名称',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT 'videoGroup数量(正常的数量)',
  `desc` varchar(32) DEFAULT NULL,
  `status` int(1) NOT NULL COMMENT '状态',
  `gmtCreate` datetime NOT NULL COMMENT '创建时间',
  `gmtModified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '电影', '2', '电影', '0', '2018-09-01 00:00:00', '2018-10-16 21:05:58');
INSERT INTO `category` VALUES ('2', '电视', '4', '电视', '0', '2018-09-01 00:00:00', '2018-10-14 16:40:17');
INSERT INTO `category` VALUES ('3', '恐怖', '0', '恐怖', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('4', '喜剧', '0', '喜剧', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('5', '悲剧', '0', '悲剧', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('6', '爱情', '0', '爱情', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('7', '江湖', '0', '江湖', '0', '2018-09-01 00:00:00', '2018-09-01 00:00:00');
INSERT INTO `category` VALUES ('8', '小视频', '7', '小视频', '0', '2018-09-28 03:15:06', '2018-11-11 17:17:08');
