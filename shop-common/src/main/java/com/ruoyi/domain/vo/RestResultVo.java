package com.ruoyi.domain.vo;

import com.ruoyi.enums.RestEnum;
import lombok.Data;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 19:02
 * 接口通用返回对象
 */
@Data
public class RestResultVo {
    private String code;
    private String msg;
    private Object data;

    public static RestResultVo fail(){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.FAIL.getCode());
        restResultVo.setCode(RestEnum.FAIL.getMsg());
        return restResultVo;
    }

    public static RestResultVo error(){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.ERROR.getCode());
        restResultVo.setCode(RestEnum.ERROR.getMsg());
        return restResultVo;
    }

    public static RestResultVo success(Object data){
        RestResultVo restResultVo = new RestResultVo();
        restResultVo.setCode(RestEnum.SUCCESS.getCode());
        restResultVo.setCode(RestEnum.SUCCESS.getMsg());
        restResultVo.setData(data);
        return restResultVo;
    }
}
