package com.zyc.demo.swagger.filter;

import com.zyc.demo.swagger.anotation.RequiresPermissions;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/2/3 20:38
 */
@Component
public class AuthorityInterceptor  extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true ;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        String name = method.getDeclaringClass().getName();
        System.out.println(name);
        RequiresPermissions annotation = method.getAnnotation(RequiresPermissions.class);
        if(annotation != null){
            System.out.println(annotation.needLogin());

        }

        return true;
    }
}
