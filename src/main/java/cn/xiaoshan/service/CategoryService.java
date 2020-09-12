package cn.xiaoshan.service;

import cn.xiaoshan.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/13 0:34
 * @Description : 类目
 **/
public interface CategoryService {
    /**
     * 根据Id查询
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据类型查询
     * @param categoryList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);

    /**
     * 根据对象保存
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
