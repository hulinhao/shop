package com.ruoyi.framework.interceptor;

import com.ruoyi.constant.ShopConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 11:09
 */
@Component
public class WxAuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 验证小程序用户是否已经登录，是否登录过期
        String token = request.getHeader(ShopConstant.WX_TOKEN);




        return super.preHandle(request, response, handler);
    }
}
