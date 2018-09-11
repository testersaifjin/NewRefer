package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VerificationCommands {

    private WebDriver driver;
    @Before
    public void invokeBrowser()throws Exception{

        System.setProperty("web.chrome.driver","chrome.exe");
        driver = new ChromeDriver();
        //driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    //isDisplayed()  #################
    // IN CUUTRENT WEB PAGE CHECK WHEATHER ELEMENT IS DISPLAYED OR NOT
    //SYNTAX:  ################
    // boolean variableName = driverObject.findElement(By.Element locator("value")).isDisplayed();


    //isEnabled()  #################
    // IN CUUTRENT WEB PAGE CHECK WHEATHER ELEMENT IS DISPLAYED OR NOT
    //SYNTAX:  ################
    // boolean variableName = driverObject.findElement(By.Element locator("value")).isEnabled();

    //isSlected()  #################
    // IN CUUTRENT WEB PAGE CHECK WHEATHER ELEMENT IS DISPLAYED OR NOT
    //SYNTAX:  ################
    // boolean variableName = driverObject.findElement(By.Element locator("value")).isSelected();



    // Note: isDisplayed() and isEnabled() commands are applicable of all types of Elements(eg: Links,
    //Button,Editbox etc....)
    // But isSelected() is only applicable for Radio Button and CheckBoxes

    @Test
    public void verificationCommands(){
        driver.get("http://www.gcrit.com/build3/create_account.php?osCsid=v50m7dgtgkhnkvqtpc4up2pfp3");
        WebElement checkBox = driver.findElement(By.name("newsletter"));
        boolean displayStatus = checkBox.isDisplayed();
        System.out.println(displayStatus); //True
        waitForSometime();
        boolean enebledStatus = checkBox.isEnabled();
        System.out.println(enebledStatus); // True
        waitForSometime();
        boolean selectedStatus = checkBox.isSelected();
        System.out.println(selectedStatus);// False
        checkBox.click();
        selectedStatus = checkBox.isSelected();
        System.out.println(selectedStatus);// true




    }

    public void waitForSometime() {


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
   @After
    public void tearDown(){


        driver.quit();



    }

}

