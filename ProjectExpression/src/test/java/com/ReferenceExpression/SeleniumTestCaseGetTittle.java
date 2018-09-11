package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumTestCaseGetTittle {





//    @Test
//    public void test1() throws MalformedURLException {
//
//
//        DesiredCapabilities cap=DesiredCapabilities.chrome();
//        cap.setPlatform(Platform.WIN10);
//        URL url =new URL("http://localhost:4444/wd/hub");
//        WebDriver driver=new RemoteWebDriver(url, cap);
//        driver.get("https://www.bbc.co.uk");
//
//
//
//
//
//    }










    private WebDriver driver;
    @Before
    public void invokeBrowser()throws Exception{


        System.setProperty("web.chrome.driver","chrome.exe");
        driver = new ChromeDriver();
        //driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    //DESCRIPTION : RETURNS THE CURRENT BROWSER TITTLE
    //SYNTAX:##########
    // String browserTittle = driver.getTittle()
    // browserTittle = name of the variable
    @Test
    public void getTittle(){

        driver.get("http://www.icicibank.co.uk/");
        String browserTittle = driver.getTitle();
        System.out.println(browserTittle);


    }



//     getCurrentUrl(): ###########
//    DESCRIPTION: RETURNS "CURRENT URL" OF THE BROWSER WINDOW.(URL IS A STRING TYPE DATA)
//    SYNTAX:##############
//    STRING browserURL=driver.getCurrentUrl();
    @Test
    public void getCurrentUrl()
    {

        driver.get("https://www.google.co.uk");
        String browserUrl=driver.getCurrentUrl();
        System.out.println(browserUrl);


    }
//    navigate().to() ##############//LOADS A NEW PAGE IN THE BROWSER WINDOW
//    SYNTAX:################
//    driver.navigate().to("url"):

    @Test
    public void navigateTo(){

        driver.get("https://www.google.co.uk");
        String browserUrl=driver.getCurrentUrl();
        System.out.println(browserUrl);
        driver.navigate().to("https://uk.yahoo.com/");
        System.out.println(browserUrl);




    }

//    navigate().back(); ###############
//    IT MOVES A SINGLE ITEM BACK IN THE BROWSER HISTORY.
//    LAUNCHING ANOTHER PAGE
//    SYNTAX:##############
//    driver.navigate().back();
//
    @Test
    public void navigateBack(){
        driver.get("https://www.google.co.uk");
        String browserUrl=driver.getCurrentUrl();

        driver.navigate().to("https://uk.yahoo.com/");

        driver.navigate().back();
        System.out.println(browserUrl);


    }
//
//     WITHOUT USING NAVIGATION COMMAND###########
    @Test
    public void getMethod(){

        driver.get("https://uk.yahoo.com/");
        driver.get("https://www.google.co.uk");
        System.out.println(driver.getCurrentUrl());


    }

//     navigate().forward() #######################
//     IT MOVES A SINGLE ITEM FORWARD IN THE BROWSER HISTORY
//
//     SYNTAX: ################
//     driver.navigate().forward();
    @Test
    public void navigateForward(){

        driver.get("https://www.google.co.uk");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("http://www.rediff.com/");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());


    }
//
//     navigate().refresh() ###################
//    SYNTAX: ####################
//     driver.navigate().refresh();
//
    @Test

    public void navigateRefresh(){

        driver.get("https://www.google.co.uk");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().refresh();




    }

    @After
    public void tearDown(){

        driver.quit();




    }


}
