package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.TransferFundPage;
import utility.DriverFactory;

public class TransferFund {

    private WebDriver driver;
    private TransferFundPage transPage;

    public TransferFund() {
        this.driver = DriverFactory.getDriver();
        this.transPage = new TransferFundPage(driver);
    }



    @Given("I am click on transfer fund")
    public void i_am_click_on_transfer_fund() {
        transPage.clickTransFund();
    }

    @When("I select account from")
    public void i_select_account_from() throws InterruptedException {
        transPage.selectFromAcc();
    }

    @When("I select account to and enter amount")
    public void i_select_account_to_and_enter_amount() {
        transPage.selectTOAcc();
        transPage.enterAmount();
    }

    @When("I click on transfer money")
    public void i_click_on_transfer_money() {
        transPage.clickOnMoneyTra();
    }

    @Then("Amount is transfer successfully with information message.")
    public void amount_is_transfer_successfully_with_information_message() {
        transPage.amoutTransered();
    }

}
