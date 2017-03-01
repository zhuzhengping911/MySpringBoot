package com.common.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuzhengping on 2017/2/26.
 */

/**
 * 队列配置
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("user");
    }
}
