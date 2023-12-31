package automation.pages;

import automation.drivers.DriverSingleton;
import automation.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutYourInformationPage {
    private WebDriver driver;
    public CheckOutYourInformationPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    private WebElement insertFirstName;

    @FindBy(id = "last-name")
    private WebElement insertLastName;

    @FindBy(id = "postal-code")
    private WebElement insertCAP;

    @FindBy(id = "continue")
    private WebElement continueCheckOut;

    public void InsertYourInformation() {
        insertFirstName.sendKeys(Constants.FIRST_NAME_CHECKOUT);
        insertLastName.sendKeys(Constants.LAST_NAME_CHECKOUT);
        insertCAP.sendKeys(Constants.CAP_CHECKOUT);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(continueCheckOut));

        continueCheckOut.click();
    }
}
