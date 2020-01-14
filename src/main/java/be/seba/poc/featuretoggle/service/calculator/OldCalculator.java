package be.seba.poc.featuretoggle.service.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class OldCalculator implements Calculator {

    private static Logger log = LoggerFactory.getLogger(OldCalculator.class);

    @PostConstruct
    public void postConstruct() {
        log.info("USING OLD CALCULATOR");
    }

    @Override
    public void calculate() {
        log.info("Using old calculator");
    }
}
