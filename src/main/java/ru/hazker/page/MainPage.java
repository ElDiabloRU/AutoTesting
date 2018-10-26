package ru.hazker.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasicPage{

    @FindBy(css = ".gmail-nav__nav-link__sign-in")
    private WebElement loginButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLoginButton(){
        if (!loginButton.isDisplayed())
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        loginButton.click();
    }

}
