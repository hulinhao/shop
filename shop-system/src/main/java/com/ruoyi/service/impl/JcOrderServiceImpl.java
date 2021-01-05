package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.domain.JcOrderDetail;
import com.ruoyi.mapper.JcOrderMapper;
import com.ruoyi.domain.JcOrder;
import com.ruoyi.service.IJcOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单管理Service业务层处理
 * 
 * @author hlinhao Hu
 * @date 2021-01-05
 */
@Service
public class JcOrderServiceImpl implements IJcOrderService 
{
    @Autowired
    private JcOrderMapper jcOrderMapper;

    /**
     * 查询订单管理
     * 
     * @param id 订单管理ID
     * @return 订单管理
     */
    @Override
    public JcOrder selectJcOrderById(Long id)
    {
        return jcOrderMapper.selectJcOrderById(id);
    }

    /**
     * 查询订单管理列表
     * 
     * @param jcOrder 订单管理
     * @return 订单管理
     */
    @Override
    public List<JcOrder> selectJcOrderList(JcOrder jcOrder)
    {
        return jcOrderMapper.selectJcOrderList(jcOrder);
    }

    /**
     * 新增订单管理
     * 
     * @param jcOrder 订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertJcOrder(JcOrder jcOrder)
    {
        jcOrder.setCreateTime(DateUtils.getNowDate());
        int rows = jcOrderMapper.insertJcOrder(jcOrder);
        insertJcOrderDetail(jcOrder);
        return rows;
    }

    /**
     * 修改订单管理
     * 
     * @param jcOrder 订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateJcOrder(JcOrder jcOrder)
    {
        jcOrder.setUpdateTime(DateUtils.getNowDate());
        jcOrderMapper.deleteJcOrderDetailByOrderId(jcOrder.getId());
        insertJcOrderDetail(jcOrder);
        return jcOrderMapper.updateJcOrder(jcOrder);
    }

    /**
     * 删除订单管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteJcOrderByIds(String ids)
    {
        jcOrderMapper.deleteJcOrderDetailByOrderIds(Convert.toStrArray(ids));
        return jcOrderMapper.deleteJcOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理ID
     * @return 结果
     */
    @Override
    public int deleteJcOrderById(Long id)
    {
        jcOrderMapper.deleteJcOrderDetailByOrderId(id);
        return jcOrderMapper.deleteJcOrderById(id);
    }

    /**
     * 新增订单详情信息
     * 
     * @param jcOrder 订单管理对象
     */
    public void insertJcOrderDetail(JcOrder jcOrder)
    {
        List<JcOrderDetail> jcOrderDetailList = jcOrder.getJcOrderDetailList();
        Long id = jcOrder.getId();
        if (StringUtils.isNotNull(jcOrderDetailList))
        {
            List<JcOrderDetail> list = new ArrayList<JcOrderDetail>();
            for (JcOrderDetail jcOrderDetail : jcOrderDetailList)
            {
                jcOrderDetail.setId(id);
                list.add(jcOrderDetail);
            }
            if (list.size() > 0)
            {
                jcOrderMapper.batchJcOrderDetail(list);
            }
        }
    }
}
