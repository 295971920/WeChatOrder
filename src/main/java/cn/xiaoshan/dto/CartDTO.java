package cn.xiaoshan.dto;

import lombok.Data;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/18 12:18
 * @Description :购物车
 **/
@Data
public class CartDTO {
    /*商品Id*/
    private String productId;

    /*数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
