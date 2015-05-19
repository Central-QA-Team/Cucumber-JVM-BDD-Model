package myBBC_Common.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 28/04/15
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
public class ProfilePairs {

    private static final Logger logger = LoggerFactory.getLogger(ProfilePairs.class);


    /**
     * Allow profiles to be interchangeable test,local = local,test
     *
     * @param p1
     * @param p2
     * @return
     */
    public static boolean isAllowed(String p1, String p2) {

        List<LocationProfile> locations = new ArrayList<LocationProfile>();
        List<EnvironmentProfile> environments = new ArrayList<EnvironmentProfile>();
        checkValidProfiles(locations, environments, p1);
        checkValidProfiles(locations, environments, p2);

        /**
         * Must have exactly one location and one environment
         */
        if (locations.size() != 1 || environments.size() != 1) {
            return false;
        }
        return true;
    }

    private static void checkValidProfiles(List<LocationProfile> locations, List<EnvironmentProfile> environments, String profile) {

        if (StringUtils.isEmpty(profile)) {
            logger.info("Profile empty or null");

            return;
        }

        try {
            locations.add(LocationProfile.valueOf(profile.toUpperCase()));
        } catch (IllegalArgumentException e1) {
            try {
                environments.add(EnvironmentProfile.valueOf(profile.toUpperCase()));
            } catch (IllegalArgumentException e2) {
                logger.info(String.format("Profile %s is neither a location or environment profile", profile));
            }
        }
    }

    private enum LocationProfile {

        LOCAL, SANDBOX, JENKINS;


    }

    private enum EnvironmentProfile {

        INT, TEST, LIVE, STAGE;

    }
}

