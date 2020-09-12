package cn.xiaoshan.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/12 22:03
 * @Description :类目
 * @DynamicUpdate: 动态更新时间
 **/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

   /**通过@Id标明为主键*/
    @Id
    /* @GeneratedValue为一个实体生成一个唯一标识的主键，主键由数据库生成, 采用数据库自增长*/
    @GeneratedValue
    /** 类目id*/
    private Integer categoryId;
    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 空参构造函数*/
    public ProductCategory() {
    }

    /**
     * 带参构造函数
     * @param categoryName
     * @param categoryType
     */
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
