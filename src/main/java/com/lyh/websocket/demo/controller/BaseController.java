package com.lyh.websocket.demo.controller;

import com.lyh.websocket.demo.contants.ResponseMessage;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class BaseController {

    protected ResponseMessage SUCCESS(){
        return new ResponseMessage();
    }

    protected ResponseMessage SUCCESS(Object result){
        return new ResponseMessage(result);
    }

    protected ResponseMessage SUCCESS(String message){
        return new ResponseMessage(message);
    }

    protected ResponseMessage SUCCESS(String message, Object result){
        return new ResponseMessage(message, result);
    }

/*
    protected ResponseMessage FAIL(ResponseType rt){
        return new ResponseMessage(rt.code(),rt.message(),null,false);
    }

*/
    protected ResponseMessage FAIL(int code,String message){
        return new ResponseMessage(code,message,null,false);
    }

    protected ResponseMessage SUCCESS(Object result,Object failInfo){
        return new ResponseMessage(result,failInfo);
    }


    
    protected HttpServletRequest getRequest() {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	return request;
    }
   
    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  

    @Resource
    protected HttpServletRequest request;



}
