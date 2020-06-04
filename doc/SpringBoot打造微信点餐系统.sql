/*
 Navicat Premium Data Transfer

 Source Server         : Local_VM
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : xiaoshan.cn:3306
 Source Schema         : sell
 字符集		       ：utf8mb4
 排序规则	       ：utf8mb4_general_ci

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 31/05/2020 22:29:11
*/

-- 商品表
DROP TABLE IF EXISTS product_info;
CREATE TABLE product_info (
product_id VARCHAR(32) NOT NULL,
product_name VARCHAR(64) NOT NULL COMMENT '商品名称',
product_price DECIMAL(8,2) NOT NULL COMMENT '单价',
product_stock INT NOT NULL COMMENT '库存',
product_description VARCHAR(64) COMMENT '描述',
product_icon VARCHAR(512) COMMENT '小图',
category_type INT NOT NULL COMMENT '类目编号',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY (product_id)
) COMMENT '商品表';

-- 类目表 保持类目编号唯一性
DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category (
category_id INT NOT NULL AUTO_INCREMENT,
category_name VARCHAR(64) NOT NULL COMMENT '类目名字',
category_type INT NOT NULL COMMENT '类目编号',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY (category_id),
UNIQUE KEY uqe_category_type (category_type)
) COMMENT '类目表';

-- 订单表
DROP TABLE IF EXISTS order_master;
CREATE TABLE order_master (
order_id VARCHAR(32) NOT NULL,
buyer_name VARCHAR(32) NOT NULL COMMENT '买家名字',
buyer_phone VARCHAR(32) NOT NULL COMMENT '买家电话',
buyer_address VARCHAR(128) NOT NULL COMMENT '买家地址',
buyer_openid VARCHAR(64) NOT NULL COMMENT '买家微信openid',
order_amount DECIMAL(8,2) NOT NULL COMMENT '订单总金额',
order_status TINYINT(3) NOT NULL DEFAULT '0' COMMENT '订单状态，默认为新订单',
pay_status TINYINT(3) NOT NULL DEFAULT '0' COMMENT '订单状态，默认未支付',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY (order_id),
KEY idx_buyer_openid (buyer_openid)
)COMMENT '订单表';


-- 订单详情表
DROP TABLE IF EXISTS order_detail;
CREATE TABLE order_detail (
detail_id VARCHAR(32) NOT NULL,
order_id VARCHAR(32) NOT NULL ,
product_id VARCHAR(32) NOT NULL,
product_name VARCHAR(64) NOT NULL COMMENT '商品名称',
product_price DECIMAL(8,2) NOT NULL COMMENT '商品当前价格，单位分',
product_quantity INT NOT NULL COMMENT '商品数量',
product_icon VARCHAR(32) COMMENT '商品小图',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
updata_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY (detail_id),
KEY idx_order_id (order_id)
)COMMENT '订单商品';

-- 卖家信息表(登陆后台使用，卖家登陆之后可能直接使用微信扫码登陆，不使用账号密码)
DROP TABLE IF EXISTS seller_info;
CREATE TABLE seller_info (
seller_id VARCHAR(32) NOT NULL ,
username VARCHAR(32) NOT NULL ,
PASSWORD VARCHAR(32) NOT NULL ,
openid VARCHAR(64) NOT NULL COMMENT '微信openid',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY (seller_id)
)COMMENT '卖家信息表';


















