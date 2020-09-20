package cn.xiaoshan.controller;

import cn.xiaoshan.VO.ResultVO;
import cn.xiaoshan.converter.OrderFrom2OrderDTOConverter;
import cn.xiaoshan.dto.OrderDTO;
import cn.xiaoshan.enums.ResultEnum;
import cn.xiaoshan.exception.SellException;
import cn.xiaoshan.form.OrderForm;
import cn.xiaoshan.service.OrderService;
import cn.xiaoshan.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/20 18:00
 * @Description : 买家商品
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderControllor {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @Valid+BindingResult进行controller参数校验
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String ,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("[创建订单] 参数不正确,orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                            bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderFrom2OrderDTOConverter.convert(orderForm);
        log.info("debug......."+orderDTO.getOrderId());
        //判断购物车是否为空
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单] 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);

        HashMap<String, String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表

    //订单详情

    //取消订单

}
