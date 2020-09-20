/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : sell

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 20/09/2020 08:27:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '商品当前价格，单位分',
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `product_icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品小图',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updata_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1234567810', '123456', '11111113', '鸡翅', 2.20, 3, 'http://xxxx.jpg', '2020-09-17 22:00:04', '2020-09-20 04:44:15');
INSERT INTO `order_detail` VALUES ('12345678910', '123456', '11111113', '皮蛋粥', 2.20, 3, 'http://xxxx.jpg', '2020-09-17 22:07:17', '2020-09-18 05:59:21');
INSERT INTO `order_detail` VALUES ('1600561041887104170', '1600561041840836688', '123457', '皮皮虾', 3.20, 1, 'http://xxxxx.jpg', '2020-09-20 08:17:21', '2020-09-20 08:17:21');
INSERT INTO `order_detail` VALUES ('1600561041904887067', '1600561041840836688', '1234578', '鸡公煲', 3.20, 2, 'http://xxxxx.jpg', '2020-09-20 08:17:21', '2020-09-20 08:17:21');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '订单状态，默认为新订单',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '订单状态，默认未支付',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `idx_buyer_openid`(`buyer_openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1234567', '师兄', '123456789123', '幕课网', '110110', 2.50, 0, 0, '2020-09-17 21:53:29', '2020-09-17 21:53:29');
INSERT INTO `order_master` VALUES ('12345678', '师妹', '123456789123', '幕课网', '110110', 2.50, 0, 0, '2020-09-17 22:16:29', '2020-09-19 21:00:54');
INSERT INTO `order_master` VALUES ('123456789', '师弟', '123456789123', '幕课网', '110110', 2.50, 0, 0, '2020-09-19 21:00:07', '2020-09-19 21:00:45');
INSERT INTO `order_master` VALUES ('1600561041840836688', '陈一山', '18813960381', '慕课网', '110110', 9.60, 0, 0, '2020-09-20 08:17:21', '2020-09-20 08:17:21');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, '陈一山', 2, '2020-09-02 11:56:45', '2020-09-13 21:16:16');
INSERT INTO `product_category` VALUES (2, '女生最爱', 3, '2020-09-03 22:55:38', '2020-09-13 21:18:00');
INSERT INTO `product_category` VALUES (7, '少女最爱', 4, '2020-09-12 23:43:28', '2020-09-13 21:17:57');
INSERT INTO `product_category` VALUES (9, '手机', 5, '2020-09-13 07:26:43', '2020-09-13 21:16:53');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小图',
  `product_status` int(11) NOT NULL COMMENT '状态, 0正常 1下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('123456', '皮蛋粥', 3.20, 100, '很好喝的粥', 'http://xxxx.png', 0, 2, '2020-09-13 08:02:46', '2020-09-13 08:02:46');
INSERT INTO `product_info` VALUES ('123457', '皮皮虾', 3.20, 97, '很好吃的虾', 'http://xxxxx.jpg', 0, 3, '2020-09-07 22:45:09', '2020-09-20 08:17:21');
INSERT INTO `product_info` VALUES ('1234578', '鸡公煲', 3.20, 98, '很好吃的鸡公煲', 'http://xxxxx.jpg', 1, 4, '2020-09-13 09:37:55', '2020-09-20 08:17:21');
INSERT INTO `product_info` VALUES ('456789', '皮蛋廋肉粥', 3.20, 100, '很好喝的粥', 'http://xxxxx.jpg', 0, 5, '2020-09-07 22:19:17', '2020-09-13 21:16:48');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info`  (
  `seller_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `PASSWORD` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `openid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '微信openid',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`seller_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '卖家信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seller_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
