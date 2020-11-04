package com.ruoyi.domain;

import com.ruoyi.common.core.domain.JcBaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品属性对象 jc_product_attr
 *
 * @author hlinhao Hu
 * @date 2020-11-03
 */
public class JcProductAttr extends JcBaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long productId;

    /** 颜色 */
    @Excel(name = "颜色")
    private String color;

    /** 规格 */
    @Excel(name = "规格")
    private String size;

    /** 原价 */
    @Excel(name = "原价")
    private Long originalPrice;

    /** 折扣价 */
    @Excel(name = "折扣价")
    private Long discountPrice;

    /** 折扣 */
    @Excel(name = "折扣")
    private Long discount;

    /** 库存 */
    @Excel(name = "库存")
    private Long inventory;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId()
    {
        return productId;
    }
    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }
    public void setSize(String size)
    {
        this.size = size;
    }

    public String getSize()
    {
        return size;
    }
    public void setOriginalPrice(Long originalPrice)
    {
        this.originalPrice = originalPrice;
    }

    public Long getOriginalPrice()
    {
        return originalPrice;
    }
    public void setDiscountPrice(Long discountPrice)
    {
        this.discountPrice = discountPrice;
    }

    public Long getDiscountPrice()
    {
        return discountPrice;
    }
    public void setDiscount(Long discount)
    {
        this.discount = discount;
    }

    public Long getDiscount()
    {
        return discount;
    }
    public void setInventory(Long inventory)
    {
        this.inventory = inventory;
    }

    public Long getInventory()
    {
        return inventory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("productId", getProductId())
                .append("color", getColor())
                .append("size", getSize())
                .append("originalPrice", getOriginalPrice())
                .append("discountPrice", getDiscountPrice())
                .append("discount", getDiscount())
                .append("inventory", getInventory())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
