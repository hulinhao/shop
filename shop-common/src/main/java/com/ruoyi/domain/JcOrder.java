package com.ruoyi.domain;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.JcBaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.xml.crypto.Data;

/**
 * 订单管理对象 jc_order
 * 
 * @author hlinhao Hu
 * @date 2021-01-05
 */
public class JcOrder extends JcBaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private Long orderPrice;

    /** 实付金额 */
    @Excel(name = "实付金额")
    private Long paidPrice;

    /** 折扣金额 */
    @Excel(name = "折扣金额")
    private Long discountPrice;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String address;
    
    /** 收货地址id */
    @Excel(name = "收货地址id")
    private String name;
    /** 收货地址id */
    @Excel(name = "收货地址id")
    private String phone;

    /** 订单状态 0：草稿订单 1:待支付 2：线上支付 3:线下支付 4：已取消 5:已删除 */
    @Excel(name = "订单状态 0：草稿订单 1:待支付 2：线上支付 3:线下支付 4：已取消 5:已删除")
    private Long status;

    /** 快递信息 */
    @Excel(name = "快递信息")
    private Long expressId;

    /** 支付凭证 */
    @Excel(name = "支付凭证")
    private Long paidId;

    /** 下单时间 */
    @Excel(name = "下单时间")
    private Date time;

    /** 订单详情信息 */
    private List<JcOrderDetail> jcOrderDetailList;

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
    public void setOrderPrice(Long orderPrice) 
    {
        this.orderPrice = orderPrice;
    }

    public Long getOrderPrice() 
    {
        return orderPrice;
    }
    public void setPaidPrice(Long paidPrice) 
    {
        this.paidPrice = paidPrice;
    }

    public Long getPaidPrice() 
    {
        return paidPrice;
    }
    public void setDiscountPrice(Long discountPrice) 
    {
        this.discountPrice = discountPrice;
    }

    public Long getDiscountPrice() 
    {
        return discountPrice;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setExpressId(Long expressId) 
    {
        this.expressId = expressId;
    }

    public Long getExpressId() 
    {
        return expressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPaidId(Long paidId) 
    {
        this.paidId = paidId;
    }

    public Long getPaidId() 
    {
        return paidId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<JcOrderDetail> getJcOrderDetailList()
    {
        return jcOrderDetailList;
    }

    public void setJcOrderDetailList(List<JcOrderDetail> jcOrderDetailList)
    {
        this.jcOrderDetailList = jcOrderDetailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("orderPrice", getOrderPrice())
            .append("paidPrice", getPaidPrice())
            .append("discountPrice", getDiscountPrice())
            .append("status", getStatus())
            .append("expressId", getExpressId())
            .append("paidId", getPaidId())
            .append("time", getTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("jcOrderDetailList", getJcOrderDetailList())
            .toString();
    }
}
