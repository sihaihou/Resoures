SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;
