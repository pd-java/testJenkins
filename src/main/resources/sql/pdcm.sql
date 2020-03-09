/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : pdcm

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 09/03/2020 17:11:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cm_navigation_bar
-- ----------------------------
DROP TABLE IF EXISTS `cm_navigation_bar`;
CREATE TABLE `cm_navigation_bar`  (
  `navigationId` int(5) NOT NULL AUTO_INCREMENT,
  `navigationName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '导航栏各导航名称',
  `navigationAuthor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导航创建作者',
  `navigatinoCreatTime` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导航创建的日期',
  `navigationStatus` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导航状态（可用：1；不可用：0）',
  PRIMARY KEY (`navigationId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cm_navigation_bar
-- ----------------------------
INSERT INTO `cm_navigation_bar` VALUES (1, '在线编辑器', 'pd', '2020/02/08', '1');
INSERT INTO `cm_navigation_bar` VALUES (2, '前端库', 'pd', '2020/02/08', '1');

-- ----------------------------
-- Table structure for com_back_menu
-- ----------------------------
DROP TABLE IF EXISTS `com_back_menu`;
CREATE TABLE `com_back_menu`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_level` int(2) NULL DEFAULT NULL,
  `menu_creat_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_creator` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_status` tinyint(1) NULL DEFAULT NULL,
  `menu_path` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_back_menu
-- ----------------------------
INSERT INTO `com_back_menu` VALUES (1, '账号管理', 1, '2020/02/28', 'pd', 1, NULL);
INSERT INTO `com_back_menu` VALUES (2, '个人组件', 1, '2020/02/28', 'pd', 1, NULL);
INSERT INTO `com_back_menu` VALUES (3, '资料设置', 2, '2020/02/28', 'pd', 1, '/PersonCenterPage/BackDataSet');
INSERT INTO `com_back_menu` VALUES (4, '密码修改', 2, '2020/02/28', 'pd', 1, '/PersonCenterPage/BackPasswordModify');
INSERT INTO `com_back_menu` VALUES (5, '组件管理', 2, '2020/02/28', 'pd', 1, '/PersonCenterPage/BackComponentManage');
INSERT INTO `com_back_menu` VALUES (6, '上传组件', 2, '2020/02/28', 'pd', 1, '/PersonCenterPage/BackUploadComponent');
INSERT INTO `com_back_menu` VALUES (7, '资料儿子', 3, '2020/02/28', 'pd', 1, NULL);
INSERT INTO `com_back_menu` VALUES (8, '资料孙子', 4, '2020/03/01', 'pd', 1, NULL);
INSERT INTO `com_back_menu` VALUES (9, '儿子孙子', 5, '2020/03/01', 'pd', 1, NULL);
INSERT INTO `com_back_menu` VALUES (10, '孙子孙子', 6, '2020/03/01', 'pd', 1, NULL);
INSERT INTO `com_back_menu` VALUES (11, '密码儿子', 3, '2020/03/01', 'pd', 1, NULL);
INSERT INTO `com_back_menu` VALUES (12, '密码孙子', 4, '2020/03/01', 'pd', 1, NULL);

-- ----------------------------
-- Table structure for com_back_menu_relate
-- ----------------------------
DROP TABLE IF EXISTS `com_back_menu_relate`;
CREATE TABLE `com_back_menu_relate`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `father_id` int(5) NULL DEFAULT NULL,
  `son_id` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_back_menu_relate
-- ----------------------------
INSERT INTO `com_back_menu_relate` VALUES (1, 1, 3);
INSERT INTO `com_back_menu_relate` VALUES (2, 1, 4);
INSERT INTO `com_back_menu_relate` VALUES (3, 2, 5);
INSERT INTO `com_back_menu_relate` VALUES (4, 2, 6);

-- ----------------------------
-- Table structure for component
-- ----------------------------
DROP TABLE IF EXISTS `component`;
CREATE TABLE `component`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `component_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_uuid_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_creator` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_creat_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `compontent_picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_status` tinyint(1) NOT NULL DEFAULT 1,
  `component_enabled` tinyint(1) NOT NULL DEFAULT 1,
  `component_modify_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_download_times` int(5) NOT NULL DEFAULT 0,
  `component_browse_times` int(5) NOT NULL DEFAULT 0,
  `component_prefer_times` int(5) NOT NULL DEFAULT 0,
  `component_exhibition_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_download_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of component
-- ----------------------------
INSERT INTO `component` VALUES (1, '3D粒子波浪', 'three1', '动画', '3D粒子效果', 'pd', '2020/02/24', 'http://localhost:8080/uploadComponents/three/tree.png', 1, 1, '2020/02/24', 1, 2, 1, 'http://localhost:8080/uploadComponents/three/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\3D粒子波浪.zip');
INSERT INTO `component` VALUES (2, 'jQuery鼠标移入方向感知', 'jQueryfxgz1', '背景', '4D粒子效果', 'pd', '2020/02/25', 'http://localhost:8080/uploadComponents/jQueryfxgz/jQueryfxgz.png', 1, 1, '2020/02/25', 1, 565, 95, 'http://localhost:8080/uploadComponents/jQueryfxgz/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\jQuery鼠标移入方向感知.zip');
INSERT INTO `component` VALUES (3, 'css3hover', 'css3hover1', '按钮', '5D粒子效果', 'pd', '2020/02/26', 'http://localhost:8080/uploadComponents/css3hover/css3hover.png', 1, 1, '2020/02/26', 57, 1565, 95, 'http://localhost:8080/uploadComponents/css3hover/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\css3hover.zip');
INSERT INTO `component` VALUES (4, '3D粒子波浪', 'three2', '动画', '6D粒子效果', 'pd', '2020/02/27', 'http://localhost:8080/uploadComponents/three/tree.png', 1, 0, '2020/02/27', 257, 984, 236, 'http://localhost:8080/uploadComponents/three/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\3D粒子波浪.zip');
INSERT INTO `component` VALUES (5, 'css3hover', 'css3hover2', '按钮', '7D粒子效果', 'pd', '2020/02/28', 'http://localhost:8080/uploadComponents/css3hover/css3hover.png', 1, 1, '2020/02/28', 2, 2616, 9, 'http://localhost:8080/uploadComponents/css3hover/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\css3hover.zip');
INSERT INTO `component` VALUES (6, 'jQuery鼠标移入方向感知', 'jQueryfxgz2', '背景', '8D粒子效果', 'pd', '2020/02/29', 'http://localhost:8080/uploadComponents/jQueryfxgz/jQueryfxgz.png', 1, 1, '2020/02/29', 24, 849, 95, 'http://localhost:8080/uploadComponents/jQueryfxgz/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\jQuery鼠标移入方向感知.zip');
INSERT INTO `component` VALUES (7, '3D粒子波浪', 'three3', '动画', '9D粒子效果', 'pd', '2020/02/30', 'http://localhost:8080/uploadComponents/three/tree.png', 1, 1, '2020/02/30', 42, 261, 18, 'http://localhost:8080/uploadComponents/three/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\3D粒子波浪.zip');
INSERT INTO `component` VALUES (8, 'jQuery鼠标移入方向感知', 'jQueryfxgz3', '背景', '10D粒子效果', 'pd', '2020/02/30', 'http://localhost:8080/uploadComponents/jQueryfxgz/jQueryfxgz.png', 1, 1, '2020/02/30', 425, 9, 9, 'http://localhost:8080/uploadComponents/jQueryfxgz/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\jQuery鼠标移入方向感知.zip');
INSERT INTO `component` VALUES (9, '3D粒子波浪', 'three4', '动画', '11D粒子效果', 'pd', '2020/02/30', 'http://localhost:8080/uploadComponents/three/tree.png', 1, 1, '2020/02/30', 237, 95, 26, 'http://localhost:8080/uploadComponents/three/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\3D粒子波浪.zip');
INSERT INTO `component` VALUES (10, 'css3hover', 'css3hover3', '按钮', '12D粒子效果', 'pd', '2020/02/30', 'http://localhost:8080/uploadComponents/css3hover/css3hover.png', 1, 1, '2020/02/30', 45, 516, 74, 'http://localhost:8080/uploadComponents/css3hover/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\css3hover.zip');
INSERT INTO `component` VALUES (11, 'jQuery鼠标移入方向感知', 'jQueryfxgz4', '背景', '13D粒子效果', 'pd', '2020/02/30', 'http://localhost:8080/uploadComponents/jQueryfxgz/jQueryfxgz.png', 1, 1, '2020/02/30', 565, 62, 3, 'http://localhost:8080/uploadComponents/jQueryfxgz/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\jQuery鼠标移入方向感知.zip');
INSERT INTO `component` VALUES (12, '3D粒子波浪', 'three5', '动画', '14D粒子效果', 'pd', '2020/02/30', 'http://localhost:8080/uploadComponents/three/tree.png', 1, 1, '2020/02/30', 5, 56, 2, 'http://localhost:8080/uploadComponents/three/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\3D粒子波浪.zip');
INSERT INTO `component` VALUES (13, 'css3hover', 'css3hover4', '按钮', '12D粒子效果', 'pd', '2020/02/30', 'http://localhost:8080/uploadComponents/css3hover/css3hover.png', 1, 1, '2020/02/30', 45, 516, 74, 'http://localhost:8080/uploadComponents/css3hover/index.html', 'D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\css3hover.zip');
INSERT INTO `component` VALUES (38, '热尽快给你', 'e4484b8e-f175-4193-ad86-138cdbc9128a', '输入框', 'r个案v阿尔v', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/04/e4484b8e-f175-4193-ad86-138cdbc9128a.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/04/bef9a4d2-d8ce-4eb9-bf8e-c059bbf626d8', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/04/bef9a4d2-d8ce-4eb9-bf8e-c059bbf626d8.zip');
INSERT INTO `component` VALUES (39, '测试上传组件', 'dfcbb007-4905-4016-95e2-31508c70568f', '标签', '不好的事覅哦啊搜房降低', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/04/dfcbb007-4905-4016-95e2-31508c70568f.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/04/f70e322b-e8db-4b6a-ad74-932075ee4b6e', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/04/f70e322b-e8db-4b6a-ad74-932075ee4b6e.zip');
INSERT INTO `component` VALUES (40, '氛围', '4a31aab6-ab70-416c-9f24-34dc9f45e7c1', '列表', '和俄国委任为v给他率为v给他率', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/04/4a31aab6-ab70-416c-9f24-34dc9f45e7c1.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/04/dd101b3d-70f3-4db6-af61-652168cf4ec0', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/04/dd101b3d-70f3-4db6-af61-652168cf4ec0.zip');
INSERT INTO `component` VALUES (41, 'sfd', '8e21123a-606d-480c-ba75-03bcdcf8c55b', '下拉选', 'ferfeafcq3wfaqwe3', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/04/8e21123a-606d-480c-ba75-03bcdcf8c55b.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/04/02e0f6c8-0276-4143-9f62-19931c80d3d5', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/04/02e0f6c8-0276-4143-9f62-19931c80d3d5.zip');
INSERT INTO `component` VALUES (42, '发大水', '533c7d37-55fc-4430-8e48-6a6509a488db', '选择框', '高峰微软过热', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/04/533c7d37-55fc-4430-8e48-6a6509a488db.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/04/90d161ad-ac5b-4012-addc-d2bd594e8316', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/04/90d161ad-ac5b-4012-addc-d2bd594e8316.zip');
INSERT INTO `component` VALUES (43, '啊额率', '09389333-2265-437c-95aa-72934f260da1', '列表', '大噶大概v色啊的v', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/06/09389333-2265-437c-95aa-72934f260da1.jpg', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/06/898e431b-7574-4700-9c05-ef9d6628402a', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/06/898e431b-7574-4700-9c05-ef9d6628402a.zip');
INSERT INTO `component` VALUES (44, '法撒旦', '52c01275-cbc8-4e4c-8d5e-bd4ba3ce22e3', '列表', '饿啊饿规律恶气啊', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/06/52c01275-cbc8-4e4c-8d5e-bd4ba3ce22e3.jpg', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/06/c20c06af-0401-4658-9622-235d5a19d753', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/06/c20c06af-0401-4658-9622-235d5a19d753.zip');
INSERT INTO `component` VALUES (45, '的发色v人', '0ad26a97-5091-48c5-b895-0550eeb9794c', '按钮', '费按规范v肥肉', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/06/0ad26a97-5091-48c5-b895-0550eeb9794c.jpg', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/06/cee92de6-b265-413a-8937-56cee3175872', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/06/cee92de6-b265-413a-8937-56cee3175872.zip');
INSERT INTO `component` VALUES (46, '发射点发的哈', '714df966-5c70-4f56-a88b-e79308232698', '动画', '奥尔格全国房企二哦哦', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/09/714df966-5c70-4f56-a88b-e79308232698.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/09/3a0545e3-2e14-424f-ae46-09499d008ebe', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/09/3a0545e3-2e14-424f-ae46-09499d008ebe.zip');
INSERT INTO `component` VALUES (47, '放大士大夫', 'e7c68f26-a6c1-41d9-9870-b09a8c64194b', '列表', '防守打法二分', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/06/e7c68f26-a6c1-41d9-9870-b09a8c64194b.jfif', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/06/2ba50bd2-8235-4526-bf0d-97eae7ff7c96', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/06/2ba50bd2-8235-4526-bf0d-97eae7ff7c96.zip');
INSERT INTO `component` VALUES (50, '最后一个', 'fc13d6aa-a8c5-485b-aaab-03303dc2d100', '下拉选', '最后一个文件，测试上传图片数据填充', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/08/fc13d6aa-a8c5-485b-aaab-03303dc2d100.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/08/c6fe35ff-8247-48b8-88bc-65e7d705f173', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/08/c6fe35ff-8247-48b8-88bc-65e7d705f173.zip');
INSERT INTO `component` VALUES (51, '上传功能测试地方', '7efa8bf2-fefa-4ea3-85e1-16ff2e72154f', '按钮', '山本出啊凭感觉哦啊商品的价格发的说法', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/09/7efa8bf2-fefa-4ea3-85e1-16ff2e72154f.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/09/1413026a-942d-472c-9181-0313f2afa2d7', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/09/1413026a-942d-472c-9181-0313f2afa2d7.zip');
INSERT INTO `component` VALUES (52, '上传测试二', '69d52175-f712-4b27-9ee1-c5bd4e2c9c4f', '标签', '杀地煞是德国', NULL, NULL, 'http://localhost:8080/uploadComponents/2020/03/09/69d52175-f712-4b27-9ee1-c5bd4e2c9c4f.png', 1, 1, NULL, 0, 0, 0, 'http://localhost:8080/uploadComponents/2020/03/09/78f163f5-2c16-4153-a747-92b170d7004a', 'D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents/2020/03/09/78f163f5-2c16-4153-a747-92b170d7004a.zip');

-- ----------------------------
-- Table structure for component_related_type
-- ----------------------------
DROP TABLE IF EXISTS `component_related_type`;
CREATE TABLE `component_related_type`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `component_id` int(5) NULL DEFAULT NULL,
  `component_type_id` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of component_related_type
-- ----------------------------
INSERT INTO `component_related_type` VALUES (1, 1, 4);
INSERT INTO `component_related_type` VALUES (2, 2, 5);
INSERT INTO `component_related_type` VALUES (3, 3, 7);
INSERT INTO `component_related_type` VALUES (4, 4, 4);
INSERT INTO `component_related_type` VALUES (5, 5, 7);
INSERT INTO `component_related_type` VALUES (6, 6, 5);
INSERT INTO `component_related_type` VALUES (7, 7, 4);
INSERT INTO `component_related_type` VALUES (8, 8, 5);
INSERT INTO `component_related_type` VALUES (9, 9, 4);
INSERT INTO `component_related_type` VALUES (10, 10, 7);
INSERT INTO `component_related_type` VALUES (11, 11, 5);
INSERT INTO `component_related_type` VALUES (12, 12, 4);
INSERT INTO `component_related_type` VALUES (13, 13, 7);
INSERT INTO `component_related_type` VALUES (17, 38, 8);
INSERT INTO `component_related_type` VALUES (18, 39, 9);
INSERT INTO `component_related_type` VALUES (19, 40, 10);
INSERT INTO `component_related_type` VALUES (20, 41, 11);
INSERT INTO `component_related_type` VALUES (21, 42, 12);
INSERT INTO `component_related_type` VALUES (22, 43, 10);
INSERT INTO `component_related_type` VALUES (23, 44, 10);
INSERT INTO `component_related_type` VALUES (24, 45, 8);
INSERT INTO `component_related_type` VALUES (25, 46, 8);
INSERT INTO `component_related_type` VALUES (26, 47, 10);
INSERT INTO `component_related_type` VALUES (27, 48, 11);
INSERT INTO `component_related_type` VALUES (28, 49, 10);
INSERT INTO `component_related_type` VALUES (29, 50, 11);
INSERT INTO `component_related_type` VALUES (30, 45, 7);
INSERT INTO `component_related_type` VALUES (31, 45, 7);
INSERT INTO `component_related_type` VALUES (32, 46, 5);
INSERT INTO `component_related_type` VALUES (33, 46, 4);
INSERT INTO `component_related_type` VALUES (34, 51, 8);
INSERT INTO `component_related_type` VALUES (35, 51, 7);
INSERT INTO `component_related_type` VALUES (36, 52, 9);

-- ----------------------------
-- Table structure for component_type
-- ----------------------------
DROP TABLE IF EXISTS `component_type`;
CREATE TABLE `component_type`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_level` int(3) NULL DEFAULT NULL,
  `type_creat_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_creator` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_status` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of component_type
-- ----------------------------
INSERT INTO `component_type` VALUES (1, '用户界面', 1, '2020/03/04', 'pd', 1);
INSERT INTO `component_type` VALUES (2, '3D', 1, '2020/03/04', 'pd', 1);
INSERT INTO `component_type` VALUES (3, '其他', 1, '2020/03/04', 'pd', 1);
INSERT INTO `component_type` VALUES (4, '动画', 2, '2020/03/04', 'pd', 1);
INSERT INTO `component_type` VALUES (5, '背景', 2, '2020/03/04', 'pd', 1);
INSERT INTO `component_type` VALUES (6, '杂项', 2, '2020/03/05', 'pd', 1);
INSERT INTO `component_type` VALUES (7, '按钮', 2, '2020/03/05', 'pd', 1);
INSERT INTO `component_type` VALUES (8, '输入框', 2, '2020/03/05', 'pd', 1);
INSERT INTO `component_type` VALUES (9, '标签', 3, '2020/03/05', 'pd', 1);
INSERT INTO `component_type` VALUES (10, '列表', 3, '2020/03/05', 'pd', 1);
INSERT INTO `component_type` VALUES (11, '下拉选', 3, '2020/03/05', 'pd', 1);
INSERT INTO `component_type` VALUES (12, '选择框', 3, '2020/03/05', 'pd', 1);

-- ----------------------------
-- Table structure for component_type_level
-- ----------------------------
DROP TABLE IF EXISTS `component_type_level`;
CREATE TABLE `component_type_level`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `father_id` int(5) NULL DEFAULT NULL,
  `son_id` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of component_type_level
-- ----------------------------
INSERT INTO `component_type_level` VALUES (1, 1, 5);
INSERT INTO `component_type_level` VALUES (2, 2, 4);
INSERT INTO `component_type_level` VALUES (3, 1, 7);
INSERT INTO `component_type_level` VALUES (4, 3, 6);
INSERT INTO `component_type_level` VALUES (5, 6, 9);
INSERT INTO `component_type_level` VALUES (6, 6, 10);
INSERT INTO `component_type_level` VALUES (7, 6, 11);
INSERT INTO `component_type_level` VALUES (8, 6, 12);
INSERT INTO `component_type_level` VALUES (9, 1, 8);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role` VALUES (2, 'ROLE_MANAGER');
INSERT INTO `role` VALUES (3, 'ROLE_USER');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) NULL DEFAULT NULL,
  `role_id` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES (1, 1, 3);
INSERT INTO `role_user` VALUES (2, 1, 2);
INSERT INTO `role_user` VALUES (3, 2, 1);
INSERT INTO `role_user` VALUES (4, 2, 2);
INSERT INTO `role_user` VALUES (5, 2, 3);
INSERT INTO `role_user` VALUES (6, 3, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `job` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  `roles` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'pd1', '1', 22, 'java', '97', '$2a$10$/WORX1RQqGO1qnEHrwZAauBWzvLkKxEALlVRpU7mdqQUV81emOwFq', 1, NULL);
INSERT INTO `user` VALUES (2, 'pd2', '1', 23, 'c++', '96', '$2a$10$/WORX1RQqGO1qnEHrwZAauBWzvLkKxEALlVRpU7mdqQUV81emOwFq', 1, NULL);
INSERT INTO `user` VALUES (3, 'pd3', '1', 21, 'python', '98', '$2a$10$PCCbDpvEL0vM9vbFnwB5w.r8rtJ18gE0fIHsoieVJG3UktCLoIiQK', 1, NULL);
INSERT INTO `user` VALUES (4, 'pd4', '0', NULL, NULL, NULL, '$2a$10$/WORX1RQqGO1qnEHrwZAauBWzvLkKxEALlVRpU7mdqQUV81emOwFq', 1, NULL);
INSERT INTO `user` VALUES (5, 'pd5', '0', NULL, NULL, NULL, '$10$/WORX1RQqGO1qnEHrwZAauBWzvLkKxEALlVRpU7mdqQUV81emOwFq', 1, NULL);
INSERT INTO `user` VALUES (14, 'pd6', NULL, NULL, NULL, NULL, '$2a$10$6v2OrL86HZKff/IXRPB6AegGu21cGs6VUoTbNSmbuzPuXnAlqLO.O', 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
