package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;
import utility.ConfigReader;

public class LoginPage {
    private WebDriver driver;
    BaseClass baseClass=new BaseClass(driver);

    @FindBy(xpath = "//input[@id=\"uid\"]")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id=\"passw\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@name=\"btnSubmit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//h1[contains(text(),'Hello Admin User')]")
    private WebElement successMessage;

    @FindBy(id = "_ctl0__ctl0_Content_Main_message")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        baseClass.waitForElementClickable(loginButton);
        loginButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
