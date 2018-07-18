package com.action.pechatka_develop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BOCreateArticlePage {

    public BOCreateArticlePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1")
    public static WebElement boCreateArticlePageName;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    public static WebElement boEditArticleButtonName;

    public WebDriver driver;
    @FindBy(xpath = "//input[@id='Article_header']")
    public WebElement boArticleHeader;
    @FindBy(xpath = "//textarea[@name='Article[lead]']")
    public WebElement boArticleAnnounce;
    @FindBy(xpath = "//a[text()='Файлы к материалу']")
    public WebElement boArticleFilesToUpload;
    @FindBy(xpath = "//input[@class='filesUpload']")
    public WebElement boArticleFilesUpload;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement boArticleMainContent;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement boArticleSaveButton;

    public static String getBOEditArticleButtonName() {
        String BOEditArticleButtonName = boEditArticleButtonName.getText();
        return BOEditArticleButtonName;
    }

    public static String getBOArticleCreatePageName() {
        String BOArticleCreatePageName = boCreateArticlePageName.getText();
        return BOArticleCreatePageName;
    }
    public void fillArticleHeader() {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY_hh-mm-ss");
        String articleName = format.format(dateNow);
        boArticleHeader.sendKeys("test article header "+articleName);
    }

    public void fillArticleAnnounce(){
        boArticleAnnounce.sendKeys("test article announce");
    }

    public void fillArticleText(){
        driver.switchTo().frame("form-attr-content_ifr");
        boArticleMainContent.sendKeys("test article text");
        driver.switchTo().parentFrame();
    }

    public void uploadArticleFile(){
        boArticleFilesToUpload.click();
        boArticleFilesUpload.sendKeys("e:\\sagitt\\work\\files for selenium\\develop\\testimages\\avatarka.png");
    }

    public void clickBOArticleSaveButton() {
        boArticleSaveButton.click();
    }


}