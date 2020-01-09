package be.vdab.ponos.featuretoggle.service.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class NewCalculator implements Calculator {

    private static Logger log = LoggerFactory.getLogger(NewCalculator.class);

    @PostConstruct
    public void postConstruct() {
        log.info("USING NEW CALCULATOR");
    }

    @Override
    public void calculate() {
        log.info("Using new calculator");
    }
}
