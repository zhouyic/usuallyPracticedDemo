package com.zyc.jwtserver.config;
import com.zyc.jwtserver.auth.MyLoginoutSuccessHandler;
import com.zyc.jwtserver.auth.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/2 23:10
 */
@Configuration
@EnableScheduling
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    MyUserDetailsService myUserDetailsService;
    @Resource
    MyLoginoutSuccessHandler myLoginoutSuccessHandler;
    @Resource
    DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout()
                .logoutUrl("/signout")
//                .logoutSuccessUrl("/afterSignout.html")
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessHandler(myLoginoutSuccessHandler)
            .and().rememberMe()
                .rememberMeParameter("remember-me-new")
                .rememberMeCookieName("remember-me-name")
                .tokenValiditySeconds(2 * 24 * 60 * 60)
                .tokenRepository(persistentTokenRepository())
            .and().csrf().disable()  //关闭跨站防御攻击
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/index").authenticated()
                .anyRequest().access("@myRBACService.hasPermission(request,authentication)")
            .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .invalidSessionUrl("/login.html")
                .sessionFixation().migrateSession()
                .maximumSessions(1) //当前登录用户为1
                .maxSessionsPreventsLogin(false); //当前登录两用户,剔除第一个用户,下线
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("user")
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder().encode("123456"))
//                /*通过角色的方式控制权限*/
////                .roles("admin")
//                /*通过权限(资源)id的方式控制权限*/
//                .authorities("sys:log","sys:user")
//                .and()
//                .passwordEncoder(passwordEncoder());//配置BCrypt加密

                auth
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //将项目中静态资源路径开放出来
        web.ignoring().antMatchers("/public/**","/css/**", "/fonts/**", "/img/**", "/js/**");
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
