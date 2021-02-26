package com.ruoyi.web.controller.api;

import com.ruoyi.domain.CartVo;
import com.ruoyi.domain.JcUser;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.enums.RestEnum;
import com.ruoyi.service.AppletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2021/2/26 13:40
 */
@RestController
@RequestMapping("appletApi/auth/addr/")
public class AddrApi extends BaseApi{
    @Autowired
    private AppletService appletService;
    
    @PostMapping("getAddr")
    public RestResultVo getAddr(){
        RestResultVo<JcUser> resultVo = getCurUser();
        if(!RestEnum.SUCCESS.getCode().equals(resultVo.getCode()))
            return resultVo;
        
        return RestResultVo.SUCCESS(appletService.getAllAddr(resultVo.getData().getId()));
    }
}
