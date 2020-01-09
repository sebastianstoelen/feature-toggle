package be.vdab.ponos.featuretoggle.toggle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class FeatureLoader {

    private static Logger log = LoggerFactory.getLogger(FeatureLoader.class);

    private final FeatureToggleConfig featureToggleConfig;

    public FeatureLoader(FeatureToggleConfig togglesConfig) {
        this.featureToggleConfig = togglesConfig;
    }

    @PostConstruct
    public void initializeToggles() {
        this.featureToggleConfig.getToggles().forEach(this::initializeToggle);
    }

    private void initializeToggle(FeatureToggleConfig.Toggle config ) {
        try {
            Feature feature = Feature.valueOf(config.getName());
            feature.setEnabled(config.isEnabled());
            log.info("FEATURE TOGGLE {} enabled: {}", feature.toString(), feature.isEnabled());
        } catch (IllegalArgumentException ex) {
            log.warn("FEATURE TOGGLE: No feature found with name {}", config.getName());
        }
    }
}
