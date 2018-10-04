package stu.duongpth.rabbit_mq;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class EventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;

    @Autowired
    public EventPublisher(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    public void showMessage() {
        String routingKey = "foo";
        String message = "bar";
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, message);
    }
}
