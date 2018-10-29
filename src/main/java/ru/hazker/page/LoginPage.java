package ru.hazker.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasicPage{


    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(id ="identifierNext")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement nextButton1;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean emailFieldIsVisible(){
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return emailField.isDisplayed();
    }

    public void fillEmail(String email){
        emailField.sendKeys(email);

        emailField.getText();
    }


    public void fillPassword(String password){
        if(!passwordField.isDisplayed())
            wait.until(ExpectedConditions.visibilityOf(passwordField));

        passwordField.sendKeys(password);

        passwordField.getText();
    }

    public void clickNextButton(){
        if (!nextButton.isDisplayed())
            wait.until(ExpectedConditions.elementToBeClickable(nextButton));

        nextButton.click();
    }

    public void clickNextButton1(){
        if (!nextButton1.isDisplayed())
            wait.until(ExpectedConditions.elementToBeClickable(nextButton1));
        nextButton1.click();
    }

}
