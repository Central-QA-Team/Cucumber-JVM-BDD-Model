package myBBC_Common.dynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import java.util.List;
import java.util.Map;

public interface IntegrationDbClient {

    String getRecord(String personId, DynamoDBMapperConfig config);

}
