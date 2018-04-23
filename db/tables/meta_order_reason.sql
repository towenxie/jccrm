
-- -----------------------------------------------------
-- Table `meta_order_reason`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meta_order_reason` ;

CREATE TABLE IF NOT EXISTS `meta_order_reason` (
  `id` int(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(64) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `remark` VARCHAR(255) NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;