package be.vdab.ponos.featuretoggle.toggle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class FeatureLoader {

    private static Logger log = LoggerFactory.getLogger(FeatureLoader.class);

    @Value("${toggle.messages.axon.enabled:false}")
    private boolean axonMessagesEnabled;

    @Value("${toggle.calculator.version2.enabled:false}")
    private boolean calculatorVersion2Enabled;

    @PostConstruct
    public void initializeToggles() {
        if(axonMessagesEnabled) {
            Feature.SEND_MESSAGES_OVER_AXON.enable();
        }

        if(calculatorVersion2Enabled) {
            Feature.CALCULATOR_V2.enable();
        }

        log.info("FEATURE TOGGLE - Axon messages enabled: {}", Feature.SEND_MESSAGES_OVER_AXON.isEnabled());
        log.info("FEATURE TOGGLE - Calculator v2 enabled: {}", Feature.CALCULATOR_V2.isEnabled());
    }
}
