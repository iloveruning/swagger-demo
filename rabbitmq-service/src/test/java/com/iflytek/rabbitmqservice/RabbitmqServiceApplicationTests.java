package com.iflytek.rabbitmqservice;

import com.iflytek.rabbitmqservice.producter.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqServiceApplicationTests {

    @Autowired
    private Producer producer;
    @Test
    public void contextLoads() {
        for (int i = 0; i < 100; i++) {
            producer.send();
        }

    }

}
