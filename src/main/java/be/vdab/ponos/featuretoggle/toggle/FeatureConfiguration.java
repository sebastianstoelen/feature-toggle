package be.vdab.ponos.featuretoggle.toggle;

import be.vdab.ponos.featuretoggle.service.calculator.Calculator;
import be.vdab.ponos.featuretoggle.service.calculator.NewCalculator;
import be.vdab.ponos.featuretoggle.service.calculator.OldCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureConfiguration {

    private ToggleConfigurationObject toggleConfigurationObject;

    public FeatureConfiguration(ToggleConfigurationObject toggleConfigurationObject) {
        this.toggleConfigurationObject = toggleConfigurationObject;
    }

    //Making sure FeatureLoader bean is initialized before any conditional beans are loaded
    @Bean
    FeatureLoader featureLoader() {
        return new FeatureLoader(this.toggleConfigurationObject);
    }

    //Load in Calculater bean based on toggle
    @Bean
    Calculator calculator() {
        if (Feature.CALCULATOR_V2.isEnabled()) {
            return new NewCalculator();
        }
        return new OldCalculator();
    }
}
