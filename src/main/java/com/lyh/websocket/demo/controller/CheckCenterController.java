package com.lyh.websocket.demo.controller;

import com.lyh.websocket.demo.contants.ResponseMessage;
import com.lyh.websocket.demo.websocket.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController extends BaseController {

    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        System.out.println("cid::::::::"+cid);
        return mav;
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public ResponseMessage pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return FAIL(500,e.getMessage());
        }
        return SUCCESS(cid,message);
    }

    //推送数据接口
    @ResponseBody
    @RequestMapping(value = {"","hillo"})
    public ResponseMessage hillo() {

        return SUCCESS(200,"Hilloooooo");
    }


}
