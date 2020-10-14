package com.ruoyi.enums;

import lombok.Getter;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 16:26
 */
@Getter
public enum  ShopEnum {

    WOMEN("0","女"),
    MEN("1","男"),


    ;
    ShopEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

}
