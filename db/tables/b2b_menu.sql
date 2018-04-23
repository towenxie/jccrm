SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `b2b_menu`
-- ----------------------------
DROP TABLE IF EXISTS `b2b_menu`;
CREATE TABLE `b2b_menu` (
	`id` int(8) unsigned NOT NULL AUTO_INCREMENT,
	`code` varchar(40) NOT NULL COMMENT 'code',
	`name` varchar(32) DEFAULT NULL COMMENT '名称',
	`action` varchar(128) DEFAULT NULL COMMENT '请求地址',
	`sort` int(4) DEFAULT NULL COMMENT '排序',
	`parent_code` varchar(64) DEFAULT NULL COMMENT '上级',
	`icon` varchar(128) DEFAULT NULL COMMENT '图标',
	`remark` varchar(128) DEFAULT NULL COMMENT '备注',
	`is_active` tinyint(1) NOT NULL DEFAULT '1',
	`create_date` datetime NOT NULL,
	`created_by` varchar(40) DEFAULT NULL,
	`last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`updated_by` varchar(40) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='菜单';

