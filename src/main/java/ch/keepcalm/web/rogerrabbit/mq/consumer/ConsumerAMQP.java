package ch.keepcalm.web.rogerrabbit.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by marcelwidmer on 09.10.16.
 */
@Configuration
@SpringBootApplication
public class ConsumerAMQP {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerAMQP.class);

    @Bean
    public org.springframework.amqp.core.Queue demoQueue() {
        return new Queue("myQueue");
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAMQP.class, args);
    }
}