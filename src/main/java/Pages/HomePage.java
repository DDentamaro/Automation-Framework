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

public class HomePage {
    private WebDriver driver;

    public HomePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeFromCartButton;

    @FindBy(css = "#shopping_cart_container > a > span")
    private WebElement numberOfProducts;

    @FindBy(css = "#header_container > div.primary_header > div.header_label > div")
    private WebElement titlePage;

    public void clickCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));

        cartButton.click();
    }
    public void clickRemoveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(removeFromCartButton));

        removeFromCartButton.click();
    }

    public void addElementToCart() {

        addToCartButton.click();

        if(numberOfProducts.getText().contains(Constants.CART_QUANTITY))

            System.out.println("Cart has been updated ");

        else{
            System.out.println("Cart has not been updated ");

        }
    }




    public String getTitlePage() {
        return titlePage.getText();
    }

}
