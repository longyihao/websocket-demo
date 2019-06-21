package com.lyh.websocket.demo.contants;

import lombok.Data;

/**
 * Created by qiong on 2016/3/3.
 */
@Data
public class ResponseMessage {
    /**
     * 状态码
     */
    private int code=0;
    /**
     * 消息
     */
    private String message="";

    /**
     * 是否成功
     */
    private  boolean success =true;
    /**
     * 结果集
     */
    private Object result;

    private String errorMessage;

    /**
     * 失败结果集
     * @param message
     * @param result
     */
    private Object failInfo;

    public ResponseMessage(String message, Object result) {
        this.message = message;
        this.result = result;
    }
    public ResponseMessage(Object result,Object failInfo) {
        this.result = result;
        this.failInfo = failInfo;
    }
    public ResponseMessage(int code, String message, Object result,boolean success) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.success = success;
    }

    public ResponseMessage() {

    }

    public ResponseMessage(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResponseMessage(Object result) {
        this.result = result;
    }

    public ResponseMessage(String message) {
        this.message = message;
    }

}
