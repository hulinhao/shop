/*
Navicat MySQL Data Transfer

Source Server         : 106.14.93.187_test
Source Server Version : 50648
Source Host           : 106.14.93.187:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-07-31 16:15:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sp_product`
-- ----------------------------
DROP TABLE IF EXISTS `sp_product`;
CREATE TABLE `sp_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_id` int(11) DEFAULT NULL COMMENT '商品卡片表 主键',
  `user_id` int(11) DEFAULT NULL COMMENT '添加人id',
  `label_id` varchar(10) DEFAULT NULL COMMENT '商品标签（product_label表主键）',
  `image_id` varchar(10) DEFAULT NULL COMMENT '照片（producct_image主键）',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of sp_product
-- ----------------------------
INSERT INTO `sp_product` VALUES ('1', '1', '1', '1,2,3,4,5', '1', '2019-08-12 17:06:44', '2019-08-12 17:06:46');

-- ----------------------------
-- Table structure for `sp_product_attr`
-- ----------------------------
DROP TABLE IF EXISTS `sp_product_attr`;
CREATE TABLE `sp_product_attr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_name` varchar(30) DEFAULT NULL COMMENT '属性名称',
  `attr_describe` varchar(255) DEFAULT NULL COMMENT '属性描述',
  `user_id` int(11) DEFAULT NULL COMMENT '添加人id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品属性表--  用于定义商品的各种属性（名称，大小，简介.......）';

-- ----------------------------
-- Records of sp_product_attr
-- ----------------------------
INSERT INTO `sp_product_attr` VALUES ('1', '名称', '商品名称', '1', '2019-08-12 17:08:39', '2019-08-12 17:08:42');
INSERT INTO `sp_product_attr` VALUES ('2', '作者', '作者', '1', '2019-08-12 17:09:16', '2019-08-12 17:09:19');
INSERT INTO `sp_product_attr` VALUES ('3', '豆瓣评分', '来自豆瓣的评分', '1', '2019-08-12 17:10:13', '2019-08-12 17:10:16');
INSERT INTO `sp_product_attr` VALUES ('5', '价格', '价格', '1', '2019-08-12 17:11:12', '2019-08-12 17:11:14');
INSERT INTO `sp_product_attr` VALUES ('6', '折扣价', '折扣价', '1', '2019-08-12 17:11:42', '2019-08-12 17:11:45');

-- ----------------------------
-- Table structure for `sp_product_card`
-- ----------------------------
DROP TABLE IF EXISTS `sp_product_card`;
CREATE TABLE `sp_product_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_name` varchar(20) DEFAULT NULL COMMENT '商品展示-个性卡片   的自定义名称',
  `describer` varchar(255) DEFAULT NULL COMMENT '卡片描述',
  `category_id` int(11) DEFAULT NULL COMMENT '商品类型id(product_category表主键)',
  `show_attr` varchar(50) DEFAULT NULL COMMENT '页面展示属性 product_attr表主键 ',
  `hid_attr` varchar(50) DEFAULT NULL COMMENT '隐藏属性 product_attr表主键',
  `user_id` int(11) DEFAULT NULL COMMENT '卡片制作人 id ',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品卡片表 - 用于定义商品展示的属性   展示方式   展示时间等';

-- ----------------------------
-- Records of sp_product_card
-- ----------------------------
INSERT INTO `sp_product_card` VALUES ('1', '我的卡片', '测试卡片', '1', '1,2,3', '5,6', '1', '2019-08-12 17:07:43', '2019-08-12 17:07:45');

-- ----------------------------
-- Table structure for `sp_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `sp_product_category`;
CREATE TABLE `sp_product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) DEFAULT NULL COMMENT '种类名称',
  `type` int(11) DEFAULT NULL COMMENT '类型 0：新添加   1：非新添加',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品种类表';

-- ----------------------------
-- Records of sp_product_category
-- ----------------------------
INSERT INTO `sp_product_category` VALUES ('1', '古典小说', '0', '2019-08-12 15:31:02', '2019-08-12 15:31:04');
INSERT INTO `sp_product_category` VALUES ('2', '高评分', '1', '2019-08-12 15:31:22', '2019-08-12 15:31:25');
INSERT INTO `sp_product_category` VALUES ('3', '少儿文学', '1', '2019-08-12 15:31:37', '2019-08-12 15:31:40');
INSERT INTO `sp_product_category` VALUES ('4', '名著', '1', '2019-08-12 15:31:54', '2019-08-12 15:31:56');
INSERT INTO `sp_product_category` VALUES ('5', '外国文学', '1', '2019-08-12 15:32:11', '2019-08-12 15:32:13');

-- ----------------------------
-- Table structure for `sp_product_image`
-- ----------------------------
DROP TABLE IF EXISTS `sp_product_image`;
CREATE TABLE `sp_product_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(100) DEFAULT NULL COMMENT '照片地址',
  `img_size` varchar(100) DEFAULT NULL COMMENT '照片尺寸',
  `type` varchar(255) DEFAULT NULL COMMENT '照片类型',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- ----------------------------
-- Records of sp_product_image
-- ----------------------------
INSERT INTO `sp_product_image` VALUES ('1', 'static/pic/p1.jpeg', '50*50', '1', '2019-08-12 17:14:01', '2019-08-12 17:14:03');

-- ----------------------------
-- Table structure for `sp_product_label`
-- ----------------------------
DROP TABLE IF EXISTS `sp_product_label`;
CREATE TABLE `sp_product_label` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tag` varchar(30) DEFAULT NULL COMMENT '标签名称',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品标签';

-- ----------------------------
-- Records of sp_product_label
-- ----------------------------
INSERT INTO `sp_product_label` VALUES ('1', '中国文学', '2019-08-12 15:34:58');
INSERT INTO `sp_product_label` VALUES ('2', '武侠', '2019-08-12 15:35:06');
INSERT INTO `sp_product_label` VALUES ('3', '金庸', '2019-08-12 15:35:19');
INSERT INTO `sp_product_label` VALUES ('4', '现实主义', '2019-08-12 15:35:31');
INSERT INTO `sp_product_label` VALUES ('5', '教育', '2019-08-12 15:35:39');

-- ----------------------------
-- Table structure for `sp_product_param`
-- ----------------------------
DROP TABLE IF EXISTS `sp_product_param`;
CREATE TABLE `sp_product_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_id` int(11) DEFAULT NULL COMMENT '属性表id',
  `attr_value` varchar(255) DEFAULT NULL COMMENT '属性值',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商品参数表  对应商品属性表说';

-- ----------------------------
-- Records of sp_product_param
-- ----------------------------
INSERT INTO `sp_product_param` VALUES ('1', '1', '平凡的世界', '1', '2019-08-12 17:16:16', '2019-08-12 17:16:18');
INSERT INTO `sp_product_param` VALUES ('2', '2', '路遥', '1', '2019-08-12 17:16:58', '2019-08-12 17:17:01');
INSERT INTO `sp_product_param` VALUES ('3', '3', '9.7', '1', '2019-08-12 17:17:18', '2019-08-12 17:17:21');
INSERT INTO `sp_product_param` VALUES ('4', '4', '1,3,4', '1', '2019-08-12 17:17:36', '2019-08-12 17:17:24');
INSERT INTO `sp_product_param` VALUES ('5', '5', '75.50', '1', '2019-08-12 17:17:40', '2019-08-12 17:17:27');
INSERT INTO `sp_product_param` VALUES ('6', '6', '55.00', '1', '2019-08-12 17:17:43', '2019-08-12 17:17:30');
INSERT INTO `sp_product_param` VALUES ('7', '7', '1,2,3', '1', '2019-08-12 17:17:48', '2019-08-12 17:17:33');
