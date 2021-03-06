package com.ruoyi.web.controller.api;

import com.ruoyi.domain.IndexVo;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.service.AppletService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/22 20:29
 */
@RestController
@RequestMapping("appletApi/index/")
public class IndexApi extends BaseApi{

    @Resource
    private AppletService appletService;

    @RequestMapping("list")
    public RestResultVo<IndexVo> getIndex(){
        //查询爆款  用于首页展示
        return RestResultVo.SUCCESS(appletService.getIndex());
    }
}
