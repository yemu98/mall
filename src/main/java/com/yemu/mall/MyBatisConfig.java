package com.yemu.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yemu.mall.mapper")
public class MyBatisConfig {
}
