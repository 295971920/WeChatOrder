package cn.xiaoshan.converter;

import cn.xiaoshan.dataobject.OrderDetail;
import cn.xiaoshan.dto.OrderDTO;
import cn.xiaoshan.enums.ResultEnum;
import cn.xiaoshan.exception.SellException;
import cn.xiaoshan.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/20 18:31
 * @Description :OrderFrom转OrderDTO
 **/
@Slf4j
public class OrderFrom2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailsList = new ArrayList<>();
        /**
         * 使用try...catch捕获转化失败异常
         * idea使用try...catch快捷键Ctrl + Alt + T
         */
        try {
            orderDetailsList = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (JsonSyntaxException e) {
            log.error("[对象转换] 错误, string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailsList);
        return orderDTO;
    }
}
