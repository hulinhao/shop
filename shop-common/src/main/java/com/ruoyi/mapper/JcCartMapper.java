package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.JcCart;
import tk.mybatis.mapper.common.Mapper;

/**
 * 购物车Mapper接口
 *
 * @author hlinhao Hu
 * @date 2020-11-04
 */
public interface JcCartMapper
{
    /**
     * 查询购物车
     *
     * @param id 购物车ID
     * @return 购物车
     */
    public JcCart selectJcCartById(Long id);

    /**
     * 查询购物车列表
     *
     * @param jcCart 购物车
     * @return 购物车集合
     */
    public List<JcCart> selectJcCartList(JcCart jcCart);

    /**
     * 新增购物车
     *
     * @param jcCart 购物车
     * @return 结果
     */
    public int insertJcCart(JcCart jcCart);

    /**
     * 修改购物车
     *
     * @param jcCart 购物车
     * @return 结果
     */
    public int updateJcCart(JcCart jcCart);

    /**
     * 删除购物车
     *
     * @param id 购物车ID
     * @return 结果
     */
    public int deleteJcCartById(Long id);

    /**
     * 批量删除购物车
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcCartByIds(String[] ids);
}
