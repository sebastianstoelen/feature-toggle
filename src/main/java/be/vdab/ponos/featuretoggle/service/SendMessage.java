package be.vdab.ponos.featuretoggle.service;

import be.vdab.ponos.featuretoggle.toggle.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendMessage implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(SendMessage.class);

    @Override
    public void run() {
        sendMessage();
    }

    private void sendMessage() {
        sendMessageOverHttp();
        if (Feature.SEND_MESSAGES_OVER_AXON.isEnabled()) {
            sendMessageOverAxon();
        }
    }

    private void sendMessageOverHttp() {
        log.info("sending over http");
    }

    private void sendMessageOverAxon() {
        log.info("sending over axon");
    }
}
