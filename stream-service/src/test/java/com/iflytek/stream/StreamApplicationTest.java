package com.iflytek.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author llchen12
 * @date 2018/5/16
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StreamApplicationTest {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void testSinkSender(){
        sinkSender.output().send(org.springframework.messaging.support.MessageBuilder.withPayload("sssssss").build());
    }
}
