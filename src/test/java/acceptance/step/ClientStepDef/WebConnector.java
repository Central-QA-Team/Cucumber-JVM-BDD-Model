package acceptance.step.ClientStepDef;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 07/08/15
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import javax.mail.*;
import javax.mail.search.SubjectTerm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class WebConnector {
    public WebDriver driver;
    static WebConnector w;
    final static Logger logger = Logger.getLogger(WebConnector.class.getName());
    public static final String USERNAME = "kalyanipatil2";
    public static final String AUTOMATE_KEY = "yRe1M5mzqUXP7oiBXpwz";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    private boolean isDevice = false;
    Cookie cookie = new Cookie.Builder("IDENTITY", "388605145386763531|~f0c3c377e614f4ca13801012c61c7bd4212bb59b||1420632267254|0|ce0c4330f67b1f2c556578b6474539a587c9d8bd0a3e:1").domain(".bbc.co.uk").build();

    Message[] messages = null;
    static boolean isMailFound = false;
    Message mailFromBBCiD= null;

    private WebConnector() {

    }

    public void openBrowser() throws MalformedURLException {

        if (driver == null) {

            String browserName = System.getProperty("browser");


            if (browserName.equalsIgnoreCase("MacChrome36.0")) {
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setPlatform(Platform.MAC);
                capability.setVersion("36.0");
                capability.setCapability("build", "myBBCNewsletters-MacChrome");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "MacChrome36.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("MacFireFox31.0")) {
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                capability.setPlatform(Platform.MAC);
                capability.setVersion("31.0");
                capability.setCapability("build", "myBBCNewsletters-MacFirefox31.0");
                capability.setCapability("browserstack.debug", true);
                isDevice = true;
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "MacFireFox31.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("MACSafari7.0")) {
                DesiredCapabilities capability = DesiredCapabilities.safari();
                capability.setPlatform(Platform.MAC);
                capability.setVersion("7.0");
                capability.setCapability("build", "myBBCNewsletters-MacSafari7.0");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "MACSafari7.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("WindowsIE11.0")) {
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setPlatform(Platform.WIN8);
                capability.setVersion("11.0");
                capability.setCapability("build", "myBBCNewsletters-WindowsIE");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "WindowsIE11.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("Windows7IE10.0")) {
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setPlatform(Platform.WINDOWS);
                capability.setVersion("10.0");
                capability.setCapability("build", "myBBCNewsletters-Windows7IE10.0");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "Windows7IE10.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("Windows7IE9.0")) {
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setPlatform(Platform.WINDOWS);
                capability.setVersion("9.0");
                capability.setCapability("build", "myBBCNewsletters-Windows7IE9.0");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "Windows7IE9.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("Windows7IE8.0")) {
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setPlatform(Platform.WINDOWS);
                capability.setVersion("8.0");
                capability.setCapability("build", "myBBCNewsletters-Windows7IE8.0");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "Windows7IE8.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("Windows8FF31.0")) {
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                capability.setPlatform(Platform.WIN8);
                capability.setVersion("31.0");
                capability.setCapability("build", "myBBCNewsletters-Windows8FF31.0");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "Windows8FF31.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("Windows8Chrome36.0")) {
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setPlatform(Platform.WIN8);
                capability.setVersion("36.0");
                capability.setCapability("build", "myBBCNewsletters-Windows8Chrome36.0");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "Windows8Chrome36.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("Windows8Opera12.16")) {
                DesiredCapabilities capability = DesiredCapabilities.opera();
                capability.setPlatform(Platform.WIN8);
                capability.setVersion("12.16");
                capability.setCapability("build", "myBBCNewsletters-Windows8Opera12.16");
                capability.setCapability("browserstack.debug", true);
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "Windows8Opera12.16 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("iPhone5Safari7.0")) {
                DesiredCapabilities capability = DesiredCapabilities.iphone();
                capability.setPlatform(Platform.MAC);
                capability.setCapability("device", "iPhone 5S");
                capability.setVersion("7.0");
                capability.setCapability("build", "myBBCNewsletters-iPhone5Safari7.0");
                capability.setCapability("browserstack.debug", true);
                isDevice = true;
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "iPhone5Safari7.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("iPad4Safari7.0")) {
                DesiredCapabilities capability = DesiredCapabilities.ipad();
                capability.setPlatform(Platform.MAC);
                capability.setCapability("device", "iPad 4th Gen");
                capability.setVersion("7.0");
                capability.setCapability("build", "myBBCNewsletters-iPad4Safari7.0");
                capability.setCapability("browserstack.debug", true);
                isDevice = true;
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "iPad4Safari7.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("SamsungS3Android4.1")) {
                DesiredCapabilities capability = DesiredCapabilities.android();
                capability.setPlatform(Platform.ANDROID);
                capability.setCapability("device", "Samsung Galaxy S3");
                capability.setVersion("4.1");
                capability.setCapability("build", "myBBCNewsletters-SamsungS3Android4.1");
                capability.setCapability("browserstack.debug", true);
                isDevice = true;
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "SamsungS3Android4.1 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("GoogleNexus7Android4.1")) {
                DesiredCapabilities capability = DesiredCapabilities.android();
                capability.setPlatform(Platform.ANDROID);
                capability.setCapability("device", "Google Nexus 7");
                capability.setVersion("4.1");
                capability.setCapability("build", "myBBCNewsletters-GoogleNexus7Android4.1");
                capability.setCapability("browserstack.debug", true);
                isDevice = true;
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "GoogleNexus7Android4.1 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("SamsungGalaxyNote10.1Android4.0")) {
                DesiredCapabilities capability = DesiredCapabilities.android();
                capability.setPlatform(Platform.ANDROID);
                capability.setCapability("device", "Samsung Galaxy Note 10.1");
                capability.setVersion("4.0");
                capability.setCapability("build", "myBBCNewsletters-SamsungGalaxyNote10.1Android4.0");
                capability.setCapability("browserstack.debug", true);
                isDevice = true;
                driver = new RemoteWebDriver(new URL(URL), capability);
                logger.info("Launching the Browser: " + "SamsungGalaxyNote10.1Android4.0 on BrowserStack");
            }

            if (browserName.equalsIgnoreCase("LocalFirefox")) {
                isDevice = true;
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                logger.info("Launching the Browser: " + "LocalFirefox");
            }

            if (browserName.equalsIgnoreCase("LocalChrome")) {
                isDevice = true;
                final String chromedriverLocation = "src/main/resources/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromedriverLocation);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-web-security");
                options.addArguments("--disable-popup-blocking");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
                driver = new ChromeDriver(capabilities);
                driver.manage().window().maximize();
                logger.info("Launching the Browser: " + "LocalChrome");
            }


            if (browserName.equalsIgnoreCase("MacLocalSafari")) {
                driver = new SafariDriver();
                logger.info("Launching the Browser: " + "MacLocalSafari");
            }

        }

    }

    public void navigate() {
        String url =System.getProperty("url");
        driver.navigate().to(System.getProperty("baseUrl")+url);
        logger.info("Navigating to the LandingPage");
    }


    /**
     * *****Singleton*********
     */
    public static WebConnector getInstance() {
        if (w == null)
            w = new WebConnector();
        return w;
    }


    public void quit(){
        driver.quit();
        logger.info("Quitting the Browser");
    }


    public void signOut() {

        String Env = System.getProperty("Env");
        driver.navigate().to("https://ssl."+Env+".bbc.co.uk/id/signout?ptrt=http%3A%2F%2Fwww."+Env+".bbc.co.uk%2Fuasclient%2F"+Env);


        //  if (driver.manage().getCookieNamed("IDENTITY") != null) {
        //    driver.manage().deleteCookie(cookie);
        logger.info("Sign out of BBCID");
        //  }
        navigate();
    }


    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
        logger.info("Implicit wait for seconds:" + seconds);
    }


    public void readInxmail(String emailSubject, String email, String password) throws Exception {
        logger.info("Fetching the email");
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "www-cache.reith.bbc.co.uk");
        props.put("mail.smtp.port", "80");
        props.put("mail.socket.debug", "true");
        props.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", email, password);

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE);

