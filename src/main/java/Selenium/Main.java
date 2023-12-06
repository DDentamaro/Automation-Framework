package Selenium;
import Pages.CartPage;
import Pages.CartPage;
import Pages.SingInPage;
import Pages.HomePage;
import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.ShopPage;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://bitheap.tech/");

        HomePage homePage = new HomePage();
        SingInPage signInPage = new SingInPage();
        ShopPage shopPage = new ShopPage();
        CartPage cartPage = new CartPage();
        pages.CheckoutPage checkoutPage = new CheckoutPage();

        homePage.clickSignIn();
        signInPage.logIn("ddd", "dddddddd");

        if(homePage.getUsername().equals("Hello, ddd"))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");

        homePage.clickShopButton();

        shopPage.addElementToCart();
        shopPage.proceedToCheckout();
        cartPage.proceedToCheckout();
        checkoutPage.provideBillingDetails();
        checkoutPage.placeOrder();

        if(checkoutPage.getOrderStatus().equals("Order received"))
            System.out.println("Test Passed");
        else
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        DriverSingleton.closeObjectInstance();
    }
}

