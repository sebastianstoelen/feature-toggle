package be.vdab.ponos.featuretoggle.toggle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class FeatureLoader {

    private static Logger log = LoggerFactory.getLogger(FeatureLoader.class);

    private final ToggleConfigurationObject toggleConfigurationObject;

    public FeatureLoader(ToggleConfigurationObject togglesConfig) {
        this.toggleConfigurationObject = togglesConfig;
    }

    @PostConstruct
    public void initializeToggles() {
        this.toggleConfigurationObject.getAllFeatureToggles().forEach(this::initializeToggle);
    }

    private void initializeToggle(ToggleConfigurationObject.FeatureToggleConfig config ) {
        try {
            Feature feature = Feature.valueOf(config.getName());
            feature.setEnabled(config.isEnabled());
            log.info("FEATURE TOGGLE {} enabled: {}", feature.toString(), feature.isEnabled());
        } catch (IllegalArgumentException ex) {
            log.warn("No feature found with name {}", config.getName());
        }
    }
}
