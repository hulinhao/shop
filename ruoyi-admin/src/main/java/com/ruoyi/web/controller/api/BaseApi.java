package com.ruoyi.web.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.constant.ShopConstant;
import com.ruoyi.domain.JcUser;
import com.ruoyi.domain.vo.RestResultVo;
import com.ruoyi.enums.RestEnum;
import com.ruoyi.utils.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

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
        String token = request.getHeader(ShopConstant.APPLET_TOKEN);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(ShopConstant.APPLET_TOKEN);
        }
        return token;
    }

    /**
     * 获取当前app登录用户
     *
     * @return
     */
    public RestResultVo<JcUser> getCurUser() {
        RestResultVo<JcUser> resultVo = new RestResultVo();
        String token = getToken();
        try{
            if (StringUtils.isEmpty(token)) {
                resultVo.setCode(RestEnum.LOG_OUT.getCode());
                resultVo.setMsg(RestEnum.LOG_OUT.getMsg());
                return resultVo;
            }
            //解析token
            Map map = JSONObject.parseObject(Base64Util.decodeBase64String(token,ShopConstant.APPLET_TOKEN_SALT));
            JcUser user = new JcUser();
            user.setId(Long.parseLong(map.get("id").toString()));
            user.setName(map.get("name").toString());
            Long expiresTime = Long.parseLong(map.get("expiresTime").toString());
            if(new Date().getTime()<expiresTime){//登录超时

            }
            resultVo.setCode(RestEnum.SUCCESS.getCode());
            resultVo.setMsg(RestEnum.SUCCESS.getMsg());
            resultVo.setData(user);
            log.info("当前用户：id=>{}，name=>{}，token=>{}", user.getId(),user.getName(),token);
            return resultVo;
        }catch (Exception e){
            resultVo.setCode(RestEnum.PARSE_ERROR.getCode());
            resultVo.setMsg(RestEnum.PARSE_ERROR.getMsg());
            log.info("token解析错误：token=>{}", token);
            return resultVo;
        }
    }

}
