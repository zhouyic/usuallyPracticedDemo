package com.zyc.jwtserver.auth;

import com.zyc.jwtserver.mapper.MyUserDetailsMapper;
import com.zyc.jwtserver.model.MyUserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/5 10:43
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private MyUserDetailsMapper myUserDetailsMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //加载基础用户信息
        MyUserDetails myUserDetails = myUserDetailsMapper.findByUserName(username);
        //加载用户角色列表
        List<String> roleNameList = myUserDetailsMapper.findRoleByUserName(username);
        //通过用户角色列表加载用户的资源权限列表
        List<String> authorityList = myUserDetailsMapper.findAuthorityByRoleName(roleNameList);
        //角色是一个特殊的权限,ROLE_前缀
        List<String> collect = roleNameList.stream().map(roleName -> "ROLE_" + roleName).collect(Collectors.toList());
        authorityList.addAll(collect);
        myUserDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",",authorityList)));
        return myUserDetails;

    }
}
