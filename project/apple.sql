/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : apple

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-08-10 13:37:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apple
-- ----------------------------
DROP TABLE IF EXISTS `apple`;
CREATE TABLE `apple` (
  `name` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `colour` varchar(255) DEFAULT NULL,
  `weight` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of apple
-- ----------------------------
INSERT INTO `apple` VALUES ('tom', '1', 'red', '12');
INSERT INTO `apple` VALUES ('sam', '2', 'red', '12');
INSERT INTO `apple` VALUES ('sam', '3', 'red', '12');
INSERT INTO `apple` VALUES ('tom', '5', 'red', '12');
