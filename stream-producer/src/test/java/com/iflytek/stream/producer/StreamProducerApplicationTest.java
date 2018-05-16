package com.iflytek.stream.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author llchen12
 * @date 2018/5/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StreamProducerApplicationTest {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void testSinkSender(){
        sinkSender.output().send(MessageBuilder.withPayload("From sinkSender").build());
    }

    public interface SinkSender{

        String OUTPUT = "input";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();
    }
}
