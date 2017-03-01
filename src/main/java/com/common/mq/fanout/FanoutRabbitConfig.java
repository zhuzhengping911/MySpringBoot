package com.common.mq.fanout;

/**
 * Created by zhuzhengping on 2017/3/2.
 */

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuzhengping on 2017/3/1.
 * 订阅模式，给fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息
 * 这里使用了ABC三个队列绑定到fanout交换机上面,发送端的routing_key写任何字符都会被忽略
 */
@Configuration
public  class FanoutRabbitConfig {

    @Bean
    public Queue AMessage(){
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage(){
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage(){
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
