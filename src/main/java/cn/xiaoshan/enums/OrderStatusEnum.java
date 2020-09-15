package cn.xiaoshan.enums;

import lombok.Getter;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/15 21:10
 * @Description : 枚举订单状态
 **/
@Getter
public enum OrderStatusEnum {
    NEW (0,"新订单"),
    FINISHED (1,"完结"),
    CANCEL (2,"已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
