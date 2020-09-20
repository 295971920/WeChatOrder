package cn.xiaoshan.dataobject;

import cn.xiaoshan.enums.OrderStatusEnum;
import cn.xiaoshan.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/15 21:08
 * @Description :  订单表
 **/
@Entity
@DynamicUpdate
@Data
public class OrderMaster {
    /** 订单id. */
    @Id
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0 新下单. */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态, 默认为0 未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    /*未使用DTO 避免字段与数据库不对应报错，使用@Transient声明忽略掉，但注意导包是import javax.persistence.Transient;*/
//    @Transient
//    private List<OrderDetail> orderDetailList;
}
