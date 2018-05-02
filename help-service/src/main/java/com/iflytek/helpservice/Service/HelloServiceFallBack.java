package com.iflytek.helpservice.Service;

/**
 * @author llchen12
 * @date 2018/5/2
 */
public class HelloServiceFallBack implements HelloService {


    @Override
    public String hello(String name) {
        return "fallback!";
    }
}
