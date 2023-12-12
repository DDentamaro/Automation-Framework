package Selenium;
import Pages.*;
import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;

import utils.Constants;
import utils.FrameworkProperties;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
        CheckOutOverview checkoutoverview = new CheckOutOverview();
        CheckOutFinish checkoutfinish = new CheckOutFinish();




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
        checkoutoverview.clickFinishButton();


        if(checkoutfinish.getCheckOutTitle().equals("Thank you for your order!"))
            System.out.println("Order delivered");
        else
            System.out.println("test failed");


        checkoutfinish.clickBackHomeButton();







    }
}