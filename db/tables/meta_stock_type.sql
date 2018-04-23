
-- -----------------------------------------------------
-- Table `meta_stock_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meta_stock_type` ;

CREATE TABLE IF NOT EXISTS `meta_stock_type` (
  `id` int(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sort` int(8) UNSIGNED NOT NULL,
  `code` VARCHAR(64) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `remark` VARCHAR(255) NULL,
  `is_positive` tinyint(1) NOT NULL DEFAULT '1',
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;