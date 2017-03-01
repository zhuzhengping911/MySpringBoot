package com.example;

import com.common.mq.object.ObjectSender;
import com.common.mq.hello.HelloSender;
import com.compont.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhuzhengping on 2017/2/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private ObjectSender objectSender;

    @Test
    public void hello(){
        helloSender.send();
    }

    /**
     *一对多，一个sender，两个receiver时，均分
     * 多对多时同样的均分
     */
    @Test
    public void oneToMany(){
        for (int i = 0;i < 100;i++){
            helloSender.send(i);
        }
    }

    /**
     * 适用对象，再重写了tostring方法后，接受可直接接收
     * 建议不使用object这种可能是关键字的queque
     *
     */
    @Test
    public void objectReceiver(){
        User user = new User("zzp","123","@qq.com","pp","");
        objectSender.send(user);
    }
}
