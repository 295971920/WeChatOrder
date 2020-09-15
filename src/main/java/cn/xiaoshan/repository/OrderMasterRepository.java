package cn.xiaoshan.repository;

import cn.xiaoshan.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/15 22:58
 * @Description : 订单表Dao
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{

    /**
     * 根据买家openid查询订单
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
