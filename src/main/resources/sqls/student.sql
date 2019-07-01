/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : online-beg-server

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-07-01 22:19:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `student_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `student_class_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3162052051031', '张三', '核工程');
INSERT INTO `student` VALUES ('3162052051032', '李四', '物理');
INSERT INTO `student` VALUES ('3162052051033', '狗蛋', '软件工程');
INSERT INTO `student` VALUES ('3162052051034', '王二麻子', '物联网');
INSERT INTO `student` VALUES ('3162052051035', '群主', '土木工程');
INSERT INTO `student` VALUES ('3162052051036', '垃圾', '核工程');
INSERT INTO `student` VALUES ('3162052051037', '张涛', '物理');
INSERT INTO `student` VALUES ('3162052051038', '刘海', '软件工程');
INSERT INTO `student` VALUES ('3162052051039', '很好', '物联网');
INSERT INTO `student` VALUES ('3162052051040', '安拉胡可阿吧', '土木工程');
INSERT INTO `student` VALUES ('3162052051041', '飞而知', '物理');
INSERT INTO `student` VALUES ('3162052051042', '李四', '物理');
INSERT INTO `student` VALUES ('3162052051043', '狗蛋', '软件工程');
INSERT INTO `student` VALUES ('3162052051044', '王二麻子', '物联网');
INSERT INTO `student` VALUES ('3162052051045', '群主', '土木工程');
INSERT INTO `student` VALUES ('3162052051046', '垃圾', '核工程');
INSERT INTO `student` VALUES ('3162052051047', '张涛', '物理');
