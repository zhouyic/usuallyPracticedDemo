package com.zyc.jwtserver.auth.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/6 17:04
 */
@Service
public class JwtAuthService {
    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    UserDetailsService userDetailsService;

    @Resource
    JwtTokenUtil jwtTokenUtil;
    /**
     * 登录认证换取JWT令牌
     * @param username
     * @param password
     * @return
     */
    public String login(String username,String password){
        try {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码错误");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String jwt = jwtTokenUtil.generateToken(userDetails);
        return jwt;
    }

    public String refreshToken(String oldToken){
        if(!jwtTokenUtil.isTokenExpired(oldToken)){
            return jwtTokenUtil.refreshToken(oldToken);
        }
        return null;
    }
}
