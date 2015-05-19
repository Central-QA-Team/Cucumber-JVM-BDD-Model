package acceptance.step.ClientStepDef;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myBBC_Common.dynamoDB.IntegrationDbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 28/04/15
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
public class DynamoStepdefs {

    @Autowired
    @Qualifier("localDynamoDBClient")
    public IntegrationDbClient localDynamoDBClient;

    @Autowired
    @Qualifier("DynamoDBTable")
    public DynamoDBMapperConfig tableConfig;
    private String dataFromDB;


    @Given("^a user$")
    public void a_user() throws Throwable {
    }

    @When("^user send the data to dynamoDB$")
    public void user_send_the_data_to_dynamoDB() throws Throwable {
        System.out.println("TEST");
        try{
            System.out.println("------------------------------------------------------------------------------");
            Thread.dumpStack();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("^user query the data from db$")
    public void user_query_the_data_from_db() throws Throwable {
        String record = localDynamoDBClient.getRecord("1", tableConfig);
        dataFromDB= record;
    }

    @Then("^he should get the correct data$")
    public void he_should_get_the_correct_data() throws Throwable {
        assertEquals("Niranjan", dataFromDB);
    }
}
