package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundPage {

    private WebDriver driver;

    //===========WebElements==============//
    @FindBy(xpath = "//a[@id=\"MenuHyperLink3\"]")
    private WebElement FundTransBtn;

    @FindBy(xpath = "//select[@id=\"fromAccount\"]")
    private WebElement FromAcc;

    @FindBy(xpath = "//select[@id=\"toAccount\"]")
    private WebElement ToAcc;

    @FindBy(xpath = "//input[@id=\"transferAmount\"]")
    private WebElement enterAmount;

    @FindBy(xpath = "//input[@name=\"transfer\"]")
    private WebElement MoneyTr;

    @FindBy(xpath = "//span[@style=\"color: Red\"]")
    private WebElement successfulMess;



    public TransferFundPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

//===================Methods impimentation==============

public void clickTransFund(){
    FundTransBtn.click();
}

public void selectFromAcc(){
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    WebElement FromAcc;
//    FromAcc= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AccFrom")));
    Select sc=new Select(FromAcc);
        sc.selectByIndex(0);
        //sc.selectByValue("800000");
}

public void selectTOAcc(){
        Select SC1=new Select(ToAcc);
        SC1.selectByValue("800001");
}

public void enterAmount(){
    enterAmount.sendKeys("40000");
}

public void clickOnMoneyTra(){
    MoneyTr.click();
}

public void amoutTransered(){
    successfulMess.getText();
    System.out.println(successfulMess);
}

}
