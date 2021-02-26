package com.ruoyi.domain;

import com.ruoyi.common.core.domain.JcBaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 用户收货地址对象 jc_user_address
 *
 * @author hlinhao Hu
 * @date 2021-02-26
 */
public class JcUserAddress extends JcBaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 省市县 */
    @Excel(name = "省市县")
    private Long cityId;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detailAddr;

    /** 收货手机号 */
    @Excel(name = "收货手机号")
    private String acceptPhone;

    /** 标识 0：默认地址  1：有效地址 2：失效地址 */
    @Excel(name = "标识 0：默认地址  1：有效地址 2：失效地址")
    private Integer dflag;

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
    public void setCityId(Long cityId)
    {
        this.cityId = cityId;
    }

    public Long getCityId()
    {
        return cityId;
    }
    public void setDetailAddr(String detailAddr)
    {
        this.detailAddr = detailAddr;
    }

    public String getDetailAddr()
    {
        return detailAddr;
    }
    public void setAcceptPhone(String acceptPhone)
    {
        this.acceptPhone = acceptPhone;
    }

    public String getAcceptPhone()
    {
        return acceptPhone;
    }
    public void setDflag(Integer dflag)
    {
        this.dflag = dflag;
    }

    public Integer getDflag()
    {
        return dflag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("cityId", getCityId())
                .append("detailAddr", getDetailAddr())
                .append("acceptPhone", getAcceptPhone())
                .append("dflag", getDflag())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
