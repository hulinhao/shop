package com.ruoyi.domain;

import com.ruoyi.common.core.domain.JcBaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 购物车对象 jc_cart
 *
 * @author hlinhao Hu
 * @date 2020-11-04
 */
public class JcCart extends JcBaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long productId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long productAttrId;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 标识0：有效 1：删除 2：已加入订单 */
    @Excel(name = "标识0：有效 1：删除 2：已加入订单")
    private Long dflag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
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
    public void setDflag(Long dflag)
    {
        this.dflag = dflag;
    }

    public Long getDflag()
    {
        return dflag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("productId", getProductId())
                .append("productAttrId", getProductAttrId())
                .append("number", getNumber())
                .append("dflag", getDflag())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
