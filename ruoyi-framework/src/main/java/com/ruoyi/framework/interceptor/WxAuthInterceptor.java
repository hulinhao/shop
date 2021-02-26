package com.ruoyi.framework.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.constant.ShopConstant;
import com.ruoyi.domain.JcUser;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.enums.RestEnum;
import com.ruoyi.utils.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 11:09
 */
@Component
@Slf4j
public class WxAuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(ShopConstant.APPLET_TOKEN);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(ShopConstant.APPLET_TOKEN);
        }
        
        try{
            if (StringUtils.isEmpty(token)) {
                log.warn("【信息验证】用户未登录。");
                return false;
            }
            //解析token
            Map map = JSONObject.parseObject(Base64Util.decodeBase64String(token,ShopConstant.APPLET_TOKEN_SALT));
            JcUser user = new JcUser();
            user.setId(Long.parseLong(map.get("id").toString()));
            user.setName(map.get("name").toString());
            Long expiresTime = Long.parseLong(map.get("expiresTime").toString());
            if(new Date().getTime() > expiresTime){//登录超时
                log.warn("【信息验证】token已过期。");
                return false;
            }

            return super.preHandle(request, response, handler);
        }catch (Exception e){
            log.info("【信息验证】token解析错误：token=>{}", token);
            return false;
        }
    }
}
