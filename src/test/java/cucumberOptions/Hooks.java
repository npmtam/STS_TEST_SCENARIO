package cucumberOptions;

import commons.AbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks extends AbstractTest {
    private static WebDriver driver;

    @Before
    public static WebDriver openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-geolocation");
        chromeOptions.addArguments("--lang=en-GB");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    @After()
    public void quitBrowser(){
        closeBrowserAndDriver(driver);
    }
}
