-- ----------------------------
-- Table structure for b2b_goods_stock_log
-- ----------------------------
DROP TABLE IF EXISTS `b2b_goods_stock_log`;
CREATE TABLE `b2b_goods_stock_log` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`log_number` varchar(40) NULL DEFAULT NULL,
	`batch_number` varchar(40) NULL DEFAULT NULL,
	`goods_number` varchar(40) NOT NULL,
	`num` int(11) NOT NULL,
	`reason` varchar(1000) DEFAULT NULL COMMENT '原因',
	`stock_code` varchar(40) NOT NULL,
	`is_active` tinyint(1) NOT NULL DEFAULT '1',
	`create_date` datetime NOT NULL,
	`created_by` varchar(40) DEFAULT NULL,
	`last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
