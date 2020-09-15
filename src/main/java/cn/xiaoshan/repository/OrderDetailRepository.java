package cn.xiaoshan.repository;

import cn.xiaoshan.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/15 23:11
 * @Description :
 **/
public interface OrderDetailRepository extends JpaRepository <OrderDetail,String> {

    /**
     * 根据订单Id查询
     * @param orderId
     * @return
     */
   List<OrderDetail> findByOrderId(String orderId);
}
