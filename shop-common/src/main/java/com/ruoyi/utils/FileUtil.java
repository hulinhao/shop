package com.ruoyi.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;



/**
 * @author linhaoHu
 * @date 2019/7/26 16:45
 */
@Slf4j
public class FileUtil {

    public static String getApi(String fileName){
        try {
            String path = FileUtil.class.getClassLoader().getResource("api").getPath();
            String data = "";
            File file = new File(path+"/"+fileName);
            InputStreamReader r = new InputStreamReader(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(r);
            String a = "";
            while ((a = reader.readLine())!=null ){
                data+=a;
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            //log.info("读取文件内容错误:"+ fileName);
            
        }
        return "";
    }

}
