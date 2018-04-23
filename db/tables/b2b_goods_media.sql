-- -----------------------------------------------------
-- Table `b2b_goods_media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `b2b_goods_media` ;

CREATE TABLE IF NOT EXISTS `b2b_goods_media` (
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`goods_number` varchar(40) NOT NULL,
	`media_path` VARCHAR(255) NULL,
	`is_active` tinyint(1) NOT NULL DEFAULT '1',
	`create_date` datetime NOT NULL,
	`created_by` varchar(40) DEFAULT NULL,
	`last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
