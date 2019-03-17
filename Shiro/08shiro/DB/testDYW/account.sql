/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : testDYW

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-12 21:14:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `vipId` int(1) NOT NULL COMMENT '类型： 0超级用户  1钻石会员  2黄金用户 3大众会员',
  `phone` varchar(11) NOT NULL COMMENT '登录账号 唯一',
  `name` varchar(16) NOT NULL COMMENT '账号呢称 唯一',
  `password` varchar(16) NOT NULL COMMENT '账号密码',
  `status` int(1) NOT NULL COMMENT '状态 0正常 1删除 2禁用',
  `gender` int(1) NOT NULL DEFAULT '1' COMMENT '性别：0女 1男  默认1',
  `birthday` date DEFAULT '2001-01-01',
  `email` varchar(32) DEFAULT NULL,
  `desc` varchar(32) DEFAULT NULL COMMENT '备注',
  `gmtOrder` datetime DEFAULT NULL COMMENT '服务开通时间',
  `gmtExpire` datetime DEFAULT NULL COMMENT '服务到期时间',
  `gmtCreate` datetime NOT NULL COMMENT '创建时间',
  `gmtModified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1', '18307200213', 'Reyco', '123456', '0', '1', '2014-01-24', '1548171008@qq.com', '顶级超级用户,仅此一个账号', null, null, '2018-09-07 04:08:20', '2018-10-05 06:14:08');
INSERT INTO `account` VALUES ('2', '2', '18307200210', '0210', '123456', '0', '1', '2001-01-01', null, '测试账号210', null, null, '2018-09-07 05:56:01', '2018-09-07 05:56:01');
INSERT INTO `account` VALUES ('3', '3', '18307200211', '0211', '123456', '0', '1', '2001-01-01', null, '测试账号211', null, null, '2018-09-10 02:50:59', '2018-09-10 02:50:59');
INSERT INTO `account` VALUES ('4', '4', '18307200212', '0212', '123456', '0', '1', '2002-02-02', '1548171008@qq.com', 'test', null, null, '2018-09-30 07:37:35', '2018-10-05 06:04:30');
INSERT INTO `account` VALUES ('5', '4', '18307200214', '0214', '123456', '0', '1', '2014-01-24', null, '0214', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('6', '4', '18307200215', '0215', '123456', '0', '1', '2014-01-24', null, '0215', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('7', '4', '18307200216', '0216', '123456', '0', '1', '2014-01-24', null, '0216', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('8', '4', '18307200217', '0217', '123456', '0', '1', '2014-01-24', null, '0217', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('9', '4', '18307200218', '0218', '123456', '0', '1', '2014-01-24', null, '0218', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('10', '4', '18307200219', '0219', '123456', '0', '1', '2014-01-24', null, '0219', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('11', '4', '18307200220', '0220', '123456', '0', '1', '2014-01-24', null, '0220', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('12', '4', '18307200221', '0221', '123456', '0', '1', '2014-01-24', null, '0221', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('13', '4', '18307200222', '0222', '123456', '0', '1', '2014-01-24', null, '0222', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('14', '4', '18307200223', '0223', '123456', '0', '1', '2014-01-24', null, '0223', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('15', '4', '18307200224', '0224', '123456', '0', '1', '2014-01-24', null, '0224', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('16', '4', '18307200225', '0225', '123456', '0', '1', '2014-01-24', null, '0225', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('17', '4', '18307200226', '0226', '123456', '0', '1', '2014-01-24', null, '0226', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('18', '4', '18307200227', '0227', '123456', '0', '1', '2014-01-24', null, '0227', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('19', '4', '18307200228', '0228', '123456', '0', '1', '2014-01-24', null, '0228', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('20', '4', '18307200229', '0229', '123456', '0', '1', '2014-01-24', null, '0229', null, null, '2018-11-05 17:14:50', '2018-11-05 17:14:50');
INSERT INTO `account` VALUES ('21', '4', '18307200230', '0230', '123456', '0', '1', '2014-01-24', null, '0230', null, null, '2018-11-05 17:28:09', '2018-11-05 17:28:09');
INSERT INTO `account` VALUES ('22', '4', '18307200231', '0231', '123456', '0', '1', '2014-01-24', null, '0231', null, null, '2018-11-05 17:28:17', '2018-11-05 17:28:17');
INSERT INTO `account` VALUES ('23', '4', '18307200232', '0232', '123456', '0', '1', '2014-01-24', null, '0232', null, null, '2018-11-05 17:28:21', '2018-11-05 17:28:21');
INSERT INTO `account` VALUES ('24', '4', '18307200233', '0233', '123456', '0', '1', '2014-01-24', null, '0233', null, null, '2018-11-05 17:28:25', '2018-11-05 17:28:25');
INSERT INTO `account` VALUES ('25', '4', '18307200234', '0234', '123456', '0', '1', '2014-01-24', null, '0234', null, null, '2018-11-05 17:28:32', '2018-11-05 17:28:32');
INSERT INTO `account` VALUES ('26', '4', '18307200235', '0235', '123456', '0', '1', '2014-01-24', null, '0235', null, null, '2018-11-05 17:28:37', '2018-11-05 17:28:37');
INSERT INTO `account` VALUES ('27', '4', '18307200236', '0236', '123456', '0', '1', '2014-01-24', null, '0236', null, null, '2018-11-05 17:28:43', '2018-11-05 17:28:43');
INSERT INTO `account` VALUES ('28', '4', '18307200237', '0237', '123456', '0', '1', '2014-01-24', null, '0237', null, null, '2018-11-05 17:28:53', '2018-11-05 17:28:53');
INSERT INTO `account` VALUES ('29', '4', '18307200238', '0238', '123456', '0', '1', '2014-01-24', null, '0238', null, null, '2018-11-05 17:29:02', '2018-11-05 17:29:02');
INSERT INTO `account` VALUES ('30', '4', '18307200239', '0239', '123456', '0', '1', '2014-01-24', null, '0239', null, null, '2018-11-05 17:29:08', '2018-11-05 17:29:08');
INSERT INTO `account` VALUES ('31', '4', '18307200240', '0240', '123456', '0', '1', '2014-01-24', null, '0240', null, null, '2018-11-05 17:29:21', '2018-11-05 17:29:21');
INSERT INTO `account` VALUES ('32', '4', '18307200241', '0241', '123456', '0', '1', '2014-01-24', null, '0241', null, null, '2018-11-05 17:29:27', '2018-11-05 17:29:27');
INSERT INTO `account` VALUES ('33', '4', '18307200242', '0242', '123456', '0', '1', '2014-01-24', null, '0242', null, null, '2018-11-05 17:29:32', '2018-11-05 17:29:32');
INSERT INTO `account` VALUES ('34', '4', '18307200243', '0243', '123456', '0', '1', '2014-01-24', null, '0243', null, null, '2018-11-05 17:29:38', '2018-11-05 17:29:38');
