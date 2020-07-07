package pageObjects;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import commons.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pageUIs.YoutubePageUI;

import java.util.concurrent.TimeUnit;

public class YoutubePageObject extends AbstractPage {
    WebDriver driver;
    Actions action;
    Wait<WebElement> fluentWait;

    public YoutubePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
    }

    public void pressSpaceBtn(){
        action.sendKeys(Keys.SPACE).build().perform();
    }

    public void waitForVideoPlay(int seconds){
        hoverMouseToElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED);
        waitToElementVisible(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED);
    }

    public void waitFor(){
        hoverMouseToElement(YoutubePageUI.YOUTUBE_PLAY_PAUSE_BUTTON);
        while(true){
            sleepInSecond(1);
            String countdown = getTextElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED);
            if(countdown.endsWith("10")){
                clickToPauseBtn();
                System.out.println("PASSED");
                break;
            }else{
                System.out.println("FAILED");
            }
        }

    }

    public void checkAdsAndWaitForSeconds(int timeout){
        if(isElementPresentInDOM(YoutubePageUI.YOUTUBE_AD_VIDEO)){
            sleepInSecond(6);
            if(isElementPresentInDOM(YoutubePageUI.YOUTUBE_SKIP_ADS_BUTTON)){
                waitToElementVisible(YoutubePageUI.YOUTUBE_SKIP_ADS_BUTTON);
                clickToElement(YoutubePageUI.YOUTUBE_SKIP_ADS_BUTTON);
                hoverMouseToElement(YoutubePageUI.YOUTUBE_PLAY_PAUSE_BUTTON);
//                waitFluentForElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED);
                waitFor();
            }
        }
        if(getTextElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED).contains("00")){
            hoverMouseToElement(YoutubePageUI.YOUTUBE_PLAY_PAUSE_BUTTON);
//            waitFluentForElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED);
            waitFor();
        }
    }

    public void clickToPauseBtn(){
        hoverMouseToElement(YoutubePageUI.YOUTUBE_PLAY_PAUSE_BUTTON);
        clickToElement(YoutubePageUI.YOUTUBE_PLAY_PAUSE_BUTTON);
    }

    public boolean isVideoTitleSameResult(String titleInResult){
        return getTextElement(YoutubePageUI.YOUTUBE_VIDEO_TITLE).equals(titleInResult);
    }

    public boolean isVideoPausedAccordingly(String timeout){
        hoverMouseToElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED);
        System.out.println(getTextElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED));
        return getTextElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED).endsWith(timeout);
    }
}
