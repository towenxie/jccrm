
-- -----------------------------------------------------
-- Table `b2b_order_goods`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `b2b_order_goods` ;

CREATE TABLE IF NOT EXISTS `b2b_order_goods` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_number` varchar(40) NOT NULL,
  `goods_number` varchar(40) NOT NULL,
  `pre_price` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 0.01,
  `profit` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 1.00,
  `qty` INT UNSIGNED NOT NULL DEFAULT 1,
  `total_price` DECIMAL(11,2) UNSIGNED NOT NULL DEFAULT 0.01,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL,
  `created_by` varchar(40) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
