package com.zyc.jwtserver.auth.jwt;

import com.zyc.jwtserver.auth.jwt.condition.UserDetailsCondition;
import com.zyc.jwtserver.model.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/6 16:56
 */
@RestController
public class JwtAuthController {
    @Resource
    JwtAuthService jwtAuthService;
    @RequestMapping(value = "/authentication")
    public BaseResponse login(@RequestBody UserDetailsCondition userDetails) {
        String username = userDetails.getUsername();
        String password = userDetails.getPassword();
        if(StringUtils.isEmpty(username)
            ||StringUtils.isEmpty(password)){
            return BaseResponse.fail("用户名或密码不能为空");
        }
        String jwt = jwtAuthService.login(username, password);
        return BaseResponse.success(jwt);
    }
    @RequestMapping("/refreshToken")
    public BaseResponse refreshToken(@RequestHeader("${jwt.header}") String token){
        return BaseResponse.success(jwtAuthService.refreshToken(token));
    }
}
