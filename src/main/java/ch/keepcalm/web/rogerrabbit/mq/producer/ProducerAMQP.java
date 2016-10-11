package ch.keepcalm.web.rogerrabbit.mq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by marcelwidmer on 09.10.16.
 */
@Configuration
public class ProducerAMQP implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ProducerAMQP.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... strings) throws Exception {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                logger.info("Sending an event...");

                rabbitTemplate.convertAndSend("roger-rabbit-queue", "Hello World");
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerAMQP.class, args);
    }
}
