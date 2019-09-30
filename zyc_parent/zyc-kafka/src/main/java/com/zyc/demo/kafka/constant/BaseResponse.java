package com.zyc.demo.kafka.constant;/**
 * @Description: TODO
 * @author zhouyicai
 * @date 2018/9/10 12:30
 */

public class BaseResponse {
    private Integer status;
    private Object result;

    public BaseResponse(Integer status, Object result) {
        this.status = status;
        this.result = result;
    }

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", result=" + result +
                '}';
    }
}
