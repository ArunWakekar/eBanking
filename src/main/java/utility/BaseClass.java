package utility;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.Scenario;

public class BaseClass {
    private WebDriver driver;
    private static final long DEFAULT_WAIT_TIME = 30;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    // Method to take a screenshot
    public void takeScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("./screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }

    // Method to take a screenshot and attach it to the Cucumber report
    public void takeScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    // Method to wait for an element to be visible
    public WebElement waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to wait for an element to be clickable
    public WebElement waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Method to wait for the page to load completely
    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    // Method to perform a fluent wait
    public WebElement fluentWait(final WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(DEFAULT_WAIT_TIME))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver -> element);
    }

    // Method to scroll to an element
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to hover over an element
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Method to double-click an element
    public void doubleClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Method to drag and drop an element
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // Method to select an option by visible text
    public void selectByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    // Method to select an option by value
    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // Method to select an option by index
    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // Method to get all options as a list of strings
    public List<String> getAllOptions(WebElement element) {
        Select select = new Select(element);
        return select.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    // Method to get the selected option as a string
    public String getSelectedOption(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }
}
