package com.yy.base.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @RequestMapping("/doLogin")
    public String doLogin(){
        return "用户正在登录...";
    }
}
