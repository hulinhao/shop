package com.ruoyi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 16:26
 */
public interface   ShopEnum {

    @Getter
    @AllArgsConstructor
    enum gender {
        WOMEN(0,"女"),
        MEN(1,"男"),
        ;
            private Integer code;
        private String msg;
    }
    
    @Getter
    @AllArgsConstructor 
    enum product_status{
        NORMAL(0,"正常"),
        DISCOUNT(1,"打折"),
        SELLOUT(2,"售罄"),
        SOLDOUT(3,"下架"),
        HOT(4,"爆款"),
        ;
        private Integer code;
        private String msg;
    }

    @Getter
    @AllArgsConstructor 
    enum order_status{
        CAOGAO(0L,"草稿订单"),
        DAIZHIFU(1L,"待支付"),
        XIANSHANGZHIFU(2L,"线上支付"),
        XIANXIAZHIFU(3L,"线下支付"),
        QUXIAO(4L,"已取消"),
        SHANCHU(5L,"已删除");
        private Long code;
        private String msg;
    }
}
