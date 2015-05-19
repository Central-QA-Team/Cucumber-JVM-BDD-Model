package myBBC_Common.config;

import myBBC_Common.aws_credential.DefaultAWSCredentialProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 28/04/15
 * Time: 19:41
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@Profile("local")
@PropertySource("file:${user.home}/local_end2endtest.properties")
public class LocalSpringConfig extends AbstractEnvironmentConfig {

    @Bean(name = "envCredentialsProvider")
    public DefaultAWSCredentialProvider awsCredentials() throws IOException {
        System.setProperty("jsse.enableSNIExtension", getStringProperty("jsse.enableSNIExtension"));
        return new DefaultAWSCredentialProvider();
    }

}
