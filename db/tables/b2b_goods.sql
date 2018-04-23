
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b2b_goods
-- ----------------------------
DROP TABLE IF EXISTS `b2b_goods`;
CREATE TABLE `b2b_goods` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`goods_number` varchar(40) NULL DEFAULT NULL,
	`name` varchar(128) NOT NULL,
	`price` decimal(11,2) NOT NULL DEFAULT '0.01',
	`unit` varchar(8) NOT NULL,
	`location` varchar(32) NULL DEFAULT  NULL,
	`remark` varchar(128) DEFAULT NULL COMMENT '备注',
	`is_active` tinyint(1) NOT NULL DEFAULT '1',
	`create_date` datetime NOT NULL,
	`created_by` varchar(40) DEFAULT NULL,
	`last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
