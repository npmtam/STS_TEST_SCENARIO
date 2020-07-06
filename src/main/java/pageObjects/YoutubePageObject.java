package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageUIs.YoutubePageUI;

public class YoutubePageObject extends AbstractPage {
    WebDriver driver;
    Actions action;

    public YoutubePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
    }

    public void pressSpaceBtn(){
        action.sendKeys(Keys.SPACE).build().perform();
    }

    public void checkAdsAndWaitForSeconds(int timeout){
        if(isElementDisplayed(YoutubePageUI.YOUTUBE_AD_VIDEO)){
            int timeoutAfterAds = timeout-3;
            System.out.println("Ads displayed");
            sleepInSecond(6);
            if(isElementPresentInDOM(YoutubePageUI.YOUTUBE_SKIP_ADS_BUTTON)){
                waitToElementVisible(YoutubePageUI.YOUTUBE_SKIP_ADS_BUTTON);
                clickToElement(YoutubePageUI.YOUTUBE_SKIP_ADS_BUTTON);
                sleepInSecond(timeoutAfterAds-4);
            }
            sleepInSecond(timeoutAfterAds);
        }else{
            System.out.println("There's no Ads video");
            sleepInSecond(timeout);
        }
    }

    public void clickToPauseBtn(){
        hoverMouseToElement(YoutubePageUI.YOTUBE_PLAY_PAUSE_BUTTON);
        clickToElement(YoutubePageUI.YOTUBE_PLAY_PAUSE_BUTTON);
    }

    public boolean isVideoTitleSameResult(String titleInResult){
        return getTextElement(YoutubePageUI.YOUTUBE_VIDEO_TITLE).equals(titleInResult);
    }
}
