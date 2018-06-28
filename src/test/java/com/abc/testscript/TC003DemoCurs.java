package com.abc.testscript;

import com.abc.seleniumrepository.SeleniumRepo;
import com.abc.util.PropertyFileRead;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.net.UnknownHostException;

public class TC003DemoCurs {

    @BeforeTest
    public void BeforeTest() throws UnknownHostException
    {
        /*
         * @param 1: Browser name -firefox or internetExplorer or chrome
         *  Below firefox string is being read from the ProjectData.property file in resources package
         *
         *  @param 2: Browser Proxy Yes or No. If yes then port and Host details are read from the Property file
         */
        System.out.println("TestCase Starts");
        SeleniumRepo.startBrowser(PropertyFileRead.FileRead("ProjectData.properties","BrowserType"), false);
        SeleniumRepo.driver.manage().window().maximize();
    }

    @AfterTest
    public void AfterTest() throws UnknownHostException
    {
        System.out.println("TestCase Ends");
        SeleniumRepo.driver.quit();

    }
    /**
     * @author isirbu
     * Goes to a specific site and performs login
     * @throws InterruptedException
     */
    @Test(priority = 1)
    public void loginSuccess() throws InterruptedException {
        System.out.println("Start loginSuccess");
        SeleniumRepo.GoToUrl(PropertyFileRead.FileRead("ProjectData.properties","TS01SiteURLNavigation"));
        SeleniumRepo.WaitForLoad(2000);

        // Check if Authentication form element is Present
        if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","FormAuth")))
        {
            System.out.println("Find and click the Form Authentication section");
            SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","FormAuth"));

        }
        else
        {
            System.out.println("Cannot find the Form Authentication");
        }
        // Check if Username element is Present
        if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Username")))
        {
            System.out.println("Find and enter the username");
            SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Username"),"tomsmith");
        }
        else
        {
            System.out.println("Username textbox not found");
        }
        // Check if Password element is Present
        if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Password")))
        {
            System.out.println("Find and enter the password");
            SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Password"),"SuperSecretPassword!");
        }
        else
        {
            System.out.println("Password textbox not found");
        }
        // Check if Login button element is Present
        if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Password")))
        {
            System.out.println("Find and click on Login button");
            SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Password"),"SuperSecretPassword!");
        }
        else
        {
            System.out.println("Login button not found");
        }

    }

    @Test (priority = 0)
    public void loginFail() throws InterruptedException {
        System.out.println("Start loginFail");
        SeleniumRepo.GoToUrl(PropertyFileRead.FileRead("ProjectData.properties","TS01SiteURLNavigation"));
        SeleniumRepo.WaitForLoad(2000);

        // Check if Authentication form element is Present
        if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","FormAuth")))
        {
            System.out.println("Find and click the Form Authentication section");
            SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","FormAuth"));

        }
        else
        {
            System.out.println("Cannot find the Form Authentication");
        }
        // Check if Username element is Present
        if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Username")))
        {
            System.out.println("Find and enter the username");
            SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Username"),"tomsmith1");
        }
        else
        {
            System.out.println("Username textbox not found");
        }
        // Check if Password element is Present
        if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Password")))
        {
            System.out.println("Find and enter the password");
            SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Password"),"SuperSecretPassword!");
        }
        else
        {
            System.out.println("Password textbox not found");
        }
        // Check if Login button element is Present
        if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","LoginButton")))
        {
            System.out.println("Find and click on Login button");
            SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","LoginButton"));
        }
        else
        {
            System.out.println("Login button not found");
        }

        // Check the login error message
        if (SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","FlashMessage")))
        {
              //  SeleniumRepo.findElement(PropertyFileRead.FileRead("ProjectData.properties","FlashMessage"));
                Assert.assertEquals(SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","FlashMessage")),"Your username is invalid!\n×");
   //         System.out.println(         SeleniumRepo.findElement(PropertyFileRead.FileRead("ProjectData.properties","FlashMessage")).getText());
        }
        else
            {
                System.out.println("Invalid login error message");
            }
    }

}
