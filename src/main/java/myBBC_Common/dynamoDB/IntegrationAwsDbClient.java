package myBBC_Common.dynamoDB;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import myBBC_Common.aws_credential.DefaultAWSCredentialProvider;
import myBBC_Common.model.aws.DynamoTableEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegrationAwsDbClient implements IntegrationDbClient {


    private DefaultAWSCredentialProvider credentialsProvider;
    private ClientConfiguration clientConfigration;
    private String endPoint;
    private static final Logger logger = LoggerFactory.getLogger(IntegrationAwsDbClient.class);


    public IntegrationAwsDbClient(DefaultAWSCredentialProvider credentialsProvider, ClientConfiguration clientConfigration, String endPoint) {
        this.credentialsProvider = credentialsProvider;
        this.clientConfigration = clientConfigration;
        this.endPoint = endPoint;

    }

    private DynamoDBMapper getReadDBMapper() {
        AmazonDynamoDB readDynamoDBClient = new AmazonDynamoDBClient(credentialsProvider.getCredentials(), clientConfigration);
        readDynamoDBClient.setEndpoint(endPoint);
        DynamoDBMapper readMapper = new DynamoDBMapper(readDynamoDBClient);
        return readMapper;
    }

    private DynamoDBMapper getWriteDBMapper() {
        AmazonDynamoDB writeDynamoDBClient = new AmazonDynamoDBClient(credentialsProvider.getCredentials(), clientConfigration);
        writeDynamoDBClient.setEndpoint(endPoint);
        DynamoDBMapper writeMapper = new DynamoDBMapper(writeDynamoDBClient);
        return writeMapper;
    }

    @Override
    public String getRecord(String personId, DynamoDBMapperConfig config){
        logger.info("Searching Table " + config.getTableNameOverride().getTableName());
        DynamoTableEntry dynamoDBActivityQueryMask = new DynamoTableEntry();
        dynamoDBActivityQueryMask.setPersonId(personId);
        DynamoDBQueryExpression<DynamoTableEntry> queryExpression = new DynamoDBQueryExpression<DynamoTableEntry>();
        queryExpression.withHashKeyValues(dynamoDBActivityQueryMask).withConsistentRead(true).withScanIndexForward(false);
        PaginatedQueryList<DynamoTableEntry> results = getReadDBMapper().query(DynamoTableEntry.class, queryExpression, config);
        return results.get(0).getName();
    }


}
