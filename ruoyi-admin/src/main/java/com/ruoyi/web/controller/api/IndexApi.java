package com.ruoyi.web.controller.api;

import com.ruoyi.domain.vo.RestResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/22 20:29
 */
@RestController
@RequestMapping("appletApi/index/")
public class IndexApi extends BaseApi{

    @RequestMapping("list")
    @ResponseBody
    public RestResultVo getindex(){

        return RestResultVo.SUCCESS();
    }
}
