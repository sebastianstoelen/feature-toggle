package be.vdab.ponos.featuretoggle;

import be.vdab.ponos.featuretoggle.toggle.FeatureToggleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "be.vdab.ponos")
@EnableConfigurationProperties(FeatureToggleConfig.class)
public class FeatureToggleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureToggleApplication.class, args);
	}

}
