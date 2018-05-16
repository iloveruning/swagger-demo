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
public class SinkReceiver3 {

    private Logger logger=LoggerFactory.getLogger(SinkReceiver3.class);

    @StreamListener(Sink.INPUT)
    public void receive(User payload){
        logger.info("Received: "+payload);
    }

    //    配置属性如下：
//    # Comsumer Group:input
//    spring.cloud.stream.bindings.input.group=Service-A
//
//    # Partition
//    spring.cloud.stream.bindings.input.destination=greetings
//    spring.cloud.stream.bindings.input.consumer.partitioned=true
//    spring.cloud.stream.instanceCount=2
//    spring.cloud.stream.instanceIndex=0

}
