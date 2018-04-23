-- -----------------------------------------------------
-- Table `b2b_exception_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `b2b_exception_log` ;

CREATE TABLE IF NOT EXISTS `b2b_exception_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `level` ENUM('fatal','error','warn','info','debug') NOT NULL DEFAULT 'info',
  `thrower` VARCHAR(255) NOT NULL,
  `message` TEXT NOT NULL,
  `memo` TEXT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;