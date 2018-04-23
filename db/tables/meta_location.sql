
CREATE TABLE IF NOT EXISTS `meta_location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `country_name` varchar(50) NOT NULL,
  `state_name` varchar(50) DEFAULT NULL,
  `city_name` varchar(50) DEFAULT NULL,
  `region_name` varchar(50) NOT NULL,
  `whole_name` varchar(50) NOT NULL,
  `level` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_code` varchar(50) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT '1',
  `long` double DEFAULT 10000,
  `lat` double DEFAULT 10000,
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6906 DEFAULT CHARSET=utf8;
