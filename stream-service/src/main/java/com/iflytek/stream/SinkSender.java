package com.iflytek.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author llchen12
 * @date 2018/5/16
 */
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
