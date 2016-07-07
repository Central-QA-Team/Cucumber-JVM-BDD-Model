package acceptance;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 28/04/15
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-report", "json:target/cucumber-report.json"},
        features = {"classpath:acceptance/feature"},
        glue = {"acceptance/step/ClientStepDef"},
        tags = {"@chrome"},
        strict = true)
public class AcceptanceITCaseChrome {

}