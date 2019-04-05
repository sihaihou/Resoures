/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : ajax

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-10-14 00:36:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` int(10) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(40) DEFAULT NULL,
  `studentAge` int(10) DEFAULT NULL,
  `studentPhone` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '18', '1851154154');
INSERT INTO `student` VALUES ('2', '李四', '19', '1545156155');
INSERT INTO `student` VALUES ('3', '王五', '20', '1546525453');
