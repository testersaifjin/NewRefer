package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserCommands {


    private WebDriver driver;

    @Before
    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sjain1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get("");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }


    //BROWSER COMMANDS
    //1.get()
    //2.getTitle()
    //3.getCurrentUrl()
    //4.getWindowHandle()
    //5.close()
    //6.quite()


    @Test
    public void browserCommands(){

    driver.get("https://www.google.co.uk/");
    String browserTitle = driver.getTitle();
    String browserUrl = driver.getCurrentUrl();
    String windowHandle = driver.getWindowHandle();
    System.out.println(browserTitle);
    System.out.println(browserUrl);
    System.out.println(windowHandle);

//    String pageSource = driver.getPageSource();
//    System.out.println(pageSource);





    }








    @After
    public void tearDown()
    {

        driver.close();
        //driver.quit(); WHEN YOU ARE USING MULTIPLE BROWSERS NEED TO USE THIS COMMANDS

    }





}
