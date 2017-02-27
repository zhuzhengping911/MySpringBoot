package com.example;

import com.common.mq.topic.TopicMessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhuzhengping on 2017/2/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicRabbitTest {

    @Autowired
    private TopicMessageSender topicMessageSender;

    @Test
    public void TopicTest1(){
        for (int i = 0;i < 10; i++){
            topicMessageSender.send1(i);
        }
    }

    @Test
    public void TopicTest2(){
        for (int i = 0;i < 10; i++){
            topicMessageSender.send2(i);
        }
    }
}
