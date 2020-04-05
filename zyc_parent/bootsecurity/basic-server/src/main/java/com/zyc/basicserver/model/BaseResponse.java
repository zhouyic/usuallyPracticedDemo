package com.zyc.basicserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class BaseResponse {

    private int code;
    private String message;
    private Object data;

    public BaseResponse(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse success(){
        return success(null);
    }

    public static BaseResponse success(Object data){
        return new BaseResponse(0, null, data);
    }

    public static BaseResponse fail(String message){
        return fail(1001, message);
    }

    public static BaseResponse fail(int code, String message){
        return new BaseResponse(code, message, null);
    }


}
