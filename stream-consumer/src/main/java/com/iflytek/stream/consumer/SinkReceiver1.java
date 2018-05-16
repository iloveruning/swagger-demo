package com.iflytek.stream.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author llchen12
 * @date 2018/5/16
 */
//@EnableBinding(value = {Sink.class})
public class SinkReceiver1 {

    private Logger logger=LoggerFactory.getLogger(SinkReceiver1.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received: "+payload);
    }
}
