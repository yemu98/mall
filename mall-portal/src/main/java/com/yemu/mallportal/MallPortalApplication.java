package com.yemu.mallportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yemu.mallportal.mapper")
public class MallPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPortalApplication.class, args);
    }

}
