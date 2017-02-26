package com.common;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhengping on 2017/2/26.
 * 接受者，接受者与发送者的queue必须一致才可以接收到信息
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver:" + hello);
    }
}
