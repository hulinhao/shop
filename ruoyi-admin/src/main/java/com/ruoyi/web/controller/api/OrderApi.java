package com.ruoyi.web.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.domain.JcOrder;
import com.ruoyi.domain.JcOrderDetail;
import com.ruoyi.domain.JcUser;
import com.ruoyi.domain.OrderVo;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.enums.RestEnum;
import com.ruoyi.service.AppletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2021/3/9 15:23
 */
@Slf4j
@RestController
@RequestMapping("appletApi/auth/order/")
public class OrderApi  extends BaseApi{
    @Resource
    private AppletService appletService;
    
    @RequestMapping("create")
    public RestResultVo<JcOrder> createOrder(@RequestParam("param") String param){
        RestResultVo<JcUser> rest = getCurUser();
        if(!RestEnum.SUCCESS.getCode().equals(rest.getCode()))
            return RestResultVo.FAIL("请登录");
        JcUser user = rest.getData();
        JSONObject jsonObject = JSONObject.parseObject(param);
        OrderVo orderVo =  JSONObject.toJavaObject(jsonObject,OrderVo.class);
        JcOrder order = appletService.createOrder(orderVo,user);
        log.info("订单生成成功！金额：{}",order.getPaidPrice());
        return RestResultVo.SUCCESS(order);
    }
}
