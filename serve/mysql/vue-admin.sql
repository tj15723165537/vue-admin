/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : vue-admin

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 05/05/2023 09:18:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `date` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (7, 'Michael Brown', '555-555-5555', '654 Pine St', '2022-05-15 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (8, 'David Wang111', '555-987-6543', '987 Cedar Ave', '2022-06-20 00:00:00', NULL, '2023-04-20 14:21:12');
INSERT INTO `employee` VALUES (9, 'Emily Davis', '555-111-2222', '654 Oak St', '2022-07-31 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (10, 'Jessica Garcia', '555-222-3333', '321 Pine Ave', '2022-08-15 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (11, 'Kevin Martinez', '555-444-5555', '789 Elm St', '2022-09-30 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (12, 'Lisa Nguyen', '555-777-8888', '456 Maple Ave', '2022-10-31 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (13, 'Maria Hernandez', '555-222-4444', '123 Cedar Ln', '2022-11-15 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (14, 'Nathan Kim', '555-666-7777', '321 Oak Ave', '2022-12-20 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (15, 'Olivia Wilson', '555-123-4567', '654 Maple St', '2023-01-31 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (16, 'Peter Lee', '555-555-1111', '987 Pine Ave', '2023-02-14 00:00:00', NULL, '2023-04-20 09:46:59');
INSERT INTO `employee` VALUES (17, 'Rachel Brown', '555-777-9999', '456 Elm St', '2023-03-25 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (18, 'Samuel Chen', '555-222-5555', '321 Oak Ln', '2023-04-30 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (19, 'Tiffany Davis', '555-333-4444', '789 Maple Ave', '2023-05-15 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (20, 'Ulysses Garcia', '555-666-8888', '123 Elm St', '2023-06-20 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (21, 'Victoria Nguyen', '555-999-8888', '456 Cedar Ave', '2023-07-31 00:00:00', NULL, NULL);
INSERT INTO `employee` VALUES (22, 'William Hernandez', '555-444-3333', '789 Maple St', '2023-08-15 00:00:00', NULL, NULL);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `redirect` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pid` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 'home', '/home', '/home', '首页', 'HomeFilled', 0, NULL, NULL);
INSERT INTO `menu` VALUES (2, 'system', '/system', '/system/user', '系统管理', 'Tools', 0, NULL, NULL);
INSERT INTO `menu` VALUES (3, 'user', '/system/user', 'user', '用户管理', 'UserFilled', 2, NULL, NULL);
INSERT INTO `menu` VALUES (4, 'employee', '/employee', '/employee', '员工管理', 'Avatar', 0, NULL, NULL);
INSERT INTO `menu` VALUES (5, 'employee', '/employee/employee', 'employee', '员工管理', 'Avatar', 4, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL,
  `account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status` tinyint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1677918625722 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1677918625692, 'admin', '$2a$10$BgawVKm6v34zK.vqhY2jwu0MFaFQKRZSkoekhdxkC6b3ygYKW5NaS', 1, '2023-03-04 08:30:25', '2023-03-04 08:30:25');
INSERT INTO `user` VALUES (1677918625720, 'user', '$2a$10$nBMeOMpRlXIbAX.l5HxVw.wfwS99OT.IXGYLLKd4oL5WGGaejOYgq', 0, '2023-04-27 11:10:17', '2023-04-27 11:10:17');

SET FOREIGN_KEY_CHECKS = 1;
