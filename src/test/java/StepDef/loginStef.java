package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utility.DriverFactory;

public class loginStef {
    private WebDriver driver;
    private LoginPage loginPage;

    public loginStef() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get(utility.ConfigReader.getProperty("url"));
       // driver.get("https://demo.testfire.net/login.jsp");
    }

    @When("I enter valid user name as {string} and {string}")
    public void i_enter_valid_user_name_as_and(String username, String password) {
        System.out.println("THISTEST: "+utility.ConfigReader.getProperty(username));
        loginPage.enterUsername(utility.ConfigReader.getProperty(username));
        loginPage.enterPassword(utility.ConfigReader.getProperty(password));
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in to my account")
    public void i_should_be_logged_in_to_my_account() {
        String successMessage = loginPage.getSuccessMessage();
        System.out.println("Login success message: " + successMessage);
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword("invalidPassword");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String errorMessage = loginPage.getErrorMessage();
        System.out.println("Login error message: " + errorMessage);
    }
}
