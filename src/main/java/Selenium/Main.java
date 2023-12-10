package Selenium;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.LogInPage;
import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;

import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");

        HomePage homepage = new HomePage();
        LogInPage loginpage = new LogInPage();
        CartPage cartpage = new CartPage();
        CheckOutPage checkoutpage = new CheckOutPage();

        loginpage.clickLogInButton();
        loginpage.logIn("standard_user" ,"secret_sauce");

        if(homepage.getTitlePage().equals("Swag Labs"))
            System.out.println("Test Passed");
        else
            System.out.println("test failed");

        homepage.addElementToCart();
        homepage.clickCartButton();
        cartpage.clickCheckOutButton();
        checkoutpage.provideUserDetails();
        checkoutpage.clickContinueButton();




    }
}