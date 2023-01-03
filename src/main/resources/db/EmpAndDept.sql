/*
Navicat MySQL Data Transfer

Source Server         : mysql server
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : springboot_web_demo

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2022-12-24 14:31:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `id` bigint NOT NULL COMMENT '主键id',
  `department_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
INSERT INTO `tb_department` VALUES ('101', '研发部');
INSERT INTO `tb_department` VALUES ('102', '市场部');
INSERT INTO `tb_department` VALUES ('103', '测试部');
INSERT INTO `tb_department` VALUES ('104', '财务部');
INSERT INTO `tb_department` VALUES ('105', '运维部');

-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `last_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` char(10) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `dept_id` bigint DEFAULT NULL COMMENT '部门编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee` VALUES ('1001', 'E-AA', 'aa@126.com', '1', '1999-01-01', '101');
INSERT INTO `tb_employee` VALUES ('1002', 'E-BB', 'bb@126.com', '0', '1999-01-01', '102');
INSERT INTO `tb_employee` VALUES ('1003', 'E-CC', 'cc@126.com', '1', '1999-01-01', '103');
INSERT INTO `tb_employee` VALUES ('1004', 'E-DD', 'dd@126.com', '0', '1999-01-01', '104');
INSERT INTO `tb_employee` VALUES ('1005', 'E-EE', 'ee@126.com', '1', '1999-01-01', '105');
INSERT INTO `tb_employee` VALUES ('1006', 'lmr', 'cc@126.com11', '0', '2022-12-09', '102');
INSERT INTO `tb_employee` VALUES ('1007', '大鹏鸟', '2942****33@qq.com', '1', '2021-06-17', '104');
INSERT INTO `tb_employee` VALUES ('1008', '小龙女', 'abc@123.com', '0', '2023-01-20', '105');
INSERT INTO `tb_employee` VALUES ('1009', 'aaa', 'aaa@123.com', '1', '2022-12-09', '103');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint NOT NULL COMMENT '主键id',
  `username` varchar(50) DEFAULT NULL COMMENT '账号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '123456');
INSERT INTO `tb_user` VALUES ('2', 'common', '123');
INSERT INTO `tb_user` VALUES ('3', 'ruoyi', 'ruoyi');
