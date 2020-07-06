package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.GooglePageObject;
import pageObjects.YoutubePageObject;

public class PageGeneratorManager {
    public static GooglePageObject getGooglePage(WebDriver driver){
        return new GooglePageObject(driver);
    }

    public static YoutubePageObject getYoutubePage(WebDriver driver){
        return new YoutubePageObject(driver);
    }
}
