/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : vue-admin

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 06/09/2023 14:22:53
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
INSERT INTO `employee` VALUES (14, 'Nathan Kim', '555-666-7777', '321 Oak Ave', '2022-12-20 08:00:00', NULL, '2023-06-15 10:57:20');
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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `redirect` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pid` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1676146630513209346 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (2, 'system', '/system', '/system/user', '系统管理', 'Tools', 0, NULL, '2023-06-15 10:55:33');
INSERT INTO `menu` VALUES (3, 'user', '/system/user', 'user', '用户管理', 'UserFilled', 2, NULL, '2023-06-15 10:58:01');
INSERT INTO `menu` VALUES (4, 'employee', '/employee', '/employee', '员工管理', 'Avatar', 0, NULL, '2023-06-15 10:58:05');
INSERT INTO `menu` VALUES (5, 'employee', '/employee/employee', 'employee', '员工管理', 'Avatar', 4, NULL, '2023-06-15 10:58:07');
INSERT INTO `menu` VALUES (6, 'menu', '/system/menu', 'menu', '菜单管理', 'Menu', 2, NULL, '2023-06-15 10:58:03');
INSERT INTO `menu` VALUES (1676146630513209346, 'role', '/system/role', '/system/role', '角色管理', 'Stamp', 2, '2023-07-04 16:31:13', '2023-07-04 16:31:38');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `is_admin` tinyint NOT NULL COMMENT '是否是管理员 0 不是 1 是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1654309432060907530 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', '超级管理员', '2023-07-07 14:50:06', 1);
INSERT INTO `role` VALUES (1654309432060907529, '员工', '普通员工', '2023-07-07 14:50:22', 0);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  INDEX `menu_id`(`menu_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1659430757938009183 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1659430757938009172, 1, 2);
INSERT INTO `role_menu` VALUES (1659430757938009173, 1, 3);
INSERT INTO `role_menu` VALUES (1659430757938009174, 1, 6);
INSERT INTO `role_menu` VALUES (1659430757938009175, 1, 1676146630513209346);
INSERT INTO `role_menu` VALUES (1659430757938009176, 1, 4);
INSERT INTO `role_menu` VALUES (1659430757938009177, 1, 5);
INSERT INTO `role_menu` VALUES (1659430757938009178, 1654309432060907529, 4);
INSERT INTO `role_menu` VALUES (1659430757938009179, 1654309432060907529, 5);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status` tinyint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1659043520342994953 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$m2zrdFqwOVPxvPWR0BdXPuNs27qZuHu4.ssfwKKjTlBMcDzK/zYFK', 1, '2023-07-07 15:08:49', '2023-07-07 16:11:54');
INSERT INTO `user` VALUES (1659043520342994952, 'tj', '$2a$10$cPuxS6yvFc.QWSVLaOU87egDd8SHpc/slCOL8ySPiI8pJoBE6efYG', 1, '2023-07-07 15:25:40', '2023-07-26 11:12:18');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint NOT NULL COMMENT '主键id',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1677215538968121345, 1659043520342994951, 1654309432060907529);
INSERT INTO `user_role` VALUES (1677228936585809922, 1, 1);
INSERT INTO `user_role` VALUES (1677232119613837313, 1659043520342994952, 1654309432060907529);

SET FOREIGN_KEY_CHECKS = 1;
