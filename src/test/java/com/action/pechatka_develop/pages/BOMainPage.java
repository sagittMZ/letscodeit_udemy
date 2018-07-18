package com.action.pechatka_develop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOMainPage {
    public BOMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy (xpath = "//span[@class='glyphicon glyphicon-user']")
    private WebElement boUserIcon;

    public void clickboUserIcon() {
        boUserIcon.click();
    }

    @FindBy (xpath = "//a[text()='Выйти']")
    private WebElement boLogoutLink;


    @FindBy (xpath = "//a[@class='navbar-brand']")
    private static WebElement boSiteNameMP;

    @FindBy (xpath = "//a[contains(text(),'Статьи')]")
    private static WebElement boGoArticleListPage;

    public static String getBOSiteName() {
        String BOSiteName = boSiteNameMP.getText();
        return BOSiteName;
    }
    public void clickboLogoutLink() {
        boLogoutLink.click();
    }

    public void clickboGoArticleListPage() {
        boGoArticleListPage.click();
    }
}
