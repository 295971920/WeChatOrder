package cn.xiaoshan.service;

import cn.xiaoshan.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/17 22:47
 * @Description : 订单
 **/
public interface OrderService {
    /*创建订单*/
    OrderDTO create(OrderDTO orderDTO);
    /*查询单个订单*/
    OrderDTO findOne(String orderId);
    /*查询订单列表  注意使用分页查询*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    /*取消订单*/
    OrderDTO cancel(OrderDTO orderDto);
    /*完结订单*/
    OrderDTO finish(OrderDTO orderDTO);
    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);
}
