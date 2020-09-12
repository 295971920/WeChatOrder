package cn.xiaoshan.repository;

import cn.xiaoshan.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/12 22:23
 * @Description :类目测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 预期与数据库product_category表中数据Id对应
     */
    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory);
    }

    /**
     * 预期与数据库product_category表中所有数据
     */
    @Test
    public void findAllTest() {
        List<ProductCategory> productCategoryList = repository.findAll();
        System.out.println(productCategoryList);
    }

    /**
     * 预期插入数据到product_category表，但前提保证id不存在
     * */
    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("老人最爱",3);
        ProductCategory result = repository.save(productCategory);
        //判断是否不为空
        Assert.assertNotNull(result);
        //判断是否不相等
        Assert.assertNotEquals(null,result);
    }

    /*根据category_id 更新数据*/
    @Test
    public void updateTest(){
        ProductCategory productCategory = repository.findOne(7);
        productCategory.setCategoryName("少女最爱");
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    /**
     * 根据category_type查询
     */
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(5, 3, 4);
        //调用接口
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        System.out.println(result);
        Assert.assertNotEquals(0,result.size());
    }

    /*根据category_id查询*/
    @Test
    public void findByCategoryIdInTest(){
        List<Integer> list = Arrays.asList(1,3,5);
        List<ProductCategory> result = repository.findByCategoryIdIn(list);
        System.out.println(result);
        Assert.assertNotEquals(0,result.size());
    }


    /**
     * 根据Id删除
     */
    @Test
    public void DeleteTest(){
        repository.delete(6);
    }
}