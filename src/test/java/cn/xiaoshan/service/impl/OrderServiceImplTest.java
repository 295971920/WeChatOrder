package cn.xiaoshan.service.impl;

import cn.xiaoshan.dataobject.OrderDetail;
import cn.xiaoshan.dto.OrderDTO;
import cn.xiaoshan.enums.OrderStatusEnum;
import cn.xiaoshan.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/18 17:40
 * @Description :
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1600572381324274346";

    /**
     * 创建订单
     * @throws Exception
     */
    @Test
    public void create() throws Exception {

        //买家信息
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("陈一山");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("18813960381");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        //保证setProductId在数据库中存在，否则报错
        o1.setProductId("1234567");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("12345678");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
        Assert.assertNotNull(result);
    }

    /**
     * 查询订单
     * @throws Exception
     */
    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[查询单个订单 result={}]",result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    /**
     * 分页查询
     * @throws Exception
     */
    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0,orderDTOPage);
    }

    /**
     * 订单取消
     * @throws Exception
     */
    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        //判断取消前后订单状态是否相同
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    /**
     * 完结订单
     * order_status: 0为新订单，1为完结，2为取消
     * @throws Exception
     */
    @Test
    public void finish() throws Exception {
        //确保ORDER_ID能在order_master表中找到
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        //确保orderMaster订单中orderStatus为0
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    /**
     * 支付状态
     * 测试前请保证订单为新订单
     * pay_status: WAIT(0,"等待支付"),SUCCESS(1,"支付成功"),
     * @throws Exception
     */
    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}