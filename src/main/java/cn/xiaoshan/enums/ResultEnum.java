package cn.xiaoshan.enums;

import lombok.Getter;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/18 6:24
 * @Description : 错误异常处理
 **/
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ;

    private Integer code;
    private String massage;

    ResultEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }
}
