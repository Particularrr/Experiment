/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云contact
Source Server Version : 80024
Source Host           : 43.139.217.145:3306
Source Database       : contact

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2024-11-24 16:47:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary key, unique identifier',
  `gender` varchar(10) NOT NULL COMMENT '性别',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `age` varchar(10) DEFAULT NULL COMMENT '年龄',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email_address` varchar(100) DEFAULT NULL COMMENT '电子邮件地址',
  `social_media_address` varchar(255) DEFAULT NULL COMMENT '社交媒体地址',
  `physical_address` varchar(255) DEFAULT NULL COMMENT '实际地址',
  `importance_level` varchar(20) DEFAULT NULL COMMENT '重要程度',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Record creation time',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Record update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Contact table for managing personal contact information';

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('2', '女', '张学友', '123', '123132123', '123123@qq.com', '123', '123', '不太重要', '2024-11-24 15:25:26', '2024-11-24 16:31:52');
INSERT INTO `contact` VALUES ('3', '男', '王力宏', '32', '18585202609', '1312902459@qq.com', '冰岛', '冰岛', '非常重要', '2024-11-24 15:25:43', '2024-11-24 16:31:45');
