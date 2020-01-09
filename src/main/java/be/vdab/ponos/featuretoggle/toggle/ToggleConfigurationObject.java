package be.vdab.ponos.featuretoggle.toggle;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "feature-toggles")
@Configuration
public class ToggleConfigurationObject {

    private List<FeatureToggleConfig> toggles;

    public void setToggles(List<FeatureToggleConfig> toggles) {
        this.toggles = toggles;
    }

    public List<FeatureToggleConfig> getAllFeatureToggles() {
        return this.toggles;
    }

    public static class FeatureToggleConfig {
        private String name;
        private boolean enabled;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public boolean isEnabled() {
            return enabled;
        }

    }
}
