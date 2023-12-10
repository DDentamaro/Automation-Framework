package Pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class CheckOutPage {
    private WebDriver driver;

    public CheckOutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    public void provideUserDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(firstName));
        wait.until(ExpectedConditions.visibilityOf(lastName));
        wait.until(ExpectedConditions.visibilityOf(postalCode));
        firstName.sendKeys("abc");
        lastName.sendKeys("cbb");
        postalCode.sendKeys("70024");

    }
    public void clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));

        continueButton.click();
    }
}
