package com.ruoyi.utils;


import org.apache.commons.lang3.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.Base64;


/**
 * Base64处理工具类
 */
public class Base64Util {

    // 默认编码类型
    public static String UTF_8 = "UTF-8";

    static final Base64.Decoder decoder = Base64.getDecoder();
    static final Base64.Encoder encoder = Base64.getEncoder();

    /**
     * Base64编码
     * @param param
     * @return
     */
    public static String encodeBase64String(String param){
        if(StringUtils.isBlank(param)) return null;
        try {
            return encoder.encodeToString(param.getBytes(UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeBase64String(String param,String salt){
        if(StringUtils.isBlank(param)) return null;
        try {
            return encoder.encodeToString(param.getBytes(UTF_8)) + encoder.encodeToString(salt.getBytes(UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Base64解码
     * @param param
     * @return
     */
    public static String decodeBase64String(String param){
        if(StringUtils.isBlank(param)) return null;
        try {
            return new String(decoder.decode(param), UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decodeBase64String(String param,String salt){
        if(StringUtils.isBlank(param)) return null;
        try {
            param = param.trim().replaceAll(encodeBase64String(salt),"");
            return decodeBase64String(param);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
