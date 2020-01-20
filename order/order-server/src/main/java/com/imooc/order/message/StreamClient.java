package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;


/**
 *
 */
@Component
public interface StreamClient {

    /**
     * 第一个Stream例子
     */
//    @Input("myMesssage")
//    SubscribableChannel input();
//
//    @Output("myMesssage1")
//    MessageChannel output();
    /**
     * 第一个Stream例子
     */
    String INPUT = "input";
    String OUTPUT = "output";
    @Input(StreamClient.INPUT)
    SubscribableChannel input();
    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    String INPUT2 = "input2";
    String OUTPUT2 = "output2";
    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();
    @Output(StreamClient.OUTPUT2)
    MessageChannel output2();

//===========================
    //    String INPUT = "myMessage";
//    String OUTPUT = "myMessage";
//
//    String INPUT2 = "myMessage2";
//    String OUTUT2 = "myMessage2";
//
//    @Input(StreamClient.INPUT)
//    SubscribableChannel input();
//
//    @Output(StreamClient.OUTPUT)
//    MessageChannel output();
//
//    @Input(StreamClient.INPUT2)
//    SubscribableChannel input2();
//
//    @Output(StreamClient.OUTUT2)
//    MessageChannel output2();
}
