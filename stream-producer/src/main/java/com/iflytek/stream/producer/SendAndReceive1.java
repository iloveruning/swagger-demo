package com.iflytek.stream.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author llchen12
 * @date 2018/5/16
 */
@EnableBinding(value = {Processor.class})
public class SendAndReceive1 {

    private Logger logger=LoggerFactory.getLogger(SendAndReceive1.class);


    @Bean
    @InboundChannelAdapter(value = Processor.OUTPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource(){
        return ()->new GenericMessage<>(new Date());
    }

    @Transformer(inputChannel = Processor.INPUT,outputChannel = Processor.OUTPUT)
    public String transform(Date msg){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(msg);
    }

    @StreamListener(value = Processor.INPUT)
    public void receive(Object msg){
        logger.info("Received: "+msg);
    }
}
