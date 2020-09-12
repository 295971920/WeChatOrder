package cn.xiaoshan.repository;

import cn.xiaoshan.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/12 22:16
 * @Description :类目查询接口
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    /**
     * 根据category_type查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 根据category_id查询
     * @param categoryIdList
     * @return
     */
    List<ProductCategory> findByCategoryIdIn(List<Integer> categoryIdList);
}

