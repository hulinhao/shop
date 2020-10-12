package com.ruoyi.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 jc_product
 * 
 * @author linhao Hu
 * @date 2020-10-12
 */
@Getter
@Setter
public class JcProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private String productNo;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 文章宣传 */
    @Excel(name = "文章宣传")
    private String content;

    /** 类型 */
    @Excel(name = "类型")
    private Integer type;

    /** 商品状态 枚举值：0：正常 1：打折 2：售罄 3：下架 */
    @Excel(name = "商品状态 枚举值：0：正常 1：打折 2：售罄 3：下架")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductNo(String productNo) 
    {
        this.productNo = productNo;
    }

    public String getProductNo() 
    {
        return productNo;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productNo", getProductNo())
            .append("name", getName())
            .append("content", getContent())
            .append("type", getType())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
