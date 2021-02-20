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
    @AllArgsConstructor //0：正常 1：打折 2：售罄 3：下架4:爆款'
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

}
