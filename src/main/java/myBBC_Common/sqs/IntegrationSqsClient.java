package myBBC_Common.sqs;


public interface IntegrationSqsClient {

    public int findMessagesInQueue();

    public String sendToQueue(String message);

}
