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

public class CheckOutFinish {
    private WebDriver driver;

    public CheckOutFinish() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "back-to-products")
    private WebElement backHome;

    @FindBy(css = "#checkout_complete_container > h2")
    private WebElement checkOutTitle;


    public void clickBackHomeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(backHome));

        backHome.click();
    }

    public String getCheckOutTitle() {
        return checkOutTitle.getText();
    }

}

