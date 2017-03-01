package com.common.mq.object;

import com.compont.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhengping on 2017/3/1.
 */
@Component
@RabbitListener(queues = "object")
public class ReceiverObject {

    @RabbitHandler
    public void process(User user){
        System.out.println("object user:" + user);
    }
}
