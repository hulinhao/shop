package com.ruoyi.domain;

import com.ruoyi.common.core.domain.JcBaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 jc_user
 *
 * @author hlinhao Hu
 * @date 2020-10-19
 */
public class JcUser extends JcBaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String wxOpenid;

    /** 微信昵称 */
    @Excel(name = "微信昵称")
    private String wxNickname;

    /** 微信图片地址 */
    @Excel(name = "微信图片地址")
    private String wxAvatarUrl;

    /** 性别：0：女 1：男 */
    @Excel(name = "性别：0：女 1：男")
    private Integer wxGender;

    /** 国家 */
    @Excel(name = "国家")
    private String wxCountry;

    /** 省份 */
    @Excel(name = "省份")
    private String wxProvince;

    /** 城市 */
    @Excel(name = "城市")
    private String wxCity;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWxOpenid(String wxOpenid)
    {
        this.wxOpenid = wxOpenid;
    }

    public String getWxOpenid()
    {
        return wxOpenid;
    }
    public void setWxNickname(String wxNickname)
    {
        this.wxNickname = wxNickname;
    }

    public String getWxNickname()
    {
        return wxNickname;
    }
    public void setWxAvatarUrl(String wxAvatarUrl)
    {
        this.wxAvatarUrl = wxAvatarUrl;
    }

    public String getWxAvatarUrl()
    {
        return wxAvatarUrl;
    }
    public void setWxGender(Integer wxGender)
    {
        this.wxGender = wxGender;
    }

    public Integer getWxGender()
    {
        return wxGender;
    }
    public void setWxCountry(String wxCountry)
    {
        this.wxCountry = wxCountry;
    }

    public String getWxCountry()
    {
        return wxCountry;
    }
    public void setWxProvince(String wxProvince)
    {
        this.wxProvince = wxProvince;
    }

    public String getWxProvince()
    {
        return wxProvince;
    }
    public void setWxCity(String wxCity)
    {
        this.wxCity = wxCity;
    }

    public String getWxCity()
    {
        return wxCity;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("wxOpenid", getWxOpenid())
                .append("wxNickname", getWxNickname())
                .append("wxAvatarUrl", getWxAvatarUrl())
                .append("wxGender", getWxGender())
                .append("wxCountry", getWxCountry())
                .append("wxProvince", getWxProvince())
                .append("wxCity", getWxCity())
                .append("name", getName())
                .append("phone", getPhone())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
