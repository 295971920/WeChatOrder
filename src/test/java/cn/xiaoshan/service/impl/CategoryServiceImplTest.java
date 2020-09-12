package cn.xiaoshan.service.impl;

import cn.xiaoshan.dataobject.ProductCategory;
import cn.xiaoshan.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/13 7:02
 * @Description :
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * 根据Id查询
     * @throws Exception
     */
    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(2);
        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    /**
     * 查询所有
     * @throws Exception
     */
    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        //断言 查询结果长度不为0
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    /**
     * 根据类目查询
     * @throws Exception
     */
    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    /**
     * 插入数据
     * @throws Exception
     */
    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("手机",9);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }

}