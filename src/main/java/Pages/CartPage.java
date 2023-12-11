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

public class CartPage {

    private WebDriver driver;

    public CartPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeProduct;

    @FindBy(id = "checkout")
    private WebElement checkOutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    public void clickCheckOutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));

        checkOutButton.click();
    }
    public void clickContinueShoppingButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));

        continueShoppingButton.click();
    }
}
