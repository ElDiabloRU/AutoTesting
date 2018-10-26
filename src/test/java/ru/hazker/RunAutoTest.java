package ru.hazker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.hazker.page.LoginPage;
import ru.hazker.page.MainPage;



import java.util.concurrent.TimeUnit;

public class RunAutoTest {
    private WebDriver webDriver;

    private final String CHROME_PROPERTY_KEY = "webdriver.chrome.driver";
    private final String CHROME_PROPERTY_VALUE = "src/main/resources/chromedriver.exe";

    @BeforeTest
    public void start(){
        System.setProperty(CHROME_PROPERTY_KEY,CHROME_PROPERTY_VALUE);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterTest
    public void quit(){
        webDriver.quit();
    }

    @Test
    public void login(){
        webDriver.get("https://www.google.com/intl/ru/gmail/about/");
        MainPage main = new MainPage(webDriver);
        main.clickLoginButton();

        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.emailFieldIsVisible(), "Поле логина не обноружино");
        loginPage.fillEmail("sadadadada");
    }



}
