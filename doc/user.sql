/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50509
Source Host           : localhost:3306
Source Database       : web-public

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2018-11-04 10:56:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `register_date` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `sex` int(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `cre_time` datetime DEFAULT NULL,
  `cre_user` varchar(255) DEFAULT NULL,
  `mod_time` datetime DEFAULT NULL,
  `mod_user` varchar(255) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
