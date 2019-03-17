/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : testChaopengwang

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-12 21:02:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL COMMENT '类别',
  `vipId` int(11) NOT NULL,
  `accountId` int(11) NOT NULL DEFAULT '1' COMMENT '用户Id  是由谁上传的',
  `name` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '名称',
  `recordPath` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '地址',
  `hitQuantity` int(11) NOT NULL COMMENT '访问量',
  `status` int(1) NOT NULL,
  `desc` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `gmtCreate` datetime NOT NULL COMMENT '创建时间',
  `gmtModified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '7', '4', '1', '大男当婚——1', '7/1538252077966.mp4', '500', '0', '测试', '2018-09-30 04:14:38', '2018-09-30 04:14:38');
INSERT INTO `video` VALUES ('2', '7', '4', '1', '大男当婚——2', '7/1538252094294.mp4', '500', '1', '测试2', '2018-09-30 04:14:54', '2018-09-30 04:17:08');
INSERT INTO `video` VALUES ('3', '7', '4', '1', '大男当婚——3', '7/1538252105525.mp4', '500', '0', '测试', '2018-09-30 04:15:05', '2018-09-30 04:15:05');
INSERT INTO `video` VALUES ('4', '7', '4', '2', '大男当婚——1', '7/1538258065339.mp4', '500', '0', '1', '2018-09-30 05:54:25', '2018-09-30 05:54:25');
INSERT INTO `video` VALUES ('5', '7', '4', '2', '大男当婚——2', '7/1538258075956.mp4', '500', '0', '2', '2018-09-30 05:54:36', '2018-09-30 05:54:36');
INSERT INTO `video` VALUES ('6', '1', '4', '1', 'cs1', '1/1541251520233.MP4', '500', '0', '11', '2018-11-03 21:25:21', '2018-11-06 21:15:27');
