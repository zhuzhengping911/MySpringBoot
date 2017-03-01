package com.common.mq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhengping on 2017/3/1.
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hi,fanout msg";
        System.out.println("Sender Fanout:" + context);
        this.amqpTemplate.convertAndSend("fanoutExchange","",context);
    }
}