//        System.out.println("Total Message:" + folder.getMessageCount());
//        System.out.println("Unread Message:"
//                + folder.getUnreadMessageCount());


        //Search for mail from BBCiD
        for (int i = 0; i<5; i++) {
            messages = folder.search(new SubjectTerm(emailSubject),
                    folder.getMessages());
            //Wait for 10 seconds
            if (messages.length == 0) {
                Thread.sleep(10000);
            }
        }

        searchForUnreadEmails();

        //Search for unread mail from BBCiD
        //This is to avoid using the mail for which is already read
//        for (Message mail : messages) {
//            if (!mail.isSet(Flags.Flag.SEEN)) {
//                mailFromBBCiD = mail;
//                System.out.println("Message Count is: "
//                        + mailFromBBCiD.getMessageNumber());
//                isMailFound = true;
//            }
//        }

        //WebConnector fails if no unread mail was found from BBCiD
        if (!isMailFound) {
            driver.navigate().refresh();
            searchForUnreadEmails();
            driver.navigate().refresh();
//            throw new Exception(
//                    "Could not find new mail from BBCiD :-(");

            //Read the content of mail and launch registration URL
        }
        else {
            String line;
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(mailFromBBCiD
                            .getInputStream()));
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            //System.out.println(buffer);


            //logic to split the message and get the Registration URL goes here
            String emailContent = buffer.toString();
            String[] splitEmailContent = emailContent.split("http://");
            String registrationURL = "http://" + splitEmailContent[1];
            //System.out.println(registrationURL);
            String[] auto = registrationURL.split("Cheers");
            String confirmNewsletterSubscriptionEmailLink = auto[0];
            //System.out.println(confirmNewsletterSubscriptionEmailLink);
            driver.navigate().to(confirmNewsletterSubscriptionEmailLink);
        }
    }

    public void searchForUnreadEmails() throws MessagingException {
        for (Message mail : messages) {
            if (!mail.isSet(Flags.Flag.SEEN)) {
                mailFromBBCiD = mail;
//            System.out.println("Message Count is: "+ mailFromBBCiD.getMessageNumber());
                isMailFound = true;
            }
        }
    }
}
