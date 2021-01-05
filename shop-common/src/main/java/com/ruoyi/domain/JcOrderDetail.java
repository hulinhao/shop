package com.ruoyi.domain;

import com.ruoyi.common.core.domain.JcBaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单详情对象 jc_order_detail
 * 
 * @author hlinhao Hu
 * @date 2021-01-05
 */
public class JcOrderDetail extends JcBaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "备注")
    private Long orderId;

    /** $column.columnComment */
    @Excel(name = "备注")
    private Long productId;

    /** $column.columnComment */
    @Excel(name = "备注")
    private Long productAttrId;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 原价 */
    @Excel(name = "原价")
    private Long originalPrice;

    /** 订单价 */
    @Excel(name = "订单价")
    private Long orderPrice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductAttrId(Long productAttrId) 
    {
        this.productAttrId = productAttrId;
    }

    public Long getProductAttrId() 
    {
        return productAttrId;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setOriginalPrice(Long originalPrice) 
    {
        this.originalPrice = originalPrice;
    }

    public Long getOriginalPrice() 
    {
        return originalPrice;
    }
    public void setOrderPrice(Long orderPrice) 
    {
        this.orderPrice = orderPrice;
    }

    public Long getOrderPrice() 
    {
        return orderPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("productId", getProductId())
            .append("productAttrId", getProductAttrId())
            .append("number", getNumber())
            .append("originalPrice", getOriginalPrice())
            .append("orderPrice", getOrderPrice())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
