package com.imooc.order.controller;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.message.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 *
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient  streamClient;
//  第一个stream 例子
//    @GetMapping("/sendMessage")
//    public void  process(){
//        String message = "now" + new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }

//    /**
//     * 发送orderDto对象
//     */
        @GetMapping("/sendMessage")
        public void  process(){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId("123456");
            streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
            System.out.print("111111");
        }
}
