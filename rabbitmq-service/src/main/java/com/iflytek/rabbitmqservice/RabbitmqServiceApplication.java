package com.iflytek.rabbitmqservice;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqServiceApplication {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServiceApplication.class, args);
    }
}
