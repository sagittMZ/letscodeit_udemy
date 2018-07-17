package com.action.pechatka_develop.tests;

import com.action.pechatka_develop.pages.BOLoginPage;
import com.action.pechatka_develop.pages.BOMainPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class BOLoginTests {

    public static WebDriver driver;
    public static BOLoginPage boLoginPage;
    public static BOMainPage boMainPage;
    @BeforeClass
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "e:\\sagitt\\letscodeit_udemy\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        boLoginPage = new BOLoginPage(driver);
        boMainPage = new BOMainPage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.develop.vmcl.ru/backend/");
    }
    @Test
    public void boLoginTest(){
        boLoginPage.inputBOLogin();
        boLoginPage.inputBOPassword();
        boLoginPage.clickBOLoginButton();
        String BOSiteName = BOMainPage.getBOSiteName();
        Assert.assertEquals(" Дефолтный сайт", BOSiteName);
    }
    @AfterClass
    public static void driverQuit(){
        boMainPage.clickboUserIcon();
        boMainPage.clickboLogoutLink();
        String BOSignUpButtonName = BOLoginPage.getBOSignUpButtonName();
        Assert.assertEquals("Войти", BOSignUpButtonName);
        driver.quit();
    }
}

