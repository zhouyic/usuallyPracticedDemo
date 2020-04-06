package com.zyc.basicserver.auth;

import com.zyc.basicserver.mapper.MyRBACMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/5 12:57
 */
@Component("myRBACService")
public class MyRBACService {
    @Resource
    private MyRBACMapper myRBACMapper;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断某用户是否具有该request资源的访问权限
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails) principal).getUsername();
            String requestURI = request.getRequestURI();
            List<String> uris = myRBACMapper.findUriByUserName(username);
            return uris.stream().anyMatch(
                    uri -> antPathMatcher.match(uri,requestURI )
            );
        }
        return false;
    }


}
