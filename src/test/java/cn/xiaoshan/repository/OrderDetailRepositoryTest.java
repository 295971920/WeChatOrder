package cn.xiaoshan.repository;

import cn.xiaoshan.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/17 21:57
 * @Description :
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345678910");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("11111113");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("11111112");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}