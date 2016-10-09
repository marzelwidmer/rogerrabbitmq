package ch.keepcalm.web.rogerrabbit.mq;

import java.util.concurrent.CountDownLatch;

/**
 * Created by marcelwidmer on 08.10.16.
 */
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
