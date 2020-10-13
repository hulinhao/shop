package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.JcProduct;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 商品Mapper接口
 * 
 * @author linhao Hu
 * @date 2020-10-12
 */
public interface JcProductMapper extends Mapper<JcProduct>
{

    @Select("SELECT * from jc_product where id = #{id}")
    JcProduct getJcProductById(Long id);


    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    public JcProduct selectJcProductById(Long id);

    /**
     * 查询商品列表
     * 
     * @param jcProduct 商品
     * @return 商品集合
     */
    public List<JcProduct> selectJcProductList(JcProduct jcProduct);

    /**
     * 新增商品
     * 
     * @param jcProduct 商品
     * @return 结果
     */
    public int insertJcProduct(JcProduct jcProduct);

    /**
     * 修改商品
     * 
     * @param jcProduct 商品
     * @return 结果
     */
    public int updateJcProduct(JcProduct jcProduct);

    /**
     * 删除商品
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteJcProductById(Long id);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcProductByIds(String[] ids);
}
