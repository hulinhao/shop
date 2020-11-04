package com.ruoyi.mapper;

import java.util.List;


import com.ruoyi.domain.JcProductAttr;
import tk.mybatis.mapper.common.Mapper;

/**
 * 商品属性Mapper接口
 *
 * @author hlinhao Hu
 * @date 2020-11-04
 */
public interface JcProductAttrMapper  extends Mapper<JcProductAttr>
{
    /**
     * 查询商品属性
     *
     * @param id 商品属性ID
     * @return 商品属性
     */
    public JcProductAttr selectJcProductAttrById(Long id);

    /**
     * 查询商品属性列表
     *
     * @param jcProductAttr 商品属性
     * @return 商品属性集合
     */
    public List<JcProductAttr> selectJcProductAttrList(JcProductAttr jcProductAttr);

    /**
     * 新增商品属性
     *
     * @param jcProductAttr 商品属性
     * @return 结果
     */
    public int insertJcProductAttr(JcProductAttr jcProductAttr);

    /**
     * 修改商品属性
     *
     * @param jcProductAttr 商品属性
     * @return 结果
     */
    public int updateJcProductAttr(JcProductAttr jcProductAttr);

    /**
     * 删除商品属性
     *
     * @param id 商品属性ID
     * @return 结果
     */
    public int deleteJcProductAttrById(Long id);

    /**
     * 批量删除商品属性
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcProductAttrByIds(String[] ids);
}
