package com.zyc.demo.swagger.anotation;

import java.lang.annotation.*;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/2/3 20:34
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiresPermissions {
    /**
     * 方法所需要的权限
     * @return
     */
    String permission() default "";

    /**
     * 是否需要登录 默认需要
     * @return
     */
    boolean needLogin() default true;
}
