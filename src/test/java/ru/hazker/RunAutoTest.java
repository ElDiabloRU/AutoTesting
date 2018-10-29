package ru.hazker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.hazker.page.GmailPage;
import ru.hazker.page.LoginPage;
import ru.hazker.page.MainPage;


import java.util.UUID;
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
    public void openGmail(){
        webDriver.get("https://www.google.com/intl/ru/gmail/about/");
        MainPage main = new MainPage(webDriver);
        main.clickLoginButton();


        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.emailFieldIsVisible(), "Поле логина не обноружино");


    }

    @Test(dependsOnMethods = {"openGmail"})
    public void login(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.fillEmail("123321qweewq123321");
        loginPage.clickNextButton();

    }

    @Test(dependsOnMethods = {"login"})
    public void password(){
        LoginPage password = new LoginPage(webDriver);
        password.fillPassword("123321qweewq123321");

        password.clickNextButton1();
    }

    @Test(dependsOnMethods = {"password"})
    public void openWriteButton(){
        GmailPage write = new GmailPage(webDriver);
        write.clickWriteButton();
        write.fillDestination("pushin98@mail.ru");
        write.fillTheme("Auto Testing");
        write.fillLetterBody("Check Auto Testing \n");
    }

    @Test(dependsOnMethods = {"openWriteButton"})
    public void toDraft(){
        GmailPage draft = new GmailPage(webDriver);
        draft.clickObn();
        draft.draftButton("in:draft");
        draft.clickSearchButton();
        draft.clickFindMesageButton();
        draft.findMesage();




    }



}
