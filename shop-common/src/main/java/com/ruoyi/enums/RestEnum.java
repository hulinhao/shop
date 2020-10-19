package com.ruoyi.enums;

import lombok.Getter;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 19:06
 */
@Getter
public enum RestEnum {
    SUCCESS("S0000","成功"),
    FAIL("S0001","失败"),
    ERROR("S0002","系统错误"),

    ;

    public static String APPLET_TOKEN = "token";
    public static String APPLET_TOKEN_SALT = "token_salt";

    RestEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;
}
