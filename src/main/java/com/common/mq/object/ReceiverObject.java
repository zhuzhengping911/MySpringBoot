package com.common.mq.object;

import com.compont.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhengping on 2017/2/27.
 */
@Component
@RabbitListener(queues = "object")
public class ReceiverObject {


    @RabbitHandler
    public void process(User user){
        System.out.println("receiver object:" + user);
    }
}
