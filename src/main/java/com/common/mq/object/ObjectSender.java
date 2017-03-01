package com.common.mq.object;

import com.compont.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhengping on 2017/2/28.
 */
@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user){
        System.out.println("sender object:" + user.toString());
        this.rabbitTemplate.convertAndSend("user",user);
    }
}
