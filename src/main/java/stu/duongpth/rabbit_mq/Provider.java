package stu.duongpth.rabbit_mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Provider implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Consumer consumer;

    public Provider(RabbitTemplate rabbitTemplate, Consumer consumer) {
        this.rabbitTemplate = rabbitTemplate;
        this.consumer = consumer;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message");
        rabbitTemplate.convertAndSend(RabbitMqApplication.topicExchageName, "foo.bar.baz", "Hello RabbitMQ");
        consumer.getLatch().await(1000, TimeUnit.MILLISECONDS);
    }
}
