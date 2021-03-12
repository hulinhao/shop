package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.JcOrderDetail;

/**
 * 订单详情Mapper接口
 *
 * @author hlinhao Hu
 * @date 2021-03-10
 */
public interface JcOrderDetailMapper
{
    /**
     * 查询订单详情
     *
     * @param id 订单详情ID
     * @return 订单详情
     */
    public JcOrderDetail selectJcOrderDetailById(Long id);

    /**
     * 查询订单详情列表
     *
     * @param jcOrderDetail 订单详情
     * @return 订单详情集合
     */
    public List<JcOrderDetail> selectJcOrderDetailList(JcOrderDetail jcOrderDetail);

    /**
     * 新增订单详情
     *
     * @param jcOrderDetail 订单详情
     * @return 结果
     */
    public int insertJcOrderDetail(JcOrderDetail jcOrderDetail);

    /**
     * 修改订单详情
     *
     * @param jcOrderDetail 订单详情
     * @return 结果
     */
    public int updateJcOrderDetail(JcOrderDetail jcOrderDetail);

    /**
     * 删除订单详情
     *
     * @param id 订单详情ID
     * @return 结果
     */
    public int deleteJcOrderDetailById(Long id);

    /**
     * 批量删除订单详情
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJcOrderDetailByIds(String[] ids);
}
