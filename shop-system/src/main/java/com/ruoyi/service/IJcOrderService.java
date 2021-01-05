package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.JcOrder;

/**
 * 订单管理Service接口
 * 
 * @author hlinhao Hu
 * @date 2021-01-05
 */
public interface IJcOrderService 
{
    /**
     * 查询订单管理
     * 
     * @param id 订单管理ID
     * @return 订单管理
     */
    public JcOrder selectJcOrderById(Long id);

    /**
     * 查询订单管理列表
     * 
     * @param jcOrder 订单管理
     * @return 订单管理集合
     */
    public List<JcOrder> selectJcOrderList(JcOrder jcOrder);

    /**
     * 新增订单管理
     * 
     * @param jcOrder 订单管理
     * @return 结果
     */
    public int insertJcOrder(JcOrder jcOrder);

    /**
     * 修改订单管理
     * 
     * @param jcOrder 订单管理
     * @return 结果
     */
    public int updateJcOrder(JcOrder jcOrder);

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcOrderByIds(String ids);

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理ID
     * @return 结果
     */
    public int deleteJcOrderById(Long id);
}
