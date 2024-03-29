package com.yzl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/config")
@RestController
@RefreshScope//动态更新rabbitMQ
public class HelloController {

    @Value("${server.port}")
    private int port;

    @RequestMapping(value = "/index")
    public String index(){
        return "当前端口："+this.port;
    }
}