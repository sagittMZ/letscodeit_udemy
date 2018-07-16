package com.action.pechatka_develop.pages;

import com.action.pechatka_develop.ReaderExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.action.pechatka_develop.ReaderExcel.getBOLoginFromFile;
import static com.action.pechatka_develop.ReaderExcel.getBOPasswordFromFile;

public class BOLoginPage {

    public BOLoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebDriver driver;
    @FindBy (xpath = "//*[@id=\"BackendLoginForm_username\"]")
    private WebElement boLoginField;
    @FindBy (xpath = "//*[@id=\"BackendLoginForm_password\"]")
    private WebElement boPasswordField;
    @FindBy (xpath = "//form[@class='form-signin form']//button")
    private WebElement boLoginButton;
    @FindBy (xpath = "//button[@type='submit']")
    private static WebElement boSignUpButtonName;
    public static String getBOSignUpButtonName() {
        String BOSignUpButtonName = boSignUpButtonName.getText();
        return BOSignUpButtonName;
    }
    public void inputBOLogin() {
       boLoginField.sendKeys(getBOLoginFromFile());
    }
    public void inputBOPassword() {
        boLoginField.sendKeys(getBOPasswordFromFile());
    }
    public void clickBOLoginButton() {
        boLoginButton.click();
    }

    /*public void inputBOLogin(String boLoginFromFile) {
        boLoginField.sendKeys(boLoginFromFile);
    }
    public void inputBOPassword(String boPasswordFromFile) {
        boLoginField.sendKeys(boPasswordFromFile);
    }
    public void clickBOLoginButton() {
        boLoginButton.click();
    }*/

}