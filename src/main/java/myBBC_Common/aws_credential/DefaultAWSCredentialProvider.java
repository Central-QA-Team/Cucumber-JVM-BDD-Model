package myBBC_Common.aws_credential;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 28/04/15
 * Time: 19:39
 * To change this template use File | Settings | File Templates.
 */
public class DefaultAWSCredentialProvider implements CredentialProvider{
    private AWSCredentials credentials;
    public DefaultAWSCredentialProvider() {
        credentials = new DefaultAWSCredentialsProviderChain().getCredentials();
    }

    public DefaultAWSCredentialProvider(AWSCredentials awsCredentials) {
        credentials = awsCredentials;
    }

    @Override
    public AWSCredentials getCredentials() {
        return credentials;
    }
}
