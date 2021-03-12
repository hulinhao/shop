package com.ruoyi.domain;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2021/3/9 15:28
 */
@Data
public class OrderVo {

    private Long id;

    /** 用户id */
    private Long userId;

    /** 订单金额 */
    private Long orderPrice;

    /** 实付金额 */
    private Long paidPrice;

    /** 折扣金额 */
    private Long discountPrice;

    /** 收货地址 */
    private String address;

    /** 收货地址 */
    private String name;
    
    /** 收货地址 */
    private String phone;

    /** 订单状态 0：草稿订单 1:待支付 2：线上支付 3:线下支付 4：已取消 5:已删除 */
    private Long status;

    /** 快递信息 */
    private Long expressId;

    /** 支付凭证 */
    private Long paidId;

    /** 下单时间 */
    private Long time;
    
    private List<CartVo> plist;
    
    private String remark;
    
}
