package com.example.codinghub.service.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.codinghub.service.store.mapper")
public class MyBatisPlusConfig {
}
