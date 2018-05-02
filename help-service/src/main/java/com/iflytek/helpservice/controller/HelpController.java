package com.iflytek.helpservice.controller;

import com.iflytek.helpservice.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author llchen12
 * @date 2018/5/2
 */
@RestController
@RequestMapping("help")
public class HelpController {


    @Autowired
    private HelloService helloService;

    @GetMapping("/")
    public String help(){

        return helloService.hello("help");
    }
}
