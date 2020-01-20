package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *接受MQ消息
 */
@Slf4j
@Component
public class MqReceiver {

////     第一个MQ例子
////     1.
//    @RabbitListener(queues = "myQueue")
// //    2. 自动创建队列
//     @RabbitListener(queuesToDeclare = @Queue("myQueue"))
//  //   3. 自动创建 ， Exchange 和 Queue 绑定
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("myQueue"),
//            exchange = @Exchange("myExchange")
//    ))
//    public  void process(String message){
//        log.info("MqReceiver:{}",message);
//    }

    /**
     * 数码供应商服务   接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myOrder"),
            key = "computer",
            exchange = @Exchange("computerOrder")
    ))
    public  void processComputer(String message){
        log.info("Computer  MqReceiver:{}",message);
    }

    /**
     * 数码供应商服务   接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myOrder"),
            key = "fruit",
            exchange = @Exchange("computerOrder")
    ))
    public  void processFruit(String message){
        log.info("Fruit  MqReceiver:{}",message);
    }
}
