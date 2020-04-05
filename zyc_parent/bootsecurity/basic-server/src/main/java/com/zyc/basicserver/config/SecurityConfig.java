package com.zyc.basicserver.config;
import com.zyc.basicserver.auth.MyAuthenticationSuccessHandler;
import com.zyc.basicserver.auth.MyExpiredSessionStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/2 23:10
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()  //关闭跨站防御攻击
                .formLogin()  // 指定formLogin模式的登录认证
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index")
                .failureUrl("/login.html")
//                .successHandler(myAuthenticationSuccessHandler) //注入自定义登录成功handler
                .and()
                .authorizeRequests()
                .antMatchers("/login.html", "/login").permitAll()
                .antMatchers("/biz1", "/biz2")  //需要对外暴露的资源路径
                .hasAnyAuthority("ROLE_user", "ROLE_admin")//user角色和admin角色可以访问
                /*通过角色的方式控制权限*/
//                .antMatchers("/syslog","/sysuser")
//                    .hasAnyRole("admin") //admin 角色可以访问
//                .hasAnyAuthority("ROLE_admin")
                /*通过权限(资源)id的方式控制权限*/
                .antMatchers("/syslog").hasAuthority("sys:log")
                .antMatchers("/sysuser").hasAuthority("sys:user")
                .anyRequest().authenticated() //指定所有的请求必须要登录
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .invalidSessionUrl("/login.html")
                .sessionFixation().migrateSession();
//                .maximumSessions(1) //当前登录用户为1
//                .maxSessionsPreventsLogin(false) //当前登录两用户,剔除第一个用户,下线
//                .expiredSessionStrategy(new MyExpiredSessionStrategy());
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("123456"))
                .roles("user")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("123456"))
                /*通过角色的方式控制权限*/
//                .roles("admin")
                /*通过权限(资源)id的方式控制权限*/
                .authorities("sys:log","sys:user")
                .and()
                .passwordEncoder(passwordEncoder());//配置BCrypt加密
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //将项目中静态资源路径开放出来
        web.ignoring().antMatchers("/css/**", "/fonts/**", "/img/**", "/js/**");
    }
}
