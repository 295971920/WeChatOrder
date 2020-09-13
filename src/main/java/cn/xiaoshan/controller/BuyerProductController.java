package cn.xiaoshan.controller;

import cn.xiaoshan.VO.ProductInfoVO;
import cn.xiaoshan.VO.ProductVO;
import cn.xiaoshan.VO.ResultVO;
import cn.xiaoshan.service.CategoryService;
import cn.xiaoshan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/13 13:13
 * @Description : 买家商品
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO getList(){
        ResultVO resultVO = new ResultVO();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();

        productVO.setCategoryName("热榜");
        productVO.setCategoryType(1);
        productInfoVO.setProductId("21348");
        productInfoVO.setProductName("皮皮虾");
        productInfoVO.setProductPrice(new BigDecimal(3.2));
        productInfoVO.setProductIcon("http://xxxx.png");
        productInfoVO.setProductDescription("非常好吃");

        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(Arrays.asList(productVO));

        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}