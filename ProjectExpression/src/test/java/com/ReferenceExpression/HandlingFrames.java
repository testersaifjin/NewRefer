package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrames {


    public static WebDriver driver;

    @Before
    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sjain1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

        //SECTION OF WEB PAGES DIFINED AS FRAMES
        //HOW TO GET A FRAME COUNTER FRAME NAME:
        //LAUNCH FIREBUG
        //SELECT FIRE PATH
        //LEFT SIDE SELECT "TOP WINDOW", TOP WINDOW MEANS GROUP OF TEXT
        // FOR EXAMPLE I WANT TO CLICK ON 2ND LINK ON THIRD FRAME
        //NOTE: IN TEST AUTOMATION USING SELENIUM WEB DRIVER, FIRST WE NEED TO "SWITCH TO" A FRAME AND THEN WE CAN
        // ACCESS ELEMENTS IN THAT FRAME

        // REQUIRMENTS:
        // LAUNCH SELENIUM HQ WEBSITE SELECT DOWNLOAD TAB CLICK ON "JAVADOC" CLICK THE 5TH LINK IN THE 3RD FRAME.

        // UI INDEX STANDARS IS###################
        // FRAME INDEX  STARTS FROM 0-(n-1) TOP LEFT TO BOTTOM RIGHT#

        // SWITCH FROM "TOP WINDOW" TO A FRAME IS DONE IN TWO WAYS:
        //1. USING FRAME INDEX
        //2. USING FRAME NAME

        //1. USING FRAME INDEX######

        // SYNTAX:##############
        //driver.switchTo().frame(" String Frame Name");  ##############
        // INDEX STATUS FROM 0-(n-1)





        @Test
        public void handlingFrames() {

            //switch from the Top Window to 3rd Frame using Frame "Index"
            driver.switchTo().frame(2);
            waitForSometime();
            driver.findElement(By.linkText("org.openqa.selenium")).click();
            waitForSometime();


        }

        @Test
         public void frameName(){

            //switch from the Top Window to 3rd Frame using Frame "Name"
            // LAUNCH FIRE BUG SELECT FIRE PATH AND SELECT "HTML" SELECT ANY ELEMENT ANY FRAME THEN IT WILL SHOW
            // THE LINK ADDRESS IN THE (INSPECT ELEMENT) THEN SCROLL UPTO NEAREST FRAME TAG THEN YOU WILL SEE
            //<frame scrolling    name="classFrame"  ###############


            driver.switchTo().frame("classFrame");
            waitForSometime();
            driver.findElement(By.linkText("org.openqa.selenium")).click();
            waitForSometime();


        }
            // TEST REQUIRMENT
            // >LAUNCH THE WEB PAGE THGATR HAS MULTIPLE FRAMES
            // >OPERATE ON ELEMENT IN THE 3RD FRAME
            // >OPERATE ON ELEMENT IN THE 1ST FRAME

            //STEPS FOR SELENIUM WEBDRIVER TEST SCRIPTS:
            //>LAUNCH WEB PAGE THAT HAS MULTIPLE FRAMES
            //>SWITCH FROM TOP WINDOW TO 3RD FRAME
            //> ACCESS AN ELEMENT
            //> BACK TO TOP WINDOW (DEFAULT)
            //> SWITCH FROM TOP WINDOW TO 1ST FRAME
            //> ACCESS AN ELEMENT

        @Test
        public void multipleFrames(){

            // FRAME "NAME"

            driver.switchTo().frame("classFrame");
            waitForSometime();
            driver.findElement(By.linkText("org.openqa.selenium")).click();
            waitForSometime();
            driver.switchTo().defaultContent();
            //FIRST FRAME MEANS "0"
            driver.switchTo().frame("packageListFrame");
            driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
            waitForSometime();

            //switch from the Top Window to 3rd Frame using Frame "Index"
            // 0=n-1
            //0=n-3
            //2

//            driver.switchTo().frame(2);
//            waitForSometime();
//            driver.findElement(By.linkText("org.openqa.selenium")).click();
//            waitForSometime();
//            driver.switchTo().defaultContent();
//            FIRST FRAME MEANS "0"
//            driver.switchTo().frame(0);
//            driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
//            waitForSometime();



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
