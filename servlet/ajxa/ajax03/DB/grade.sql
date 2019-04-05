/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : ajax

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-10-14 00:36:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gradeId` int(10) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '微机一班');
INSERT INTO `grade` VALUES ('2', '微机二班');
INSERT INTO `grade` VALUES ('3', '微机三班');
INSERT INTO `grade` VALUES ('4', '微机四班');

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `schoolId` int(11) NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`schoolId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '武工职');
INSERT INTO `school` VALUES ('2', '武生院');
INSERT INTO `school` VALUES ('3', '武工院');

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
