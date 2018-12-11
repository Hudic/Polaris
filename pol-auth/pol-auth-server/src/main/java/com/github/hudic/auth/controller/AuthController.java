package com.github.hudic.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * jiangcq
 * 2018/12/11 18:39
 */
@RestController
@RequestMapping("jwt")
@Slf4j
public class AuthController {
    /*这里不是用lombok的Value，而是org.springframework.beans.factory.annotation.Value
    * 从application.yml取值
    * jwt:
    *   token-header: Authorization
    * */
    @Value("${jwt.token-header}")

    private String tokenService;
}
