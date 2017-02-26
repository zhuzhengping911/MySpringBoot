package com.common;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhuzhengping on 2017/2/26.
 * 发送者
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello" + new Date();
        System.out.println("sender:" + context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }
}
