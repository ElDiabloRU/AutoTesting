package ru.hazker.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    public boolean emailFieldIsVisible(){
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return emailField.isDisplayed();
    }

    public void fillEmail(String email){
        emailField.sendKeys(email);
    }
}
