# Cucumber-JVM-BDD-Model
Cucumber - JVM - Webdriver - PhantomJs - Rest Assured - 

This is a common test repository containing helper methods to interact with AWS, web and API. This is a basic structure which testers can you and hook up with their respective project

Configuration:

Once you have done a check out of the project from above Git hub, you would need to follow these instructions:

1. Copy the local_end2endtest.properties file from Cucumber-JVM-BDD-Model\src\test\resources\local_end2endtest.properties directory and paste it onto your home directory i.e.  if using MAC this should be place /Users/[Your USER NAME]/ directory, on windows this should be on the root of your user location i.e. *C:\Users[YOUR USER NAME]* directory
    For above properties file, ensure you have provided path to:
        [Currently, Ignore the following 3 steps]
        a. Your developer certification file (.p12 file) against keyStoreLocation
        b. JS Security certicate against trustStoreLocation (this is attached within this wiki page, in case you don't already have it)
        c. Your developer certicate password against keyStorePassword

        d. useProxy should be set to false if you aren't on BBC network

    Ensure you have create the following as your environment variables:
        1. AWS_ACCESS_KEY_ID (with the value of your AWS access key)
        2. AWS_SECRET_KEY (with the value of your AWS secret key)
        Please note, you might want to setup these for your Eclipse/IntelliJ development environments too, so that you can run the tests with run configurations

Currently, we can run only the test TestWebclient.feature on phantomJs, Chrome and Firefox by configuring the system property "browser". To run the test for DynamoDb and Sqs, we need to add the model class or dependency to dev common code to interact with the AWS schema and queues.