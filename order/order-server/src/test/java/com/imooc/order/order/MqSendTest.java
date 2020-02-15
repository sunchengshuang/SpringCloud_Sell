package com.imooc.order.order;

import com.rabbitmq.tools.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;
import com.imooc.order.message.*;

/**
 *mq发送端
 */
@Slf4j
@Component
public class MqSendTest extends  OrderApplicationTests{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StreamClient streamClient;

 // 第一个MQ测试例子
//    @Test
//    public void send(){
//        amqpTemplate.convertAndSend("myQueue","new" + new Date());
//    }

//    @Test
//    public void sendOrder(){
//        amqpTemplate.convertAndSend("myQueue","computer","new" + new Date());
//        log.info("-----");
//    }

     @Test
     public void sendOrder(){
        String message = "now" + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }
    @Test
    public void sendOrder1(){
        System.out.println("www");

    }
}
