package com.ruoyi.web.controller.api;

import com.ruoyi.domain.JcProductType;
import com.ruoyi.domain.ProductVo;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.service.AppletService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/27 15:14
 */
@RestController
@RequestMapping("appletApi/auth/product/")
public class ProductApi extends BaseApi {
    @Resource
    private AppletService appletService;

    @RequestMapping("type")
    public RestResultVo<List<JcProductType>> getType(){
        return RestResultVo.SUCCESS(appletService.getType());
    }

    @RequestMapping("product")
    public RestResultVo<List<ProductVo>> getProduct(@RequestParam("typeId")Integer typeId){
        return RestResultVo.SUCCESS(appletService.getProductByTypeId(typeId));
    }

    @RequestMapping("detail")
    public RestResultVo<ProductVo> getDetail(@RequestParam("pId")Long pId){
        return RestResultVo.SUCCESS(appletService.getDetail(pId));
    }
}
