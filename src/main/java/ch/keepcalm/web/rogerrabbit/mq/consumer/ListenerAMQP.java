package ch.keepcalm.web.rogerrabbit.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by marcelwidmer on 09.10.16.
 */
@Component
public class ListenerAMQP {
    private static final Logger logger = LoggerFactory.getLogger(ListenerAMQP.class);


    @RabbitListener(queues = "ConsumerAMQP-QUEUE")
    public void onMessage(String data) {
        logger.info("ConsumerAMQP-QUEUE-ListenerConsumerAMQP : " + data);
    }
}


