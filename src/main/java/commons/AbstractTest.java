package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
    private WebDriver driver;
    String rootFolder = System.getProperty("user.dir");

    public final Log log;
    public AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    public void closeBrowserAndDriver(WebDriver driver) {
        try {
            // get OS name and convert to lower case
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS Name = " + osName);

            // Declare command line to execute
            String cmd = "";
            if(driver != null) {
                driver.quit();
            }

            if (driver.toString().toLowerCase().contains("chrome")) {
                if(osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            }else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if(osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            }else if (driver.toString().toLowerCase().contains("firefox")) {
                if(osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            }

            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();

            log.info("----------------QUIT BROWSER SUCCESS-----------------");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add error to ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

}
