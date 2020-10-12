package com.ruoyi.utils;

/**
 * @author linhaoHu
 * @date 2019/8/27 13:46
 */
public class CommUtil {

    public static boolean isNull(Object data){
        if(data == null || data.toString().length() == 0 ||"".equals(data.toString()))
            return false;
        return true;
    }

}
