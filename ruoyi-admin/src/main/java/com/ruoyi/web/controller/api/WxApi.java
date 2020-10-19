package com.ruoyi.web.controller.api;

import com.ruoyi.domain.JcUser;
import com.ruoyi.enums.RestEnum;
import com.ruoyi.service.AppletService;
import com.ruoyi.utils.AesCbcUtil;
import com.ruoyi.utils.Base64Util;
import com.ruoyi.utils.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/15 10:25
 */
@RestController
@RequestMapping("/appletApi/weixin")
@Slf4j
public class WxApi {

    @Resource
    private AppletService appletService;
    private static String FAIL = "0";
    private static String SUCCESS = "1";

    /**
     * @Title: decodeUserInfo        
     * @Description: 解密用户敏感数据
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "decodeUserInfo", method = RequestMethod.POST)
    public Map decodeUserInfo(@RequestBody Map<String,String> param) {
        //encryptedData 明文,加密数据
        String encryptedData = param.get("encryptedData");
        //iv 加密算法的初始向量
        String iv = param.get("iv");
        //code 用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid和session_key
        String code = param.get("code");

        Map map = new HashMap();
        // 登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", FAIL);
            map.put("msg", "code 不能为空");
            return map;
        }

        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = "wxf7bada46fbe07dc8";
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "64e8f82ed4fc3aa2645baea3693e65a7";
        // 授权（必填）
        String grant_type = "authorization_code";

        // 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        // 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            // 请求参数
            String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
                    + grant_type;
            // 发送请求
            String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
            // 解析相应内容（转换成json对象）
            JSONObject json = new JSONObject(sr);
            // 获取会话密钥（session_key）
            String session_key = json.get("session_key").toString();
            // 用户的唯一标识（openid）
            String openid = (String) json.get("openid");
            // 参数含义：第一个，加密数据串（String）；第二个，session_key需要通过微信小程序的code获得（String）；
            // 第三个，数据加密时所使用的偏移量，解密时需要使用（String）；第四个，编码
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            //用户数据加密
            if (null != result && result.length() > 0) {
                map.put("status", SUCCESS);
                map.put("msg", "解密成功");

                JSONObject userInfoJSON = new JSONObject(result);
                Object openId = userInfoJSON.get("openId");
                Object nickName = userInfoJSON.get("nickName");
                Object gender = userInfoJSON.get("gender");
                Object city = userInfoJSON.get("city");
                Object province = userInfoJSON.get("province");
                Object country = userInfoJSON.get("country");
                Object avatarUrl = userInfoJSON.get("avatarUrl");
                //Object unionId = userInfoJSON.get("unionId");

                //登录（如果用户不存在就先注册）
                JcUser user = new JcUser();
                user.setWxOpenid(openId.toString());
                user.setWxNickname(nickName.toString());
                user.setWxAvatarUrl(avatarUrl.toString());
                user.setWxGender(Integer.parseInt(gender.toString()));
                user.setWxCountry(country.toString());
                user.setWxProvince(province.toString());
                user.setWxCity(city.toString());
                JcUser loginUser = appletService.login(user);
                map.put("user",loginUser);
                map.put("token",createToken(loginUser));

            } else {
                map.put("status", FAIL);
                map.put("msg", "解密失败");
            }
        } catch (Exception e) {
            map.put("status", FAIL);
            map.put("msg", "系统错误");
            log.info(e.getMessage());
            e.printStackTrace();
        }
        log.info(map.toString());
        return map;
    }

    private String createToken(JcUser user){
        if(user == null || user.getId() == null){
            return "";
        }
        Map map = new HashMap();
        map.put("id",user.getId());
        map.put("name",user.getName());
        map.put("expiresTime",new Date().getTime() + 30*60*1000);
        return Base64Util.encodeBase64String(com.alibaba.fastjson.JSONObject.toJSONString(map), RestEnum.APPLET_TOKEN_SALT);
    }
}
