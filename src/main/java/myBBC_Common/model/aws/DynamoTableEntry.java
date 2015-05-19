package myBBC_Common.model.aws;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 29/04/15
 * Time: 18:54
 * To change this template use File | Settings | File Templates.
 */
@DynamoDBTable(tableName = "test_table")
public class  DynamoTableEntry implements myBBC_Common.model.DynamoTableEntry {
    private String personId;
    private String name;
    private String occupation;

    @DynamoDBHashKey(attributeName = "personId")
    @Override
    public String getPersonId() {
        return personId;
    }

    @Override
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    @DynamoDBRangeKey(attributeName = "name")
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @DynamoDBAttribute(attributeName = "occupation")
    @Override
    public String getOccupation() {
        return occupation;
    }
    @Override
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
