SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '名称',
  `lowVip` int(11) NOT NULL DEFAULT '0' COMMENT '等级最低值',
  `higVip` int(11) NOT NULL DEFAULT '0' COMMENT '等级最高值',
  `status` int(1) NOT NULL COMMENT '状态',
  `desc` varchar(32) NOT NULL COMMENT '备注',
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1', '超级用户', '50000', '99999', '0', '最高权限用户，系统仅此一个此类账号。', '2018-09-30 01:16:03', '2018-11-27 18:53:01');
INSERT INTO `vip` VALUES ('2', '钻石会员', '18000', '49999', '0', '点击修改备注', '2018-11-27 18:34:16', '2018-11-27 18:52:53');
INSERT INTO `vip` VALUES ('3', '铂金会员', '6000', '17999', '0', '等级最高。', '2018-09-28 10:06:37', '2018-11-27 18:52:47');
INSERT INTO `vip` VALUES ('4', '黄金会员', '2000', '5999', '0', '等级比大众会员高,比钻石会员低', '2018-09-28 10:07:11', '2018-11-27 18:52:38');
INSERT INTO `vip` VALUES ('5', '大众会员', '0', '1999', '0', '最低等级,创建用户时的等级。', '2018-09-28 10:07:30', '2018-11-27 18:52:27');
