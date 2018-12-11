package com.github.hudic.auth.util.user;

import java.io.Serializable;

/**
 * jiangcq
 * 2018/12/11 18:52
 */
public class JwtAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = 1905664513676921892L;
    private String username;
    private String password;

    public JwtAuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
