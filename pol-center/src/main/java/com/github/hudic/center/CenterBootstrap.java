package com.github.hudic.center;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * jiangcq
 * 2018/12/11 18:36
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class CenterBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CenterBootstrap.class, args);
        log.info("CenterBootstrap服务启动成功");
    }
}
