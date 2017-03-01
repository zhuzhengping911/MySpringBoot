package com.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuzhengping on 2017/3/2.
 */
@Component
public class QuartzTask {

    private int count = 0;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "*/5 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running:" + (count++));
    }

    @Scheduled(fixedRate = 6000) //上一次执行开始点之后6秒执行
    public void reportCurrentTime(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
    @Scheduled(initialDelay = 1000, fixedRate = 6000) //第一次延迟1秒后执行，之后按fixedrate的规则每6秒执行一次
    public void reportCurrentTime2(){
        System.out.println("现在时间2：" + dateFormat.format(new Date()) + "测试时间2");
    }

    @Scheduled(fixedDelay = 10000) //上一次执行完毕点之后10秒再执行
    public void reportCurrentTime3(){
        System.out.println("现在时间3：" + dateFormat.format(new Date()) + "这是测试时间3");
    }
}
