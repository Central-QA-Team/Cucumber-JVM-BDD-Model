package myBBC_Common.config;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import myBBC_Common.model.ProfilePairs;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

public abstract class AbstractEnvironmentConfig {

    @Autowired
    Environment environment;

    AbstractEnvironmentConfig() {
        String property = System.getProperty("spring.profiles.active");
        if (StringUtils.isEmpty(property)) {
            throw new IllegalArgumentException("Invalid spring.profiles.active:" + property);
        }
        String[] profiles = property.split(",");
        if (profiles.length != 2) {
            throw new IllegalArgumentException("Invalid spring.profiles.active:" + property);

        }
        boolean validProfiles = ProfilePairs.isAllowed(profiles[0], profiles[1]);
        if (!validProfiles) {
            throw new IllegalArgumentException("Invalid spring.profiles.active:" + property);

        }

    }

    protected Boolean getBooleanProperty(String propertyName) {
        return Boolean.valueOf(getStringProperty(propertyName));

    }

    protected Integer getIntegerProperty(String propertyName) {
        return Integer.valueOf(getStringProperty(propertyName));

    }

    protected String getStringProperty(String propertyName) {
        return environment.getProperty(propertyName);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    protected DynamoDBMapperConfig buildDynamoDBMapperConfigWith(DynamoDBMapperConfig.SaveBehavior saveBehavior,
                                                                 DynamoDBMapperConfig.ConsistentReads consistentReads,
                                                                 DynamoDBMapperConfig.TableNameOverride tableNameOverride) {
        return new DynamoDBMapperConfig.Builder().
                withSaveBehavior(saveBehavior).
                withConsistentReads(consistentReads).
                withTableNameOverride(tableNameOverride).build();
    }

}
