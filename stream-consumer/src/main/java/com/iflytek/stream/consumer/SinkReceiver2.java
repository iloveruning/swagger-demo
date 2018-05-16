package com.iflytek.stream.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import java.io.IOException;

/**
 * spring integration原生方式接收消息
 *
 * @author llchen12
 * @date 2018/5/16
 */
//@EnableBinding(value = {Sink.class})
public class SinkReceiver2 {

    private Logger logger=LoggerFactory.getLogger(SinkReceiver2.class);

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(User msg){
        logger.info("Received: "+msg);
    }

    @Transformer(inputChannel = Sink.INPUT,outputChannel = Sink.INPUT)
    public User transform(String msg) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(msg,User.class);
    }
}
