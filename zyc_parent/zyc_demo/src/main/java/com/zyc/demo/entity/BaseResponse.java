package com.zyc.demo.entity;

import com.zyc.demo.exception.BusinessException;
import lombok.Data;

@Data
public class BaseResponse {

    private int code;
    private String errorMessage;
    private Object data;

    public BaseResponse(int code, String errorMessage, Object data){
        this.code = code;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public static BaseResponse success(){
        return success(null);
    }

    public static BaseResponse success(Object data){
        return new BaseResponse(0, null, data);
    }

    public static BaseResponse fail(String errorMessage){
        return fail(1001, errorMessage);
    }

    public static BaseResponse fail(int code, String errorMessage){
        return new BaseResponse(code, errorMessage, null);
    }


    public static BaseResponse error(Throwable t){
        return BaseResponse.fail(null);
    }

}
