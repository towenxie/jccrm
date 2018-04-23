SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `b2b_order`
-- ----------------------------
DROP TABLE IF EXISTS `b2b_order`;
CREATE TABLE `b2b_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_number` varchar(40) NOT NULL,
  `order_status_code` VARCHAR(64) DEFAULT NULL,
  `dept_code` VARCHAR(64) DEFAULT NULL,
  `total_price` decimal(11,2) unsigned NOT NULL DEFAULT '0.00',
  `has_bill` tinyint(1) NOT NULL DEFAULT '0',
  `username` VARCHAR(32) NULL,
  `phone` VARCHAR(20) NULL,
  `location_id` INT NULL,
  `address` VARCHAR(255) NULL,
  `full_address` VARCHAR(512) NULL,
  `express_number` VARCHAR(60) NULL,
  `express_company_code` VARCHAR(60) NULL,
  `payment_code` VARCHAR(64) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `created_by` varchar(40) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;