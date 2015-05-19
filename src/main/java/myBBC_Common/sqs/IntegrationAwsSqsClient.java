package myBBC_Common.sqs;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.*;
import myBBC_Common.aws_credential.DefaultAWSCredentialProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class IntegrationAwsSqsClient implements IntegrationSqsClient {


    private DefaultAWSCredentialProvider credentialsProvider;
    private String queueUrl;
    private String endPoint;
    private ClientConfiguration clientConfigration;
    private static final Logger logger = LoggerFactory.getLogger(IntegrationAwsSqsClient.class);

    public IntegrationAwsSqsClient(DefaultAWSCredentialProvider credentialsProvider, ClientConfiguration clientConfigration, String queueUrl, String endPoint) {
        this.credentialsProvider = credentialsProvider;
        this.clientConfigration = clientConfigration;
        this.queueUrl = queueUrl;
        this.endPoint = endPoint;

    }

    @Override
    public int findMessagesInQueue() {
        logger.info("Check for messages on queue " + queueUrl);
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl).withMaxNumberOfMessages(Integer.valueOf(10));;
        AmazonSQS sqsClient = new AmazonSQSClient(credentialsProvider.getCredentials(), clientConfigration);
        sqsClient.setEndpoint(endPoint);
        sleepInSeconds(10);
        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();
        return messages.size();
    }

    @Override
    public String sendToQueue(String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(queueUrl, message);
        AmazonSQS sqsClient = new AmazonSQSClient(credentialsProvider.getCredentials(), clientConfigration);
        sqsClient.setEndpoint(endPoint);

        SendMessageResult result = sqsClient.sendMessage(sendMessageRequest);
        return result.getMessageId();

    }

    protected void sleepInSeconds(int timeInSecs) {

        try {
            Thread.sleep(timeInSecs * 1000);
        } catch (InterruptedException e) {

        }

    }

}
