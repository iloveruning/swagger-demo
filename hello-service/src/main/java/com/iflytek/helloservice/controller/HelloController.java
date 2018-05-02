package com.iflytek.helloservice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author llchen12
 * @date 2018/5/2
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping("/{name}")
    @ApiOperation(value = "hello服务",notes = "hello服务")
    public String hello(@PathVariable("name") String name){
        return "hello: "+name;
    }

}
