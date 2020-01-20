package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    // 第一个Stream例子
//    @StreamListener("myMesssage1")
//    public void process(Object message){
//        log.info("StreamReceiver:{} ",message);
//    }

    /**
     * 接受orderDto对象 消息
     */
    @StreamListener(value = StreamClient.OUTPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO message){
        log.info("StreamReceiver:{} ",message);
        log.info("---------------------------------------");
        // 发送MQ消息
        return  "received.";
    }

    @StreamListener(value = StreamClient.OUTPUT2)
    public void process2(String message){
        log.info("StreamReceiver2:{} ",message);
        // 发送mq消息

    }
}
