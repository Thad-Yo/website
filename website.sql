/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : website

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-07-10 16:50:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_m_department
-- ----------------------------
DROP TABLE IF EXISTS `c_m_department`;
CREATE TABLE `c_m_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_cd` varchar(36) DEFAULT NULL COMMENT '部门编号',
  `department_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `department_leader_id` varchar(36) DEFAULT NULL COMMENT '分公司经理id',
  `department_leader_name` varchar(30) DEFAULT NULL COMMENT '分公司经理姓名',
  `department_p_cd` varchar(36) DEFAULT NULL COMMENT '上级部门编号',
  `status` varchar(2) DEFAULT '0' COMMENT '状态（0：启用，1：禁用）',
  `sort_key` int(3) DEFAULT NULL COMMENT '排序',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识  0未删除，1已删除',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_m_department
-- ----------------------------
INSERT INTO `c_m_department` VALUES ('1', '00000000-0000-0000-0000-000000000000', '中国', '', '', '', '0', null, '0', '', '', '', '', '', '');
INSERT INTO `c_m_department` VALUES ('2', '11528470-2bee-11e7-87c8-4ccc6acbe2b1', '山东', '', '', '00000000-0000-0000-0000-000000000000', '0', '2', '0', '', 'a0000000-d000-m000-i000-n00000000000', '1493368715', '', 'a0000000-d000-m000-i000-n00000000000', '1499222334338');
INSERT INTO `c_m_department` VALUES ('26', '12643b2c-2bee-11e7-87c8-4ccc6acbe2b1', '北京市', '', '', '00000000-0000-0000-0000-000000000000', '0', '1', '0', '', 'a0000000-d000-m000-i000-n00000000000', '1493368716', '', 'a0000000-d000-m000-i000-n00000000000', '1499222341406');
INSERT INTO `c_m_department` VALUES ('31', '6c1c7e59-2bf0-11e7-87c8-4ccc6acbe2b1', '济南', '', '', '11528470-2bee-11e7-87c8-4ccc6acbe2b1', '0', '1', '0', '', 'a0000000-d000-m000-i000-n00000000000', '1493369726', '', 'a0000000-d000-m000-i000-n00000000000', '1499222296745');
INSERT INTO `c_m_department` VALUES ('32', '6c230b9a-2bf0-11e7-87c8-4ccc6acbe2b1', '青岛', '', '', '11528470-2bee-11e7-87c8-4ccc6acbe2b1', '0', '2', '0', '', 'a0000000-d000-m000-i000-n00000000000', '1493369726', '', 'a0000000-d000-m000-i000-n00000000000', '1499222285961');
INSERT INTO `c_m_department` VALUES ('60', '6d48d908-2bf0-11e7-87c8-4ccc6acbe2b1', '北京市辖区', '', '', '12643b2c-2bee-11e7-87c8-4ccc6acbe2b1', '0', '1', '0', '', 'a0000000-d000-m000-i000-n00000000000', '1493369728', '', 'a0000000-d000-m000-i000-n00000000000', '1499222460441');
INSERT INTO `c_m_department` VALUES ('68', 'ce66de70-a26f-4025-8377-6fe63194c4de', '市南区', null, null, '6c230b9a-2bf0-11e7-87c8-4ccc6acbe2b1', null, '1', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499248409049', null, 'a0000000-d000-m000-i000-n00000000000', '1499248409049');

-- ----------------------------
-- Table structure for c_m_department_user
-- ----------------------------
DROP TABLE IF EXISTS `c_m_department_user`;
CREATE TABLE `c_m_department_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_cd` varchar(36) DEFAULT NULL COMMENT '部门编号',
  `user_id` varchar(36) DEFAULT NULL COMMENT '部门名称',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户和部门关联表';

-- ----------------------------
-- Records of c_m_department_user
-- ----------------------------

-- ----------------------------
-- Table structure for c_m_menu
-- ----------------------------
DROP TABLE IF EXISTS `c_m_menu`;
CREATE TABLE `c_m_menu` (
  `menu_id` varchar(36) NOT NULL COMMENT '菜单编号',
  `parent_menu_id` varchar(36) DEFAULT '0' COMMENT '父级菜单编号',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `menu_icon` varchar(100) DEFAULT '' COMMENT '菜单图标',
  `menu_url` varchar(500) DEFAULT NULL COMMENT '菜单链接',
  `menu_controllor` varchar(100) DEFAULT NULL COMMENT '菜单权限',
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `sort_key` int(11) DEFAULT NULL COMMENT '排序',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台菜单表';

-- ----------------------------
-- Records of c_m_menu
-- ----------------------------
INSERT INTO `c_m_menu` VALUES ('10000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', '系统管理', 'fa fa-cog', null, null, '0', '90', '0', null, null, null, null, null, null);
INSERT INTO `c_m_menu` VALUES ('10000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000000', '角色维护', 'fa fa-gg', 'system/maintenance/role/init', 'sys_role', '0', '1', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491909194213');
INSERT INTO `c_m_menu` VALUES ('10000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000000', '菜单维护', 'fa fa-map-signs', 'system/maintenance/menu/init', 'menus', '0', '2', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1499236239396');
INSERT INTO `c_m_menu` VALUES ('80f52bf2-d889-4298-affa-1d502c396f65', '10000000-0000-0000-0000-000000000000', '用户管理', 'glyphicon glyphicon-user', 'system/maintenance/adminuser/init', 'users', null, '3', '0', '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1487815351905', '', 'a0000000-d000-m000-i000-n00000000000', '1495000005982');
INSERT INTO `c_m_menu` VALUES ('85c4727f-4cb6-4601-abe7-1dce277705bf', '00000000-0000-0000-0000-000000000000', '修改密码', 'fa fa-key', 'system/modpwd/init', 'modpw', null, '999', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1492592041153', null, 'a0000000-d000-m000-i000-n00000000000', '1493278638000');
INSERT INTO `c_m_menu` VALUES ('a38d15be-d025-4ae7-b252-8fc06782a583', '10000000-0000-0000-0000-000000000000', '数据字典管理', 'fa fa-book', 'system/maintenance/name/init', 'sys_name', '', '5', '0', '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491900183767', '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491962745373');
INSERT INTO `c_m_menu` VALUES ('a9782e7d-1a66-4325-9877-0a0f7f63b9e6', '10000000-0000-0000-0000-000000000000', '部门管理', 'fa fa-users', 'system/maintenance/department/init', 'department', null, '4', '0', '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1487815730159', '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1487823132237');

-- ----------------------------
-- Table structure for c_m_menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `c_m_menu_permission`;
CREATE TABLE `c_m_menu_permission` (
  `id` varchar(36) NOT NULL,
  `menu_id` varchar(36) DEFAULT NULL COMMENT '菜单编号',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `permission_name` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台菜单权限关联表';

-- ----------------------------
-- Records of c_m_menu_permission
-- ----------------------------
INSERT INTO `c_m_menu_permission` VALUES ('01167dd1-da3e-4366-b406-c72256c59387', '10000000-0000-0000-0000-000000000001', 'AUTH', '授权', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491909194213');
INSERT INTO `c_m_menu_permission` VALUES ('199738a4-350d-4855-bb35-53842c0c0dd6', 'a9782e7d-1a66-4325-9877-0a0f7f63b9e6', 'VIEW', '查看', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1487823132237');
INSERT INTO `c_m_menu_permission` VALUES ('217549b0-58df-41ba-b6af-a76129e7e39c', '10000000-0000-0000-0000-000000000001', 'DELETE', '删除', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491909194213');
INSERT INTO `c_m_menu_permission` VALUES ('26d49bb1-f313-4e08-bdff-e495023561b0', '10000000-0000-0000-0000-000000000002', 'VIEW', '查看', '0', null, null, null, null, 'a0000000-d000-m000-i000-n00000000000', '1499236239396');
INSERT INTO `c_m_menu_permission` VALUES ('2a9ea59c-4c71-42df-bab2-2bb108d113cd', '10000000-0000-0000-0000-000000000001', 'ADD', '添加', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491909194213');
INSERT INTO `c_m_menu_permission` VALUES ('3169aa6f-a839-4174-8962-1e706962d0dc', 'a38d15be-d025-4ae7-b252-8fc06782a583', 'VIEW', '查看', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491962745373');
INSERT INTO `c_m_menu_permission` VALUES ('5dfa2956-46e3-41d5-afd1-e8775b69c26e', '85c4727f-4cb6-4601-abe7-1dce277705bf', 'VIEW', '查看', '0', null, null, null, null, 'a0000000-d000-m000-i000-n00000000000', '1493278638000');
INSERT INTO `c_m_menu_permission` VALUES ('5e8035e9-9873-4ba8-89d6-71e1825de112', '80f52bf2-d889-4298-affa-1d502c396f65', 'VIEW', '查看', '0', null, null, null, '', 'a0000000-d000-m000-i000-n00000000000', '1495000005982');
INSERT INTO `c_m_menu_permission` VALUES ('7d9cdc92-07ac-4df0-a76a-7ed3d6f7b7c6', '80f52bf2-d889-4298-affa-1d502c396f65', 'DELETE', '删除', '0', null, null, null, '', 'a0000000-d000-m000-i000-n00000000000', '1495000005982');
INSERT INTO `c_m_menu_permission` VALUES ('8b8eb7f8-f8be-4c97-9885-06eeae0e4fd0', '10000000-0000-0000-0000-000000000001', 'MODIFY', '编辑', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491909194213');
INSERT INTO `c_m_menu_permission` VALUES ('948f9f83-a17e-43ea-a21a-81c88bd3df47', 'a38d15be-d025-4ae7-b252-8fc06782a583', 'DELETE', '删除', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491962745373');
INSERT INTO `c_m_menu_permission` VALUES ('975c2c05-694b-4ed3-8fc9-b81746872383', 'a38d15be-d025-4ae7-b252-8fc06782a583', 'MODIFY', '修改', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491962745373');
INSERT INTO `c_m_menu_permission` VALUES ('af2310dc-f2eb-4172-b035-6aed8d090dbe', 'a38d15be-d025-4ae7-b252-8fc06782a583', 'ADD', '添加', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491962745373');
INSERT INTO `c_m_menu_permission` VALUES ('b74dce5e-9b87-4c8b-88f9-ed3375910278', '10000000-0000-0000-0000-000000000000', 'VIEW', '查看', '0', null, null, null, null, null, null);
INSERT INTO `c_m_menu_permission` VALUES ('eb8e4e9c-bc7d-4fd8-a9ab-dd7aa7885eb9', '10000000-0000-0000-0000-000000000001', 'VIEW', '查看', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1491909194213');
INSERT INTO `c_m_menu_permission` VALUES ('fb146f34-cdc7-4f20-a754-a5c46cb8ca31', '80f52bf2-d889-4298-affa-1d502c396f65', 'EDIT', '编辑', '0', null, null, null, '', 'a0000000-d000-m000-i000-n00000000000', '1495000005982');

-- ----------------------------
-- Table structure for c_m_name
-- ----------------------------
DROP TABLE IF EXISTS `c_m_name`;
CREATE TABLE `c_m_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_class` varchar(20) NOT NULL DEFAULT '' COMMENT '名称区分',
  `name_cd` varchar(6) NOT NULL DEFAULT '' COMMENT '名称编号',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `sort_key` varchar(2) DEFAULT NULL COMMENT '排序',
  `data` varchar(20) DEFAULT NULL COMMENT '数据',
  `reserve01` varchar(20) DEFAULT NULL COMMENT '扩展项目01',
  `reserve02` varchar(20) DEFAULT NULL COMMENT '扩展项目02',
  `reserve03` varchar(20) DEFAULT NULL COMMENT '扩展项目03',
  `notes` varchar(200) DEFAULT NULL COMMENT '备考',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标识 0启用、1删除',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '创建者编号',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '创建者部门编号',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建者时间',
  `update_user_cd` varchar(36) DEFAULT NULL,
  `update_group_cd` varchar(36) DEFAULT NULL,
  `update_date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of c_m_name
