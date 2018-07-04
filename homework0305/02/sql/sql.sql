/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-03-15 09:41:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `flag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', 'baiyuting', '1.20', '4');
INSERT INTO `commodity` VALUES ('2', 'bai2', '12.00', '0');
INSERT INTO `commodity` VALUES ('3', 'bai3', '2.00', '0');
INSERT INTO `commodity` VALUES ('4', 'bai4', '2.00', '0');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `audit_status` int(255) DEFAULT '0' COMMENT '审核状态有两种：审核状态 = 0：未审核；审核状态 = 1：已审核，可以浏览。',
  `audit_date` datetime DEFAULT NULL,
  `audit_user_id` int(11) DEFAULT '-1' COMMENT '默认没有审核人',
  `audit_fail_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', 'hello', '2018-02-28 00:00:00', 'hello', 'content', '1', null, '-1', null);
INSERT INTO `news` VALUES ('2', 'hello2', '2018-02-28 00:00:00', 'hello2', 'content2', '1', null, '-1', null);
INSERT INTO `news` VALUES ('3', 'hello3', '2018-02-28 00:00:00', 'hello3', 'content3', '1', '2018-03-01 14:53:29', '-1', null);
INSERT INTO `news` VALUES ('4', 'hello4', '2018-02-28 00:00:00', 'hello4', 'content4', '1', '2018-03-01 14:53:32', '-1', null);
INSERT INTO `news` VALUES ('5', 'hello5', '2018-02-28 00:00:00', 'hello5', 'content5', '0', null, '-1', null);
INSERT INTO `news` VALUES ('6', 'hello6', '2018-03-01 00:00:00', 'hello6', 'content6', '0', null, '-1', null);
INSERT INTO `news` VALUES ('7', 'hello7', '2018-03-01 00:00:00', 'hello7', 'content7', '0', null, '-1', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `grade` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '08263E2162CD4CDD7358C8B9FE61C97B', '1');
INSERT INTO `user` VALUES ('2', '08263E2162CD4CDD7358C8B9FE61C97B', '0');
