package com.action.pechatka_develop.tests;


import com.action.pechatka_develop.pages.BOArticlesListPage;
import com.action.pechatka_develop.pages.BOCreateArticlePage;
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
//import org.openqa.selenium.support.ui.WebDriverWait;

public class BOCreateArticleTests {

    //public static WebDriverWait wait;
    public static WebDriver driver;
    public static BOCreateArticlePage boCreateArticlePage;
    public static BOMainPage boMainPage;
    public static BOLoginPage boLoginPage;
    public static BOArticlesListPage boArticlesListPage;


    @BeforeClass
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "e:\\sagitt\\letscodeit_udemy\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        boCreateArticlePage = new BOCreateArticlePage(driver);
        boMainPage = new BOMainPage(driver);
        //wait = new WebDriverWait(driver, 3);
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

    @Test
    public void boGoToArticleListTest(){
        boMainPage.clickboGoArticleListPage();
        String BOListName = BOArticlesListPage.getBOArticlePageName();
        Assert.assertEquals("Статьи", BOListName);
    }

    @Test
    public void boGoToCreateArticlePageTest(){
        boArticlesListPage.clickBOCreateArticleButton();
        String BOListName = BOCreateArticlePage.getBOArticleCreatePageName();
        Assert.assertEquals("Добавить статью", BOListName);
    }

    @Test
    public void boCreateArticleTest(){
        boCreateArticlePage.fillArticleHeader();
        boCreateArticlePage.fillArticleAnnounce();
        boCreateArticlePage.fillArticleText();
        boCreateArticlePage.uploadArticleFile();
        boCreateArticlePage.clickBOArticleSaveButton();
        String BOArticleViewName = BOCreateArticlePage.getBOEditArticleButtonName();
        Assert.assertEquals(" Редактировать", BOArticleViewName);
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

