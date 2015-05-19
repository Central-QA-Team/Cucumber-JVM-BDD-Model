package myBBC_Common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;


@Configuration
@Profile("test")
@PropertySource("classpath:test_end2endtest.properties")
@ComponentScan("myBBC_Common.*, acceptance.step.ClientStepDef.*")
public class TestEnvironmentSpringConfig extends CommonSpringConfig {


}
