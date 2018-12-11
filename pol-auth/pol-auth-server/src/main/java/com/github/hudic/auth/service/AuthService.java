package com.github.hudic.auth.service;

import com.github.hudic.auth.util.user.JwtAuthenticationRequest;

/**
 * jiangcq
 * 2018/12/11 18:51
 */
public interface AuthService {
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;

    String refresh(String oldToken) throws Exception;

    void validate(String token) throws Exception;
}
