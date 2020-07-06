package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.GooglePageUI;

import java.util.List;

public class GooglePageObject extends AbstractPage {
    WebDriver driver;
    List<WebElement> elements;

    public GooglePageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void openURL(String URL){
        driver.get(URL);
    }

    public void inputToSearchTextbox(String keyword){
        waitToElementVisible(GooglePageUI.GOOGLE_SEARCH_TEXTBOX);
        sendKeyToElement(GooglePageUI.GOOGLE_SEARCH_TEXTBOX, keyword);
    }

    public void clickToSearch(){
        waitToElementClickable(GooglePageUI.GOOGLE_SEARCH_BTN);
        clickToElement(GooglePageUI.GOOGLE_SEARCH_BTN);
    }

    public boolean isTheResultsContainsKeyword(String keyword){
        List<String> textResults = getTextListElements(GooglePageUI.GOOGLE_SEARCH_RESULTS);
        return isArrayListContains(textResults, keyword);
    }

    public boolean isResultsAtPeopleAlsoAskContainsKeyword(String keyword){
        List<String> results = getTextListElements(GooglePageUI.GOOGLE_HOW_PEOPLE_ASK_RESULTS);
        return isArrayListContains(results, keyword);
    }

    public boolean isResultsAtTopStoriesContainsKeyword(String keyword){
        List<String> topStories = getTextListElements(GooglePageUI.GOOGLE_TOP_STORIES_RESULTS);
        return isArrayListContains(topStories, keyword);
    }

    public boolean isResultsAtVideosContainsKeyword(String keyword){
        List<String> videoResults = getTextListElements(GooglePageUI.GOOGLE_VIDEOS_RESULTS);
        return isArrayListContains(videoResults, keyword);
    }

    public boolean isInputtedStringRemained(String keyword){
        String inputtedString = getAttributeValue(GooglePageUI.GOOGLE_SEARCH_TEXTBOX, "value");
        System.out.println(inputtedString);
        return inputtedString.contains(keyword);
    }
}
