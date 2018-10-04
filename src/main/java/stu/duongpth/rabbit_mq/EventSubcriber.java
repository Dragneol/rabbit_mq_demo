package stu.duongpth.rabbit_mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventSubcriber {

    private Logger logger = LoggerFactory.getLogger(EventSubcriber.class);

    public void receive(String message) {
        logger.info("Received message '{}'", message);
        System.out.println("Received message '{}'" + message);
    }
}
