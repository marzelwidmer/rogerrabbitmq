package ch.keepcalm.web.rogerrabbit.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by marcelwidmer on 09.10.16.
 */
@Component
public class ReceiverAMQP {
    private static final Logger logger = LoggerFactory.getLogger(ReceiverAMQP.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = "roger-rabbit-queue")
    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}


