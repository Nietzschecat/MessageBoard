/*
Navicat MySQL Data Transfer

Source Server         : db_database14
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_database16

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-01-02 15:37:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `revert` int(11) DEFAULT NULL,
  `usergggid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `revert` (`revert`),
  KEY `FK38F4673691A6AC44` (`revert`),
  KEY `FK38F46736A37EE56D` (`userid`),
  KEY `FK38F46736E9FB453E` (`usergggid`),
  KEY `FK38F467361367C96F` (`revert`),
  KEY `FK38F467363EAB5158` (`userid`),
  CONSTRAINT `FK38F467361367C96F` FOREIGN KEY (`revert`) REFERENCES `tb_revert` (`id`),
  CONSTRAINT `FK38F467363EAB5158` FOREIGN KEY (`userid`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `FK38F4673691A6AC44` FOREIGN KEY (`revert`) REFERENCES `tb_revert` (`id`),
  CONSTRAINT `FK38F46736A37EE56D` FOREIGN KEY (`userid`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `FK38F46736E9FB453E` FOREIGN KEY (`usergggid`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES ('13', '家人', '家人', '2015-12-31 11:14:29', null, null, null);
INSERT INTO `tb_message` VALUES ('17', '广告', '广告', '2015-12-31 15:05:07', '4', null, null);
INSERT INTO `tb_message` VALUES ('20', '嘎嘎嘎 ', '灌灌灌灌', '2016-01-01 16:18:43', '4', null, null);
INSERT INTO `tb_message` VALUES ('21', '嘎嘎嘎', '灌灌灌灌', '2016-01-01 16:18:49', '4', null, null);
INSERT INTO `tb_message` VALUES ('22', '嘎嘎嘎', '嘎嘎嘎嘎嘎嘎', '2016-01-01 16:18:57', '4', null, null);
INSERT INTO `tb_message` VALUES ('23', 'hhh ', 'hhh', '2016-01-01 16:57:19', null, null, null);
INSERT INTO `tb_message` VALUES ('24', 'gggggg', 'ggggggggggg', '2016-01-01 16:58:50', '4', null, null);
INSERT INTO `tb_message` VALUES ('25', 'fffffffffffff', 'ffffffffffffffffffff', '2016-01-01 16:58:55', '4', null, null);
INSERT INTO `tb_message` VALUES ('26', 'bbbbbbbbbb', 'bbbbbbbbbbbbbbbbbbbbb', '2016-01-01 16:59:00', '4', null, null);
INSERT INTO `tb_message` VALUES ('27', 'hewbweb', 'wbwebweb', '2016-01-01 16:59:16', '4', null, null);
INSERT INTO `tb_message` VALUES ('28', 'ggggggggg', 'ggggggggggggggggggggg', '2016-01-01 16:59:30', '4', null, null);
INSERT INTO `tb_message` VALUES ('29', 'ggggggggg', 'gggggggggggg', '2016-01-01 16:59:39', '4', null, null);
INSERT INTO `tb_message` VALUES ('30', 'rrrrrrrrrrrrr', 'rrrrrrrrrrrrrrrrrrr', '2016-01-01 16:59:43', '4', null, null);
INSERT INTO `tb_message` VALUES ('33', '哈哈', '哈哈哈', '2016-01-02 11:32:52', '4', null, null);
INSERT INTO `tb_message` VALUES ('34', 'hahaha', 'hahahahahahahahhaha', '2016-01-02 11:52:18', '4', null, null);
INSERT INTO `tb_message` VALUES ('35', '哈哈', '哈哈哈哈', '2016-01-02 11:52:32', '4', null, null);
INSERT INTO `tb_message` VALUES ('36', 'sb', '哈哈', '2016-01-02 11:53:04', '6', null, null);

-- ----------------------------
-- Table structure for tb_revert
-- ----------------------------
DROP TABLE IF EXISTS `tb_revert`;
CREATE TABLE `tb_revert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `revertTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_revert
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'user_guest', 'yumo', '1234', '737021031@qq.com');
INSERT INTO `tb_user` VALUES ('2', 'user_guest', '??', '111', '111');
INSERT INTO `tb_user` VALUES ('3', 'user_guest', 'admin', 'admin', 'admin');
INSERT INTO `tb_user` VALUES ('4', 'user_admin', 'ggg', 'ggg', 'ggg');
INSERT INTO `tb_user` VALUES ('5', 'user_guest', 'yy', 'yy', 'yy');
INSERT INTO `tb_user` VALUES ('6', 'user_guest', '看看', 'kk', 'kk');
