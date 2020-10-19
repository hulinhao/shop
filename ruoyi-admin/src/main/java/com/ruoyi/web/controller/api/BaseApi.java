package com.ruoyi.web.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.constant.ShopConstant;
import com.ruoyi.domain.JcUser;
import com.ruoyi.utils.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 17:49
 */
@Slf4j
public class BaseApi {

    @Autowired(required = false)
    protected HttpServletRequest request;

    /**
     * 获取用户token
     *
     * @return
     */
    protected String getToken() {
        String token = request.getHeader(ShopConstant.WX_TOKEN);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(ShopConstant.WX_TOKEN);
        }
        return token;
    }

    /**
     * 获取当前app登录用户
     *
     * @return
     */
    public JcUser getCurUser() {
        String token = getToken();
        if (StringUtils.isEmpty(token)) {
            return null;
        }

        JcUser jcUser = (JcUser) JSONObject.parse(Base64Util.decodeBase64String(token));
        log.info("当前用户：token=>{}, user=>{}", token, jcUser);
        return jcUser;
    }

}
