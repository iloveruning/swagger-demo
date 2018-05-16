package com.iflytek.stream.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * spring integration原生方式发送消息
 *
 * @author llchen12
 * @date 2018/5/16
 */
//@EnableBinding(value = {SinkOutput.class})
public class SinkSender {

    private Logger logger=LoggerFactory.getLogger(SinkSender.class);

    @Bean
    @InboundChannelAdapter(value = SinkOutput.OUTPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource(){
        return ()->new GenericMessage<>(new Date());
    }

    @Transformer(inputChannel = Sink.INPUT,outputChannel = SinkOutput.OUTPUT)
    public Object transform(Date msg){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(msg);
    }
}
