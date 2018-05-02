package com.iflytek.rabbitmqservice.producter;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenliangliang
 * @date 2018/5/2
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate template;

    public void send(){
        template.convertAndSend("hello","hello"+new Date());
    }
}
