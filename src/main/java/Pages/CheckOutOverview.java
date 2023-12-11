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

public class CheckOutOverview {
    private WebDriver driver;

    public CheckOutOverview() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement check;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(css = "#finish")
    private WebElement finishButton;

    public String getTitlePage() {
        return check.getText();
    }

    public void clickFinishButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));

        finishButton.click();
    }
    public void clickCancelButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));

        cancelButton.click();
    }


}
