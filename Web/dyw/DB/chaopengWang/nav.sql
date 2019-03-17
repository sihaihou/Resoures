
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `nav`;
CREATE TABLE `nav` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '栏目名称',
  `desc` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '备注',
  `status` int(1) NOT NULL COMMENT '状态',
  `gmtCreate` datetime NOT NULL,
  `gmtModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

