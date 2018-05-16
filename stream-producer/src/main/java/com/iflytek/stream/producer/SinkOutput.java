package com.iflytek.stream.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author llchen12
 * @date 2018/5/16
 */
public interface SinkOutput {

    String OUTPUT = "input";

    @Output(SinkOutput.OUTPUT)
    MessageChannel output();
}
