

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `integral` int(11) NOT NULL DEFAULT '0' COMMENT '会员积分，根据积分划分等级',
  `phone` varchar(16) NOT NULL COMMENT '登录账号',
  `name` varchar(32) NOT NULL COMMENT '账号呢称',
  `password` varchar(32) NOT NULL COMMENT '账号密码',
  `status` int(11) NOT NULL COMMENT '状态 0正常 1删除 2禁用',
  `gender` int(1) NOT NULL DEFAULT '1' COMMENT '性别',
  `birthday` date DEFAULT '2001-01-01',
  `email` varchar(32) DEFAULT NULL,
  `desc` varchar(32) DEFAULT NULL COMMENT '备注',
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

INSERT INTO `account` VALUES ('1', '99999', '18307200213', 'sihai.hou-reyco', '123456', '0', '1', '2014-01-24', '1548171008@qq.com', '超级管理员，拥有至高无上的权限！', '2018-09-07 04:08:20', '2018-11-27 14:42:23');
