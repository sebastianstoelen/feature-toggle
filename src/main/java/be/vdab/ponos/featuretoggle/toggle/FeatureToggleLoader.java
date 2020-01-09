package be.vdab.ponos.featuretoggle.toggle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class FeatureToggleLoader {

    private static Logger log = LoggerFactory.getLogger(FeatureToggleLoader.class);

    private final FeatureToggleConfig featureToggleConfig;

    public FeatureToggleLoader(FeatureToggleConfig togglesConfig) {
        this.featureToggleConfig = togglesConfig;
    }

    @PostConstruct
    void initializeToggles() {
        this.featureToggleConfig.getToggles().forEach(this::initializeToggle);
    }

    private void initializeToggle(FeatureToggleConfig.Toggle config ) {
        try {
            Feature feature = Feature.valueOf(config.getName());
            feature.setEnabled(config.isEnabled());
            log.info("FEATURE TOGGLE \"{}\" enabled: {}", feature.toString(), feature.isEnabled());
        } catch (IllegalArgumentException ex) {
            log.warn("Unexpected toggle configuration: No feature found with name \"{}\"", config.getName());
        }
    }
}
