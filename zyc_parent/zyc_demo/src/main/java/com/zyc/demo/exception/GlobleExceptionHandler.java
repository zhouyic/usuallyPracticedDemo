package com.zyc.demo.exception;

import com.zyc.demo.entity.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhouyicai
 * @Description: 全局异常捕获
 * @ControllerAdvice 注解表示开启了全局异常的捕获
 * @ExceptionHandler 指定拦截的异常
 * @date 2020/4/8 22:25
 */
@ControllerAdvice
public class GlobleExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobleExceptionHandler.class);

    @ExceptionHandler(value = BusinessException.class)
    public Object businessException(HttpServletRequest httpRequest,BusinessException be) {
        LOGGER.error("发生业务异常:{}",be.getMessage());
        if(isAjax(httpRequest)){
            return BaseResponse.fail(be.getErrorCode(), be.getMessage());
        }else{
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.addStaticAttribute("code", be.errorCode);
            view.addStaticAttribute("message",be.message);
            ModelAndView mv = new ModelAndView(view);
//        mv.setViewName();指定发生异常之后跳转页面
            return mv;
        }


    }
    @ExceptionHandler(value = Exception.class)
    public Object exception(HttpServletRequest httpRequest,Exception e){
        LOGGER.error("发生未知异常:{}",e);
        if(isAjax(httpRequest)){
            return BaseResponse.fail(e.getMessage());
        }else{
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.addStaticAttribute("code",BusinessCode.CODE_1001);
            view.addStaticAttribute("message","服务器内部错误");
            ModelAndView mv = new ModelAndView(view);
//        mv.setViewName();指定发生异常之后跳转页面
            return mv;
        }


    }
    // 判断是否是ajax请求
    public static boolean isAjax(HttpServletRequest httpRequest) {
        String xRequestedWith = httpRequest.getHeader("X-Requested-With");
        return (xRequestedWith != null && "XMLHttpRequest".equals(xRequestedWith));
    }
}
