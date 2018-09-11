package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGrid {


    public WebDriver driver;
    @Before
    public void invokeBrowser()throws Exception{


        System.setProperty("web.chrome.driver","chrome.exe");
        driver = new ChromeDriver();
//        System.setProperty("Webdriver.GeckoDriver","Gecko.exe");
//        driver=new GeckoDriverService();
        driver.get("http://demo.nopcommerce.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }



    @Test
    public void test1() throws MalformedURLException {

        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setPlatform(Platform.WINDOWS);
        URL url=new URL("http://localhost:4444/wd/hub");
        WebDriver driver=new RemoteWebDriver(url,cap);
        driver.get("http://demo.nopcommerce.com/");
        System.out.println("Tittle is"+driver.getTitle());


    }


    @After
    public void tearDown(){

        driver.quit();




    }



}
