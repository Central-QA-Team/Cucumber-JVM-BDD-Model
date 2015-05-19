package myBBC_Common.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import myBBC_Common.aws_credential.DefaultAWSCredentialProvider;
import myBBC_Common.dynamoDB.IntegrationAwsDbClient;
import myBBC_Common.sqs.IntegrationAwsSqsClient;
import myBBC_Common.sqs.IntegrationSqsClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.ConsistentReads.CONSISTENT;
import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.SaveBehavior.UPDATE;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 29/04/15
 * Time: 19:43
 * To change this template use File | Settings | File Templates.
 */
public class CommonSpringConfig extends AbstractEnvironmentConfig{

    @Bean(name= "DynamoDBTable")
    public DynamoDBMapperConfig DynamoDbTable() {
        String TableName = getStringProperty("table.name");
        DynamoDBMapperConfig tableConfig = buildDynamoDBMapperConfigWith(UPDATE, CONSISTENT, new DynamoDBMapperConfig.TableNameOverride(TableName));
        return tableConfig;
    }

    @Bean(name = "testQueue")
    public IntegrationSqsClient testQueue(@Qualifier("envCredentialsProvider") DefaultAWSCredentialProvider credentialsProvider, ClientConfiguration clientConfigration) {
        String archiveQueueUrl = getStringProperty("test.queue");
        String sqsEndpoint = getStringProperty("sqs.endpoint");
        return new IntegrationAwsSqsClient(credentialsProvider, clientConfigration, archiveQueueUrl, sqsEndpoint);
    }


    @Bean
    public ClientConfiguration clientConfigration() {
        ClientConfiguration clientConfig = new ClientConfiguration();
        Boolean useProxy = getBooleanProperty("useProxy");
        if (useProxy) {
            clientConfig.setProxyHost("www-cache.reith.bbc.co.uk");
            clientConfig.setProxyPort(80);
        }
        return clientConfig;
    }

    @Bean(name = "localDynamoDBClient")
    public IntegrationAwsDbClient amazonDynamoDB(@Qualifier("envCredentialsProvider") DefaultAWSCredentialProvider credentialsProvider, ClientConfiguration clientConfigration) {
        String dynamoDBEndpoint = getStringProperty("dynamodb.endpoint");
        return new IntegrationAwsDbClient(credentialsProvider, clientConfigration, dynamoDBEndpoint);
    }
}
