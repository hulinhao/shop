package com.ruoyi.web.controller.api;

import com.ruoyi.domain.CartVo;
import com.ruoyi.domain.JcUser;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.enums.RestEnum;
import com.ruoyi.service.AppletService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/15 10:27
 */
@RestController
@RequestMapping("appletApi/cart/")
public class CartApi extends BaseApi {
    @Resource
    private AppletService appletService;
    /**
     * 获取购物车信息
     * @return
     */
    @PostMapping("list")
    public RestResultVo getCart(){
        RestResultVo<JcUser>  restUser =  getCurUser();
        if(RestEnum.SUCCESS.getCode().equals(restUser.getCode())){
            List<CartVo> list = appletService.getCartByUserId(restUser.getData().getId());
            return RestResultVo.SUCCESS(list);
        }
        return RestResultVo.FAIL();
    }
}
