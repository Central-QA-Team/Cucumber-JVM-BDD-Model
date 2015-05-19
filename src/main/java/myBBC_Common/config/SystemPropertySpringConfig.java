package myBBC_Common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;


@Configuration
@PropertySource("classpath:system_end2endtest.properties")
public class SystemPropertySpringConfig extends AbstractEnvironmentConfig {

    @Bean
    public Properties getSystemProperties() {
        Properties systemProperties = new Properties();
        System.setProperty("jsse.enableSNIExtension", getStringProperty("jsse.enableSNIExtension"));
        return systemProperties;
    }

}
