package com.iflytek.helpservice.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author llchen12
 * @date 2018/5/2
 */
@FeignClient(value = "hello-service",fallback = HelloServiceFallBack.class)
public interface HelloService {

    @GetMapping("/hello/{name}")
    String hello(@PathVariable("name") String name);

}
