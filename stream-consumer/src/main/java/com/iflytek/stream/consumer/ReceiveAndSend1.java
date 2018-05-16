package com.iflytek.stream.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * stream实现
 *
 * @author llchen12
 * @date 2018/5/16
 */
//@EnableBinding(value = {Processor.class})
public class ReceiveAndSend1 {

    private Logger logger=LoggerFactory.getLogger(ReceiveAndSend1.class);


    @StreamListener(value = Processor.INPUT)
    @SendTo(value = {Processor.OUTPUT})
    public Object receiveAndSend(Object msg){
        logger.info("Received: "+msg);
        return "From Input Channel Return: "+msg;
    }

}
