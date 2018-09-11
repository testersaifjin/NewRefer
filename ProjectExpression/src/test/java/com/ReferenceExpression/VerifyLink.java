package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class VerifyLink {

    private WebDriver driver;
    @Before
    public void invokeBrowser()throws Exception{

        System.setProperty("web.chrome.driver","chrome.exe");
        driver = new ChromeDriver();
        //driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    //TEST CASE: VERIFY "GMAIL" LINK EXISTANCE IN GOOOGLE HOME PAGE.
    //TEST STEPS
    //(1) LAUNCH THE BROWSER
    //(2) NAVIGATE TO GOOGLE HOME PAGE

    //VERIFICATION POINT###############
    // VERIFY THE EXISTANCE OF THE "GMAIL" LINK

    //INPUT DATA######
    //(N/A)

    @Test
    public void elementExistance() {

        driver.get("https://www.google.co.uk/");
        boolean linkPresent = driver.findElement(By.linkText("Gmail")).isDisplayed();
        if (linkPresent == true) {
            // SUPPOSE IF WE PUT (==false) THEN THE TEST CASE WILL FAILED

            System.out.println("Gmail Link Exists - Passed");
        } else {

            System.out.println("Gmail Link Not Exists - Failed");

        }


    }

    @Test
    public void negativeTestCase(){

        driver.get("https://www.google.co.uk/");

        try {


            boolean linkPresent = driver.findElement(By.linkText("Yahoo")).isDisplayed();
            if (linkPresent){
                System.out.println("Gmail Link Exists - Passed");

            }

        }
        catch (NoSuchElementException e){


            System.out.println("Gmail Link Not Exists - Failed");
        }


    }




    @After
    public void tearDown(){


        driver.quit();



    }





}
