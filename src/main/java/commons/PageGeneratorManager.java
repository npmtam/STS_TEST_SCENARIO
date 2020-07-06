package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.GooglePageObject;

public class PageGeneratorManager {
    public static GooglePageObject getGooglePage(WebDriver driver){
        return new GooglePageObject(driver);
    }
}
