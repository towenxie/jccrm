-- ----------------------------
-- Table structure for b2b_goods_stock
-- ----------------------------
DROP TABLE IF EXISTS `b2b_goods_stock`;
CREATE TABLE `b2b_goods_stock` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`batch_number` varchar(40) NULL DEFAULT NULL,
	`goods_number` varchar(40) NOT NULL,
	`stock_num` int(11) unsigned NOT NULL,
	`save_days` int(8) unsigned NULL DEFAULT NULL,
	`limit_days` int(8) unsigned NULL DEFAULT 7,
	`product_date` datetime DEFAULT NULL,
	`is_active` tinyint(1) NOT NULL DEFAULT '1',
	`create_date` datetime NOT NULL,
	`created_by` varchar(40) DEFAULT NULL,
	`last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
