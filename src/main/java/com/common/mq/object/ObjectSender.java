package com.common.mq.object;

import com.compont.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhengping on 2017/2/28.
 * 重写tostring方法后，可直接传输对象，并且在消费端可直接拿到对象的tostring后的结果
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
