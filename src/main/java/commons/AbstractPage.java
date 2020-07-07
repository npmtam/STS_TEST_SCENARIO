package commons;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import pageUIs.YoutubePageUI;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    WebDriver driver;
    WebElement element;
    By by;
    JavascriptExecutor jsExecutor;
    WebDriverWait waitExplicit;
    List<WebElement> elements;
    Actions action;
    FluentWait<WebElement> fluentWait;
    long shortTimeout = 3;
    long longTimeout = 30;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    public void overrideGlobalTimeout(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public void clickToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void sendKeyToElement(String locator, String value) {
        element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(value);
    }

    public void waitToElementVisible(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToElementClickable(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void scrollToElement(WebElement element) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public String getAttributeValue(String locator, String attributeName) {
        element = driver.findElement(By.xpath(locator));
        return element.getAttribute(attributeName);
    }

    public boolean getTextHiddenElement(String locator, String expected){
        element = driver.findElement(By.xpath(locator));
        jsExecutor = (JavascriptExecutor) driver;
        String text = (String) jsExecutor.executeScript("return arguments[0].text();", element);
        return text.endsWith(expected);
    }

    public boolean verifyTextInInnerText(String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor
                .executeScript("document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public List<String> getTextListElements(String locator) {
        String textElement = null;
        List<String> allText = new ArrayList<String>();
        elements = driver.findElements(By.xpath(locator));
        for (WebElement item : elements) {
            scrollToElement(item);
            textElement = item.getText();
            allText.add(textElement);
        }
        return allText;
    }

    public String getTextElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public boolean isArrayListContains(List<String> arraylist, String keyword) {
        for (String str : arraylist) {
            if (!str.toLowerCase().contains(keyword)) {
                return false;
            }
        }
        return true;
    }

    public void sleepInSecond(long numberInSecond) {
        try {
            Thread.sleep(numberInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hoverMouseToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        action.moveToElement(element).perform();
    }

    public boolean isElementPresentInDOM(String locator) {
        overrideGlobalTimeout(shortTimeout);
        elements = driver.findElements(By.xpath(locator));
        overrideGlobalTimeout(longTimeout);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementDisplayed(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    public void waitFluentForElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        new FluentWait<WebElement>(element)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .until(new Function<WebElement, Boolean>() {
                    public Boolean apply(WebElement element) {
                        String innerText = getTextElement(YoutubePageUI.YOUTUBE_CURRENT_TIME_PLAYED);
                        System.out.println(innerText);
                        boolean flag = innerText.contains("0:10");
                        return flag;
                    }
                });
    }

}
