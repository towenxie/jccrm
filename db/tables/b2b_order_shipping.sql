
-- -----------------------------------------------------
-- Table `b2b_order_shipping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `b2b_order_shipping` ;

CREATE TABLE IF NOT EXISTS `b2b_order_shipping` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_number` varchar(40) NOT NULL,
  `username` VARCHAR(32) NULL,
  `phone` VARCHAR(20) NULL,
  `location_id` INT NULL,
  `address` VARCHAR(255) NULL,
  `full_address` VARCHAR(512) NULL,
  `note` VARCHAR(255) NULL,
  `express_number` VARCHAR(60) NULL,
  `express_company_code` VARCHAR(60) NULL,
  `order_payment_code` VARCHAR(64) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL,
  `created_by` varchar(40) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;