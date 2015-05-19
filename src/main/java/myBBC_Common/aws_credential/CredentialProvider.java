package myBBC_Common.aws_credential;

import com.amazonaws.auth.AWSCredentials;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 28/04/15
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public interface CredentialProvider {
    public AWSCredentials getCredentials();
}
