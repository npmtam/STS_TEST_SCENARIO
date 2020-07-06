package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AbstractPage{
    WebDriver driver;
    WebElement element;
    By by;
    Select select;
    JavascriptExecutor jsExecutor;
    WebDriverWait waitExplicit;
    List<WebElement> elements;
    long shortTimeout = 3;
    long longTimeout = 30;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    //WEB ELEMENTS
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

    public List<String> getTextListElements(String locator) {
        String textElement = null;
        List<String> allText = new ArrayList<String>();
        elements = driver.findElements(By.xpath(locator));
        for (WebElement item : elements) {
            scrollToElement(item);
            textElement = item.getText();
//            System.out.println(textElement);
            allText.add(textElement);
        }
        return allText;
    }

    public boolean isArrayListContains(List<String> arraylist, String keyword){
        for(String str : arraylist){
            if(!str.toLowerCase().contains(keyword)){
                return false;
            }
        }return true;
    }
}
