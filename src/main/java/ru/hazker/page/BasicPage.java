package ru.hazker.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BasicPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,10);
        PageFactory.initElements(webDriver, this);
    }
}
