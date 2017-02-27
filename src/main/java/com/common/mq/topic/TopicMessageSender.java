package com.common.mq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhengping on 2017/2/28.
 */
@Component
public class TopicMessageSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1(int i){
        String context = "hello,i am message 1:" + i;
        System.out.println("Sender: =================" + context);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.message",context);
    }

    public void send2(int i){
        String context = "hello,i am message 2:" + i;
        System.out.println("Sender: =================" + context);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.messages",context);
    }
}
