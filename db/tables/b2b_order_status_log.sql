
-- -----------------------------------------------------
-- Table `b2b_order_status_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `b2b_order_status_log` ;

CREATE TABLE IF NOT EXISTS `b2b_order_status_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_number` varchar(40) NOT NULL,
  `order_status_code` VARCHAR(64) DEFAULT NULL,
  `remark` VARCHAR(255) NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;