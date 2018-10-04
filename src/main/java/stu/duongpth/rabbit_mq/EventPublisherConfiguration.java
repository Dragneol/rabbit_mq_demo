package stu.duongpth.rabbit_mq;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventPublisherConfiguration {
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("eventExchange");
    }


    @Bean
    public EventPublisher eventPublisher(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        return new EventPublisher(rabbitTemplate, topicExchange);
    }
}
