package com.crr;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RibbitmqApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
    }

    @Autowired
    private AmqpAdmin amqpAdmin;
    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqp.crrexchange"));
    }


    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("amqp.crrqueue"));
    }
    @Test
    public void bindingQueueAndExchange(){
        System.out.println("11111111111");
        amqpAdmin.declareBinding(new Binding("amqp.crrqueue", Binding.DestinationType.QUEUE,"amqp.crrexchange","amqp.test",null));
    }

}
