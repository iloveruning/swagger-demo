package com.iflytek.stream.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * 原生实现
 *
 * @author llchen12
 * @date 2018/5/16
 */
@EnableBinding(value = {Processor.class})
public class ReceiveAndSend2 {

    private Logger logger=LoggerFactory.getLogger(ReceiveAndSend2.class);


   @ServiceActivator(inputChannel = Processor.INPUT,outputChannel = Processor.OUTPUT)
    public Object receiveAndSend(Object msg){
        logger.info("Received: "+msg);
        return "From Input Channel Return: "+msg;
    }

}
