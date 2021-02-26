package com.ruoyi.domain.vo;

import com.ruoyi.enums.RestEnum;
import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 19:02
 * 接口通用返回对象
 */
@Data
public class RestResultVo<T> {
    private String code;
    private String msg;
    private T data;

    public static RestResultVo FAIL(){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.FAIL.getCode());
        restResultVo.setMsg(RestEnum.FAIL.getMsg());
        return restResultVo;
    }

    public static RestResultVo FAIL(String msg){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.FAIL.getCode());
        restResultVo.setMsg(msg);
        return restResultVo;
    }

    public static RestResultVo ERROR(){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.ERROR.getCode());
        restResultVo.setMsg(RestEnum.ERROR.getMsg());
        return restResultVo;
    }

    public static RestResultVo PARAM_ERROR(){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.PARAM_ERROR.getCode());
        restResultVo.setMsg(RestEnum.PARAM_ERROR.getMsg());
        return restResultVo;
    }

    public static RestResultVo SUCCESS(){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.SUCCESS.getCode());
        restResultVo.setMsg(RestEnum.SUCCESS.getMsg());
        return restResultVo;
    }

    public static <E> RestResultVo SUCCESS(E data){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.SUCCESS.getCode());
        restResultVo.setMsg(RestEnum.SUCCESS.getMsg());
        restResultVo.setData(data);
        return restResultVo;
    }
}
