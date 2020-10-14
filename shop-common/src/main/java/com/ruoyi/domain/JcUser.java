package com.ruoyi.domain;

import com.ruoyi.common.core.domain.JcBaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户管理对象 jc_user
 *
 * @author hlinhao Hu
 * @date 2020-10-14
 */
public class JcUser extends JcBaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** wx_openId */
    @Excel(name = "wx_openId")
    private String wxOpenid;

    /** 微信名字 */
    @Excel(name = "微信名字")
    private String wxName;

    /** 微信图片地址 */
    @Excel(name = "微信图片地址")
    private String avatarUrl;

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
    public void setWxName(String wxName)
    {
        this.wxName = wxName;
    }

    public String getWxName()
    {
        return wxName;
    }
    public void setAvatarUrl(String avatarUrl)
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
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
                .append("wxName", getWxName())
                .append("avatarUrl", getAvatarUrl())
                .append("name", getName())
                .append("phone", getPhone())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
