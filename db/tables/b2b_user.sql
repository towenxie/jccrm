/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : jccrm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-08-14 23:30:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `b2b_user`
-- ----------------------------
DROP TABLE IF EXISTS `b2b_user`;
CREATE TABLE `b2b_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sort_work_id` int(8) UNSIGNED NOT NULL,
  `WORK_ID` varchar(40) NOT NULL COMMENT '工号',
  `PARENT_WORK_ID` varchar(40) DEFAULT NULL COMMENT '上级工号',
  `USERNAME` varchar(40) DEFAULT NULL COMMENT '姓名',
  `PASSWORD` varchar(40) DEFAULT NULL COMMENT '密码',
  `SEX` varchar(40) DEFAULT NULL COMMENT '性别',
  `phone` varchar(40) DEFAULT NULL COMMENT '电话',
  `EMAIL` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `dept_code` varchar(40) DEFAULT NULL COMMENT '职务',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL,
  `created_by` varchar(40) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2b_user
-- ----------------------------
