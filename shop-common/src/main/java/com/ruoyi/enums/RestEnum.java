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
    LOG_OUT("S0003","未登录"),
    EXPRIED_TOKEN("S0004","登录过期"),
    PARSE_ERROR("S0005","token解析错误"),
    ;

    RestEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;
}
