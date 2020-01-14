package be.seba.poc.featuretoggle.toggle;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "feature-toggles")
public class FeatureToggleConfig {

    private List<Toggle> toggles;

    public List<Toggle> getToggles() {
        return toggles;
    }

    public void setToggles(List<Toggle> toggles) {
        this.toggles = toggles;
    }

    public static class Toggle {
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
