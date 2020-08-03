package com.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author linhaoHu
 * @date 2019/7/26 16:02
 */
@SpringBootApplication
@Configuration
@Slf4j
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        log.info("...App已启动");
    }
}
