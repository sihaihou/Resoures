/*
Navicat MySQL Data Transfer

Source Server         : 39.107.247.102
Source Server Version : 50723
Source Host           : 39.107.247.102:3306
Source Database       : DYW

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-12 21:11:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `systemInfo`
-- ----------------------------
DROP TABLE IF EXISTS `systemInfo`;
CREATE TABLE `systemInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `infoKey` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT 'key',
  `infoValue` varchar(256) CHARACTER SET utf8 NOT NULL COMMENT 'value',
  `status` int(1) NOT NULL COMMENT '状态',
  `desc` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '备注',
  `gmtCreate` datetime NOT NULL COMMENT '创建时间',
  `gmtModified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of systemInfo
-- ----------------------------
INSERT INTO `systemInfo` VALUES ('1', 'qq_hao', '1848851810', '0', 'QQ号', '2018-08-25 20:40:49', '2018-08-28 23:46:29');
INSERT INTO `systemInfo` VALUES ('2', 'qq_qun', '537408093', '0', 'QQ群', '2018-08-25 20:42:47', '2018-08-25 20:42:49');
INSERT INTO `systemInfo` VALUES ('3', 'email', '1548171008@qq.com', '0', '邮箱', '2018-08-25 20:44:34', '2018-08-25 20:44:36');
INSERT INTO `systemInfo` VALUES ('4', 'phone', '18307200213', '0', '电话', '2018-08-25 20:45:03', '2018-08-25 20:45:06');
INSERT INTO `systemInfo` VALUES ('5', 'weixin', '18307200213', '0', '微信号', '2018-08-25 20:45:52', '2018-08-25 20:45:56');
INSERT INTO `systemInfo` VALUES ('6', 'www_address', 'http://www.sihaihou.com', '0', '最新网址', '2018-08-25 20:48:58', '2018-08-25 20:49:02');
INSERT INTO `systemInfo` VALUES ('7', 'www_name', 'cpw亚洲超碰福利视频网', '0', '网站名称', '2018-08-25 20:50:09', '2018-08-25 20:50:12');
INSERT INTO `systemInfo` VALUES ('8', 'friendly_link', 'http://www.uv111.com', '0', '友情链接地址', '2018-08-25 20:54:05', '2018-08-25 20:54:07');
INSERT INTO `systemInfo` VALUES ('9', 'disclaimer', '本网站所有内容都是靠程序在互联网上自动搜集而来，仅供测试和学习交流', '0', '免责声明', '2018-08-25 20:57:01', '2018-08-25 20:57:04');
INSERT INTO `systemInfo` VALUES ('10', 'welcome', 'cpw欢迎来到亚洲超碰福利视频网', '0', '欢迎术语', '2018-08-25 23:17:02', '2018-08-25 23:17:16');
INSERT INTO `systemInfo` VALUES ('11', 'commercials', 'https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=%E5%B9%BF%E5%91%8A%E5%90%88%E4%BD%9CQQ%3A1548171008&', '0', '广告合作联系', '2018-09-16 23:20:13', '2018-09-16 23:20:15');
INSERT INTO `systemInfo` VALUES ('12', 'qq_proup_href', '//shang.qq.com/wpa/qunwpa?idkey=acf6594a7470265291009bc305d09145b81afff9a0b73da132d1a95fd9bdce94', '0', '加QQ群href', '2018-09-16 23:26:12', '2018-09-16 23:26:15');
INSERT INTO `systemInfo` VALUES ('13', 'qq_group_img', '//pub.idqqimg.com/wpa/images/group.png', '0', '加QQ群img', '2018-09-16 23:26:59', '2018-09-16 23:27:03');
INSERT INTO `systemInfo` VALUES ('14', 'add_qq', 'tencent://AddContact/?fromId=50&fromSubId=1&subcmd=all&uin=1548171008', '0', '添加QQ', '2018-09-16 23:28:19', '2018-09-16 23:28:22');
INSERT INTO `systemInfo` VALUES ('15', 'stationmaster', 'http://wpa.qq.com/msgrd?v=3&amp;uin=1548171008&amp;site=qq&amp;menu=yes', '0', '联系站长', '2018-09-16 23:29:43', '2018-09-16 23:29:46');
