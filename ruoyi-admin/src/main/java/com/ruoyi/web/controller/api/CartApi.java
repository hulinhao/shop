package com.ruoyi.web.controller.api;

import com.ruoyi.domain.CartVo;
import com.ruoyi.domain.JcUser;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.enums.RestEnum;
import com.ruoyi.service.AppletService;
import com.ruoyi.utils.CommUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 添加购物车
     * @return
     */
    @PostMapping("addCart")
    public RestResultVo addCart(@RequestParam("pId")Long pId,@RequestParam("attrId")Long attrId,@RequestParam("num")Long num){
        RestResultVo<JcUser> resultVo = getCurUser();
        if(!RestEnum.SUCCESS.getCode().equals(resultVo.getCode())){
            return resultVo;
        }
        if(CommUtil.isNull(pId)||CommUtil.isNull(num)||CommUtil.isNull(attrId))
            return RestResultVo.PARAM_ERROR();

        return appletService.addCart(pId,attrId,num,resultVo.getData().getId());
    }
}
