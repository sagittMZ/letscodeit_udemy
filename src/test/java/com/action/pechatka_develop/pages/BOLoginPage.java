package com.action.pechatka_develop.pages;

import com.action.pechatka_develop.ReaderExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOLoginPage {

    public BOLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;
    @FindBy(xpath = "//*[@id=\"BackendLoginForm_username\"]")
    public WebElement boLoginField;
    @FindBy(xpath = "//*[@id=\"BackendLoginForm_password\"]")
    public WebElement boPasswordField;
    @FindBy(xpath = "//form[@class='form-signin form']//button")
    public WebElement boLoginButton;

    @FindBy(xpath = "//button[@type='submit']")
    public static WebElement boSignUpButtonName;

    public static String getBOSignUpButtonName() {
        String BOSignUpButtonName = boSignUpButtonName.getText();
        return BOSignUpButtonName;
    }

    public void inputBOLogin() {
        boLoginField.sendKeys(ReaderExcel.getBOLoginFromFile());
    }

    public void inputBOPassword() {
        boPasswordField.sendKeys(ReaderExcel.getBOPasswordFromFile());


    }

    public void clickBOLoginButton() {
        boLoginButton.click();
    }


}
