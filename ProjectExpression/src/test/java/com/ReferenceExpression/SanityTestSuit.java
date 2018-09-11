package com.ReferenceExpression;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SanityTestSuit {


    private WebDriver driver;
    @Before
    public void invokeBrowser() throws Exception{
        //Setting Chrome browser
        System.setProperty("web.chrome.driver", "chrome.exe");// Anna pls uncomment and add chrome driver exe file
        driver = new ChromeDriver();
        //Opening the home page
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();
        //Setting TimeOut
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @Test
    public void userInRegistration() {
        getElement(By.linkText("Register")).click();
        waitForSometime();
        driver.findElement(By.linkText("Register")).click();
        waitForSometime();
        getElement(By.id("gender-male")).click();
        waitForSometime();
        getElement(By.id("FirstName")).sendKeys("Mohamed");
        waitForSometime();
        getElement(By.id("LastName")).sendKeys("Hamza");
        waitForSometime();
//        driver.findElement(By.id("FirstName")).sendKeys("Mohamed");
//        waitForSometime();
//        driver.findElement(By.id("LastName")).sendKeys("Hamza");
//        waitForSometime();
        Select dropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dropdown.selectByIndex(10);
        waitForSometime();
        Select dropdown1 = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dropdown1.selectByVisibleText("March");
        waitForSometime();
        Select dropdown2 = new Select(driver.findElement(By.name("DateOfBirthYear")));
        dropdown2.selectByVisibleText("1985");
        waitForSometime();
        driver.findElement(By.id("Email")).sendKeys("barry@mail.com");
        waitForSometime();
        driver.findElement(By.id("Company")).sendKeys("Max ltd");
        waitForSometime();
        driver.findElement(By.id("Newsletter")).click();
        waitForSometime();
        driver.findElement(By.id("Password")).sendKeys("barry123");
        waitForSometime();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("barry123");
        waitForSometime();
        driver.findElement(By.id("register-button")).click();
        waitForSometime();
        driver.findElement(By.name("register-continue")).click();
        waitForSometime();
        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
        ClickClearSendKeys("locator","text");
    }
    public WebElement getElement(By by){ // method***************************

        WebElement element=  driver.findElement(by);


        return element;
    }

    public String getText(String locator){ // method****************
        String text=driver.findElement(By.cssSelector(locator)).getText();
        return text;

    }

    public void ClickClearSendKeys(String locator,String text){// new method............


        driver.findElement(By.cssSelector(locator)).click();
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    @Test
    public void userEnterinValidLoginDetails() {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.name("Email")).sendKeys("barry@mail.com");
        driver.findElement(By.id("Password")).sendKeys("barry123");
        driver.findElement(By.cssSelector(".button-1.login-button")).click();
        driver.findElement(By.className("ico-logout")).click();

    }

    @Test
    public void userEnteringInvalidLoginDetails()
    {
        ClickClearSendKeys("",""); // new method***********************PLS CHECK
        driver.findElement(By.linkText("Log in")).click();

        driver.findElement(By.name("Email")).sendKeys("barry@mail.com");
        driver.findElement(By.id("Password")).sendKeys("abc123");// invalid password
        driver.findElement(By.cssSelector(".button-1.login-button")).click();

        driver.findElement(By.cssSelector(".forgot-password>a")).click();

        Assert.assertTrue("Checking the Password recovery message shown in UI",getText("body").contains("Password recovery"));

    }

        @Test
        public void userSelectingAppleMacBookPro() {
            driver.findElement(By.linkText("Log in")).click();
            driver.findElement(By.name("Email")).sendKeys("barry@mail.com");
            driver.findElement(By.id("Password")).sendKeys("barry123");
            driver.findElement(By.linkText("Computers")).click();
            driver.findElement(By.linkText("Notebooks")).click();
            driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();

            driver.findElement(By.linkText("Add your review")).click();

            driver.findElement(By.id("AddProductReview_Title")).sendKeys("Apple Pro Mac Book");

            driver.findElement(By.id("AddProductReview_ReviewText")).sendKeys("Apple Pro Mac Book better than other laptop");
            driver.findElement(By.cssSelector("#addproductrating_4")).click();
            driver.findElement(By.name("add-review")).click();
        }
            @Test
            public void search(){

                //driver.findElement(By.id("searchText")).clear();
                driver.findElement(By.id("searchText")).sendKeys("demo.nopcommerce.com");
                driver.findElement(By.linkText("nopCommerce demo store")).click();
                driver.findElement(By.linkText("Register")).click();
                driver.findElement(By.id("gender-male")).click();
                driver.findElement(By.id("FirstName")).clear();
                driver.findElement(By.id("FirstName")).sendKeys("hamza");
                driver.findElement(By.id("LastName")).clear();
                driver.findElement(By.id("LastName")).sendKeys("hamza");
                new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("9");
                new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("April");
                new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1910");
                driver.findElement(By.id("Email")).clear();
                driver.findElement(By.id("Email")).sendKeys("test@testmail.com");
                driver.findElement(By.id("Company")).clear();
                driver.findElement(By.id("Company")).sendKeys("gt");
                driver.findElement(By.id("Password")).clear();
                driver.findElement(By.id("Password")).sendKeys("abc123");
                driver.findElement(By.id("ConfirmPassword")).clear();
                driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");
                driver.findElement(By.id("register-button")).click();
                driver.findElement(By.name("register-continue")).click();
            }

            public void waitForSometime(){


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            @After//closing the driver
            public void tearDown ()  {
                //close the driver
                driver.quit();

            }

        }
