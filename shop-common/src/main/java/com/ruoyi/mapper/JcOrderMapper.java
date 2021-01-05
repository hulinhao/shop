package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.JcOrder;
import com.ruoyi.domain.JcOrderDetail;

/**
 * 订单管理Mapper接口
 * 
 * @author hlinhao Hu
 * @date 2021-01-05
 */
public interface JcOrderMapper 
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
     * 删除订单管理
     * 
     * @param id 订单管理ID
     * @return 结果
     */
    public int deleteJcOrderById(Long id);

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcOrderByIds(String[] ids);

    /**
     * 批量删除订单详情
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcOrderDetailByOrderIds(String[] ids);
    
    /**
     * 批量新增订单详情
     * 
     * @param jcOrderDetailList 订单详情列表
     * @return 结果
     */
    public int batchJcOrderDetail(List<JcOrderDetail> jcOrderDetailList);
    

    /**
     * 通过订单管理ID删除订单详情信息
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteJcOrderDetailByOrderId(Long id);
}
