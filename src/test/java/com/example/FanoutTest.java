package com.example;

import com.common.mq.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhuzhengping on 2017/3/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void FanoutTest(){
        fanoutSender.send();
    }
}
