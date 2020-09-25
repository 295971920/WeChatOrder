package cn.xiaoshan.dto;

import cn.xiaoshan.dataobject.OrderDetail;
import cn.xiaoshan.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/17 22:59
 * @Description :
 **/
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) 被废弃，使用下面新方法
//@JsonInclude(JsonInclude.Include.NON_NULL)  全局可使用配置：jackson: default-property-inclusion: non_null
public class OrderDTO {
    /**
     * 订单id.
     */
    private String orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家手机号.
     */
    private String buyerPhone;

    /**
     * 买家地址.
     */
    private String buyerAddress;

    /**
     * 买家微信Openid.
     */
    private String buyerOpenid;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为0新下单.
     */
    private Integer orderStatus;

    /**
     * 支付状态, 默认为0未支付.
     */
    private Integer payStatus;

    /**
     * 创建时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间.
     * ms转换为s，就需要将ms/1000
     * 使用注解方式调用工具类快速解决
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    //设置返回空值时显示为[]
    List<OrderDetail> orderDetailList = new ArrayList<>();

}