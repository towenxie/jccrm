
-- -----------------------------------------------------
-- Table `b2b_order_goods_batch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `b2b_order_goods_batch` ;

CREATE TABLE IF NOT EXISTS `b2b_order_goods_batch` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_number` varchar(40) NOT NULL,
  `goods_batch_number` varchar(40) NOT NULL,
  `goods_number` varchar(40) NOT NULL,
  `qty` INT UNSIGNED NOT NULL DEFAULT 1,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL,
  `created_by` varchar(40) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
