package acceptance.step.ClientStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myBBC_Common.sqs.IntegrationSqsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import static myBBC_Common.util.FileUtils.readFromClassPath;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 13/05/15
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class SqsStepDef {

    @Autowired
    @Qualifier("testQueue")
    private IntegrationSqsClient testQueue;
    private static final String TEST_DATA_REQUEST_PATH = "testdata/";

    @When("^user send a message to queue$")
    public void user_send_a_message_to_queue() throws Throwable {
        StringBuilder sb = new StringBuilder(readFromClassPath("testData/MessageToQueue"));
        testQueue.sendToQueue(sb.toString());
    }

    @Then("^he should be able to view the message in queue$")
    public void he_should_be_able_to_view_the_message_in_queue() throws Throwable {
        System.out.println("Message in queue"+testQueue.findMessagesInQueue());
        assertEquals(1, testQueue.findMessagesInQueue());
    }

}
