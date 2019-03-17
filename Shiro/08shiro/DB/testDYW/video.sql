/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : testDYW

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-12 21:14:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL COMMENT '类别',
  `vipId` int(11) NOT NULL DEFAULT '4' COMMENT '视频权限',
  `accountId` int(11) NOT NULL DEFAULT '1' COMMENT '用户Id  是由谁上传的',
  `name` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '名称',
  `recordPath` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '地址',
  `hitQuantity` int(11) NOT NULL COMMENT '访问量',
  `status` int(1) NOT NULL,
  `desc` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `gmtCreate` datetime NOT NULL COMMENT '创建时间',
  `gmtModified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '2', '4', '1', '大男当婚_1', '8/1538075758288.mp4', '500', '0', 'test', '2018-09-28 03:15:57', '2018-10-06 00:07:13');
INSERT INTO `video` VALUES ('2', '8', '4', '3', '大男当婚_2', '8/1538753305452.mp4', '500', '0', 'test', '2018-10-05 23:28:25', '2018-10-05 23:28:25');
INSERT INTO `video` VALUES ('3', '8', '1', '3', '大男当婚_test', '8/1538753654125.mp4', '500', '0', 'test', '2018-10-05 23:34:14', '2018-10-05 23:34:14');
INSERT INTO `video` VALUES ('4', '8', '4', '2', '大男当婚_3', '8/1538754133121.mp4', '500', '0', 'test', '2018-10-05 23:42:13', '2018-10-05 23:42:13');
INSERT INTO `video` VALUES ('5', '2', '2', '1', '大男当婚_4', '8/1538754281103.mp4', '500', '0', 'test', '2018-10-05 23:44:41', '2018-10-05 23:44:41');
INSERT INTO `video` VALUES ('6', '8', '4', '1', '行运一条龙(周星驰初恋)', '8/1539506052464.mp4', '500', '0', '备注', '2018-10-14 16:34:11', '2018-11-06 21:46:32');
INSERT INTO `video` VALUES ('7', '8', '4', '1', '行运一条龙(周星驰初恋)', '8/1539506182349.mp4', '500', '0', '备注', '2018-10-14 16:36:21', '2018-11-06 21:46:26');
INSERT INTO `video` VALUES ('8', '2', '4', '1', '风云之倾尽天下mv', '2/1539506417835.mp4', '500', '0', '备注', '2018-10-14 16:40:16', '2018-11-06 21:46:19');
INSERT INTO `video` VALUES ('9', '1', '4', '1', '行运一条龙(周星驰初恋)', '1/1539695157614.mp4', '500', '0', 'test', '2018-10-16 21:05:56', '2018-10-16 21:05:56');
INSERT INTO `video` VALUES ('10', '8', '4', '1', '大男当婚——1', '8/1541927826758.mp4', '500', '0', '点击修改备注', '2018-11-11 17:17:07', '2018-11-11 17:17:07');
