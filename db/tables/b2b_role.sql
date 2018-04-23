CREATE TABLE `b2b_role` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `level` int(8) unsigned NOT NULL,
  `code` varchar(40) NOT NULL COMMENT '角色code',
  `parent_code` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='角色';
