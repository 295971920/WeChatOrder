package cn.xiaoshan.service.impl;

import cn.xiaoshan.converter.OrderMaster2OrderDTOConverter;
import cn.xiaoshan.dataobject.OrderDetail;
import cn.xiaoshan.dataobject.OrderMaster;
import cn.xiaoshan.dataobject.ProductInfo;
import cn.xiaoshan.dto.CartDTO;
import cn.xiaoshan.dto.OrderDTO;
import cn.xiaoshan.enums.OrderStatusEnum;
import cn.xiaoshan.enums.PayStatusEnum;
import cn.xiaoshan.enums.ResultEnum;
import cn.xiaoshan.exception.SellException;
import cn.xiaoshan.repository.OrderDetailRepository;
import cn.xiaoshan.repository.OrderMasterRepository;
import cn.xiaoshan.service.OrderService;
import cn.xiaoshan.service.ProductService;
import cn.xiaoshan.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/18 5:56
 * @Description :
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //初始化订单
        String orderId = KeyUtil.getUniqueKey();
        //初始化总价为零
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
//        List<CartDTO> cartDTOList = new ArrayList<>();
        //1、查询商品（数量，价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2、计算总价
           orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
           .add(orderAmount);
            
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

//            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
        }

        //3、写入订单数据库（OrderMaster和OrderDetail）
        OrderMaster orderMaster = new OrderMaster();
        //注意拷贝数据容易覆盖原有数据，需要手动重新设置回去
        BeanUtils.copyProperties(orderDTO,orderMaster);
        //手动设置
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4、扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList()
                .stream().map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        //传入查询Id
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        //判断订单是否存在
        if (orderMaster == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        //订单详情
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        //判断orderDetailList集合不为空
        if (CollectionUtils.isEmpty(orderDetailList)){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable)  {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid,pageable);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());
        return new PageImpl<OrderDTO>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDto) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
