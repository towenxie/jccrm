
-- -----------------------------------------------------
-- Table `b2b_order_price`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `b2b_order_price` ;

CREATE TABLE IF NOT EXISTS `b2b_order_price` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_number` varchar(40) NOT NULL,
  `username` VARCHAR(32) NULL,
  `org_total_price` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 0.01,
  `total_price` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 0.01,
  `send_price` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 0.01,
  `replace_profit` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 1.00,
  `real_price` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 1.00,
  `refund_price` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 1.00,
  `reason_code` varchar(1000) DEFAULT NULL COMMENT '欠款原因',
  `refund_detail` varchar(1000) DEFAULT NULL COMMENT '欠款原因',
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL,
  `created_by` varchar(40) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
