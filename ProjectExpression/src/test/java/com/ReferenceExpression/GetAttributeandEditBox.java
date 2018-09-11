package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetAttributeandEditBox {



    private WebDriver driver;

    @Before
    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sjain1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get("");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }


    @Test
    public void handlingEditBox(){

       driver.get("https://www.gmail.com/");

       //DISPLAY STATUS
       boolean displayStatus = driver.findElement(By.id("identifierId")).isDisplayed();
       System.out.println(displayStatus); //True

       //ENABLED STATUS
       boolean enabledStatus = driver.findElement(By.id("identifierId")).isEnabled();
       System.out.println(enabledStatus);
       waitForSometime();

       driver.findElement(By.id("identifierId")).sendKeys("ham427115");
       waitForSometime();

    // RETURNING ANY VALUE NEED TO USE "ATTRIBUTE COMMAND"##########
     //getAttribute()  ##############
     //ATTRIBUTE IN GMAIL.COM( type,autofocus,value" " )
        // VALUE FOR NOTHING BECAUSE BY DEFAULT EDITBOX THERE IS NO VALUE

    //GET ATTRIBUTE SYNTAX###################
    //CAN BE USE FOR EDITBOX,DROPDOWNBOX,BUTTON TITLE,NAME

        String Email = driver.findElement(By.id("identifierId")).getAttribute("value");
        System.out.println(Email);
        waitForSometime();
        driver.findElement(By.name("identifier")).clear();
        waitForSometime();
    }

    //2nd SYNTAX ################


    @Test
    public void editBox(){

        driver.get("https://www.gmail.com/");
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("ham427115");
        boolean displayStatus = email.isDisplayed();
        System.out.println(displayStatus);
        String emailAddress = email.getAttribute("value");
        System.out.println(emailAddress);
        waitForSometime();
        email.clear();
        waitForSometime();





    }


       public void waitForSometime() {


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



        @After
    public void tearDown()
    {

        driver.close();
        //driver.quit(); WHEN YOU ARE USING MULTIPLE BROWSERS NEED TO USE THIS COMMANDS

    }







}
