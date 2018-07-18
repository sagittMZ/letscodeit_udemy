package com.action.pechatka_develop.pages;

import com.action.pechatka_develop.ReaderExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOArticlesListPage {

    public BOArticlesListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    // проверка названия страницы и переход к созданию статьи: элементы
     @FindBy(xpath = "//h1")
    public static WebElement boArticlePageName;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    public static WebElement boCreateArticleButton;



    // проверка названия страницы и переход к созданию статьи: методы
    public static String getBOArticlePageName() {
        String BOArticlePageName = boArticlePageName.getText();
        return BOArticlePageName;
    }
    public void clickBOCreateArticleButton() {
        boCreateArticleButton.click();
    }


}