-- ----------------------------

-- ----------------------------
-- Table structure for c_m_role
-- ----------------------------
DROP TABLE IF EXISTS `c_m_role`;
CREATE TABLE `c_m_role` (
  `role_id` varchar(36) NOT NULL COMMENT '角色编号',
  `role` varchar(100) DEFAULT NULL COMMENT '角色标识',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `role_status` char(1) DEFAULT '1' COMMENT '角色状态 1启用；0禁用',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台角色表';

-- ----------------------------
-- Records of c_m_role
-- ----------------------------
INSERT INTO `c_m_role` VALUES ('00000000-0000-0000-0000-000000000000', 'admin', '超级管理员', '管理员角色', '1', '0', null, null, null, '11111111-1111-1111-1111-111111111111', 'a0000000-d000-m000-i000-n00000000000', '1479869933074');
INSERT INTO `c_m_role` VALUES ('7e46684d-f5e5-403b-b729-a928108a56d9', 'MANAGER', '普通管理员', '普通管理员', '1', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499225143264', null, 'a0000000-d000-m000-i000-n00000000000', '1499243896946');

-- ----------------------------
-- Table structure for c_m_role_menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `c_m_role_menu_permission`;
CREATE TABLE `c_m_role_menu_permission` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) DEFAULT NULL,
  `menu_id` varchar(36) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限关联表';

-- ----------------------------
-- Records of c_m_role_menu_permission
-- ----------------------------
INSERT INTO `c_m_role_menu_permission` VALUES ('0ce0fe2e-a65b-4103-b027-b7a6fc182058', '00000000-0000-0000-0000-000000000000', 'a38d15be-d025-4ae7-b252-8fc06782a583', 'VIEW', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('37a59e6e-e565-42a8-882b-1a4e2c8c724f', '00000000-0000-0000-0000-000000000000', '85c4727f-4cb6-4601-abe7-1dce277705bf', 'VIEW', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('4320991c-c962-452b-ac31-3da141126313', '00000000-0000-0000-0000-000000000000', '80f52bf2-d889-4298-affa-1d502c396f65', 'DELETE', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('5c22ec4d-e616-411d-ae78-bd9ee905cd5e', '00000000-0000-0000-0000-000000000000', '80f52bf2-d889-4298-affa-1d502c396f65', 'VIEW', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('6022ef7f-f03c-4d8a-a4a6-a35559065470', '00000000-0000-0000-0000-000000000000', 'a38d15be-d025-4ae7-b252-8fc06782a583', 'MODIFY', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('606ac9db-ba9c-411a-959d-beaa2e826c16', '00000000-0000-0000-0000-000000000000', '10000000-0000-0000-0000-000000000001', 'ADD', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('63698037-8bd9-4bdf-a527-20cb7c93fe00', '00000000-0000-0000-0000-000000000000', '10000000-0000-0000-0000-000000000001', 'DELETE', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('7be63040-aa43-498b-8743-7188b10508f6', '00000000-0000-0000-0000-000000000000', 'a38d15be-d025-4ae7-b252-8fc06782a583', 'DELETE', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('818891e5-b6ff-49eb-ad2a-73767f33fdc1', '00000000-0000-0000-0000-000000000000', '10000000-0000-0000-0000-000000000000', 'VIEW', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('8241e223-c057-4a6a-9e7b-6c369fdaa0b6', '00000000-0000-0000-0000-000000000000', '10000000-0000-0000-0000-000000000001', 'MODIFY', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('89bc1d12-6c9f-4184-8e7e-56fef8f82d42', '00000000-0000-0000-0000-000000000000', 'a38d15be-d025-4ae7-b252-8fc06782a583', 'ADD', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('98c6e283-bb6c-4ea5-9740-f0a4e9723869', '7e46684d-f5e5-403b-b729-a928108a56d9', '85c4727f-4cb6-4601-abe7-1dce277705bf', 'VIEW', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499225157069', null, 'a0000000-d000-m000-i000-n00000000000', '1499225157069');
INSERT INTO `c_m_role_menu_permission` VALUES ('9f93ee98-542d-49f3-a1ee-9af26beac35f', '00000000-0000-0000-0000-000000000000', '10000000-0000-0000-0000-000000000001', 'VIEW', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('a408b626-032d-4736-be2e-99b6b6d28024', '00000000-0000-0000-0000-000000000000', '80f52bf2-d889-4298-affa-1d502c396f65', 'EDIT', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('aa8bb57c-294c-4462-818a-3c9fda2757d3', '00000000-0000-0000-0000-000000000000', '10000000-0000-0000-0000-000000000001', 'AUTH', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('e46c0d54-b7e3-4bb3-b8c9-f1639e0417aa', '00000000-0000-0000-0000-000000000000', '10000000-0000-0000-0000-000000000002', 'VIEW', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');
INSERT INTO `c_m_role_menu_permission` VALUES ('ede20ee6-941d-4b38-baf8-e34f0def2500', '00000000-0000-0000-0000-000000000000', 'a9782e7d-1a66-4325-9877-0a0f7f63b9e6', 'VIEW', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851', null, 'a0000000-d000-m000-i000-n00000000000', '1499168319851');

-- ----------------------------
-- Table structure for c_m_sequence
-- ----------------------------
DROP TABLE IF EXISTS `c_m_sequence`;
CREATE TABLE `c_m_sequence` (
  `name` varchar(36) NOT NULL COMMENT '采番序号',
  `current_value` int(11) NOT NULL COMMENT '当前值',
  `increment` int(11) NOT NULL DEFAULT '1' COMMENT '增量值',
  `notes` varchar(500) DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据编号表';

-- ----------------------------
-- Records of c_m_sequence
-- ----------------------------
INSERT INTO `c_m_sequence` VALUES ('APPLY_NO', '12', '1', '申请编号', '0', null, null, null, null, null, '20170428');

-- ----------------------------
-- Table structure for c_m_user
-- ----------------------------
DROP TABLE IF EXISTS `c_m_user`;
CREATE TABLE `c_m_user` (
  `user_id` varchar(36) NOT NULL,
  `user_name` varchar(50) NOT NULL COMMENT '用户名称',
  `company_name` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(100) NOT NULL COMMENT '用户密码',
  `des3` varchar(100) DEFAULT NULL COMMENT 'des3',
  `mobile_number` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `extension_number` varchar(20) DEFAULT NULL COMMENT '分机号',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `email_address` varchar(150) DEFAULT NULL COMMENT '电子邮箱',
  `user_flag` varchar(10) DEFAULT NULL COMMENT '1：邀约员   2：外访员 3 ：内审员',
  `notes` varchar(500) DEFAULT NULL COMMENT '备注',
  `user_no` varchar(20) DEFAULT NULL COMMENT '员工编号',
  `position` varchar(20) DEFAULT NULL COMMENT '职位',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别（1：男，0：女）',
  `join_date` varchar(10) DEFAULT NULL COMMENT '入职日期',
  `birthday` varchar(10) DEFAULT NULL COMMENT '出生日期',
  `id_no` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `user_type` varchar(1) DEFAULT '' COMMENT '用户客户类型（0：全部，1：用户客户类别关联表）',
  `user_icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `card_no` varchar(100) DEFAULT NULL COMMENT '银行卡号',
  `user_sort_key` int(11) DEFAULT NULL,
  `is_agree_agreement` varchar(1) DEFAULT '1' COMMENT '同意用户协议(0：同意，1：不同意)',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of c_m_user
-- ----------------------------
INSERT INTO `c_m_user` VALUES ('a0000000-d000-m000-i000-n00000000000', 'admin', '系统管理员', '超级管理员', 'e10adc3949ba59abbe56e057f20f883e', '1', '13400000000', '', '家庭地址', 'test@test.com', '09', '', '1', '', '', '', '', '1111', null, '/intranet-admin/ueditor/jsp/upload/image/20161123/1479877822710049259.jpg', '', '0', '1', '0', '', 'a0000000-d000-m000-i000-n00000000000', '1478955155417', '0d4ab943-2e59-4adf-8543-fef09ba46e83', 'a0000000-d000-m000-i000-n00000000000', '1492658694373');
INSERT INTO `c_m_user` VALUES ('f5548682-db0f-45cb-b0f5-5933242b0c16', 'zhuxiaodong', null, '朱晓东', 'dc483e80a7a0bd9ef71d8cf973673924', null, '13697678307', '', null, '', null, null, null, null, '1', null, null, null, '1', null, null, '0', '1', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499222999301', null, 'a0000000-d000-m000-i000-n00000000000', '1499676537903');

-- ----------------------------
-- Table structure for c_m_user_custom
-- ----------------------------
DROP TABLE IF EXISTS `c_m_user_custom`;
CREATE TABLE `c_m_user_custom` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  `custom_type` varchar(36) DEFAULT NULL COMMENT '客户类型，关联客户类表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和客户类关联表';

-- ----------------------------
-- Records of c_m_user_custom
-- ----------------------------

-- ----------------------------
-- Table structure for c_m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `c_m_user_role`;
CREATE TABLE `c_m_user_role` (
  `user_id` varchar(36) NOT NULL COMMENT '用户编号',
  `role_id` varchar(36) NOT NULL,
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户角色关联表';

-- ----------------------------
-- Records of c_m_user_role
-- ----------------------------
INSERT INTO `c_m_user_role` VALUES ('a0000000-d000-m000-i000-n00000000000', '00000000-0000-0000-0000-000000000000', '0', null, null, null, '0d4ab943-2e59-4adf-8543-fef09ba46e83', 'a0000000-d000-m000-i000-n00000000000', '1492658694373');
INSERT INTO `c_m_user_role` VALUES ('f5548682-db0f-45cb-b0f5-5933242b0c16', '7e46684d-f5e5-403b-b729-a928108a56d9', '0', null, 'a0000000-d000-m000-i000-n00000000000', '1499222999301', null, 'a0000000-d000-m000-i000-n00000000000', '1499676537903');

-- ----------------------------
-- Table structure for c_t_attachment
-- ----------------------------
DROP TABLE IF EXISTS `c_t_attachment`;
CREATE TABLE `c_t_attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_id` varchar(36) DEFAULT NULL COMMENT '文件ID(工单编号)',
  `item_id` varchar(36) DEFAULT NULL COMMENT '工单详情id(0: 待送材料)',
  `file_order` int(8) DEFAULT NULL COMMENT '文件顺序',
  `file_name` varchar(128) DEFAULT NULL COMMENT '原文件名',
  `att_type` varchar(128) DEFAULT NULL COMMENT '附件类型（业务描述1:送材料，2：取证）',
  `file_type` varchar(128) DEFAULT NULL COMMENT '文件类型(1:图片，2：录音，3：Excel，4：其他)',
  `extension` varchar(10) DEFAULT NULL COMMENT '文件拓展名',
  `file_size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `save_path` varchar(2000) DEFAULT NULL COMMENT '存放路径',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `create_group_cd` varchar(36) DEFAULT NULL COMMENT '初期新建部门编号',
  `create_user_cd` varchar(36) DEFAULT NULL COMMENT '初期新建者',
  `create_date` varchar(20) DEFAULT NULL COMMENT '初期新建日',
  `update_group_cd` varchar(36) DEFAULT NULL COMMENT '最终更新部门编号',
  `update_user_cd` varchar(36) DEFAULT NULL COMMENT '最终更新者',
  `update_date` varchar(20) DEFAULT NULL COMMENT '最终更新日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of c_t_attachment
-- ----------------------------

-- ----------------------------
-- Function structure for rand_string
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_string`;
DELIMITER ;;
CREATE DEFINER=`lianxin`@`%` FUNCTION `rand_string`(n INT) RETURNS varchar(255) CHARSET latin1
BEGIN
DECLARE chars_str varchar(100) DEFAULT 'abcdefghijklmnopqrstuvwxyz0123456789';
DECLARE return_str varchar(255) DEFAULT '';
DECLARE i INT DEFAULT 0;
WHILE i < n DO
SET return_str = concat(return_str,substring(chars_str , FLOOR(1 + RAND()*62 ),1));
SET i = i +1;
END WHILE;
RETURN return_str;
END
;;
DELIMITER ;
