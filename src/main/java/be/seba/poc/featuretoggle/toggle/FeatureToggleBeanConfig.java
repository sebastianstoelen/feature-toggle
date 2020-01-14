package be.seba.poc.featuretoggle.toggle;

import be.seba.poc.featuretoggle.service.calculator.Calculator;
import be.seba.poc.featuretoggle.service.calculator.NewCalculator;
import be.seba.poc.featuretoggle.service.calculator.OldCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureToggleBeanConfig {

    private FeatureToggleConfig featureToggleConfig;

    FeatureToggleBeanConfig(FeatureToggleConfig featureToggleConfig) {
        this.featureToggleConfig = featureToggleConfig;
    }

    //Making sure FeatureLoader bean is initialized before any conditional beans are loaded
    @Bean
    FeatureToggleLoader featureLoader() {
        return new FeatureToggleLoader(this.featureToggleConfig);
    }

    //Load in Calculator bean based on toggle
    @Bean
    Calculator calculator() {
        if (Feature.CALCULATOR_V2.isEnabled()) {
            return new NewCalculator();
        }
        return new OldCalculator();
    }
}
