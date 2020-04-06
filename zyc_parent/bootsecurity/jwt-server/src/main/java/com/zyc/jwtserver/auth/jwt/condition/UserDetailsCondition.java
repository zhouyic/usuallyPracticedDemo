package com.zyc.jwtserver.auth.jwt.condition;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/6 16:58
 */
public class UserDetailsCondition {
    private String username;
    private String password;

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
}
