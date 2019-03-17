

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '类别名称',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '类别  有多少个视频',
  `desc` varchar(32) DEFAULT NULL,
  `status` int(1) NOT NULL COMMENT '状态',
  `gmtCreate` datetime NOT NULL COMMENT '创建时间',
  `gmtModified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


