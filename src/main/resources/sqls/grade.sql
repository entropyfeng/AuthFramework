/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : online-beg-server

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-07-01 22:19:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `grade` double DEFAULT NULL,
  PRIMARY KEY (`grade_id`),
  UNIQUE KEY `student_id` (`student_id`,`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '3162052051031', '1', '78');
INSERT INTO `grade` VALUES ('2', '3162052051032', '1', '45');
INSERT INTO `grade` VALUES ('87', '3162052051033', '1', '45');
INSERT INTO `grade` VALUES ('88', '3162052051034', '1', '78');
INSERT INTO `grade` VALUES ('89', '3162052051035', '1', '44');
INSERT INTO `grade` VALUES ('90', '3162052051036', '1', '66');
INSERT INTO `grade` VALUES ('91', '3162052051037', '1', '78');
INSERT INTO `grade` VALUES ('92', '3162052051038', '1', '21');
INSERT INTO `grade` VALUES ('93', '3162052051039', '1', '487');
INSERT INTO `grade` VALUES ('94', '3162052051040', '1', '122');
INSERT INTO `grade` VALUES ('95', '3162052051041', '1', '78');
INSERT INTO `grade` VALUES ('96', '3162052051042', '1', '45');
INSERT INTO `grade` VALUES ('97', '3162052051043', '1', '45');
INSERT INTO `grade` VALUES ('98', '3162052051044', '1', '78');
INSERT INTO `grade` VALUES ('99', '3162052051045', '1', '44');
INSERT INTO `grade` VALUES ('100', '3162052051046', '1', '66');
INSERT INTO `grade` VALUES ('101', '3162052051047', '1', '78');
INSERT INTO `grade` VALUES ('102', '3162052051031', '2', '21');
INSERT INTO `grade` VALUES ('103', '3162052051032', '2', '487');
INSERT INTO `grade` VALUES ('104', '3162052051033', '2', '122');
INSERT INTO `grade` VALUES ('105', '3162052051034', '2', '78');
INSERT INTO `grade` VALUES ('106', '3162052051035', '2', '45');
INSERT INTO `grade` VALUES ('107', '3162052051036', '2', '45');
INSERT INTO `grade` VALUES ('108', '3162052051037', '2', '78');
INSERT INTO `grade` VALUES ('109', '3162052051038', '2', '44');
INSERT INTO `grade` VALUES ('110', '3162052051039', '2', '66');
INSERT INTO `grade` VALUES ('111', '3162052051040', '2', '78');
INSERT INTO `grade` VALUES ('112', '3162052051041', '2', '21');
INSERT INTO `grade` VALUES ('113', '3162052051042', '2', '487');
INSERT INTO `grade` VALUES ('114', '3162052051043', '2', '122');
INSERT INTO `grade` VALUES ('115', '3162052051044', '2', '78');
