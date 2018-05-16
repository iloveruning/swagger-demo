package com.iflytek.track1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author llchen12
 * @date 2018/5/16
 */
@RestController
@RequestMapping("/trace-1")
public class Track1Controller {

    private Logger logger=LoggerFactory.getLogger(Track1Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String track(){
        logger.info("=====call trace-1==========");
        return restTemplate.getForEntity("http://trace-2/trace-2",String.class).getBody();
    }
}
