package ru.hazker.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class GmailPage extends BasicPage{

    public GmailPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(className = "z0")
    private WebElement writeButton;

    @FindBy(className = "vO")
    private WebElement destinationField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement themeField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement letterBodyField;

    @FindBy(xpath = "//td[@class='gU Up']//div[@class='J-J5-Ji btA']")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//img[@class='Ha']")
    private WebElement obn;

    @FindBy(xpath = "//input[@class='gb_cf']")
    private WebElement draftField;

    @FindBy(css = ".gb_ef.gb_of")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='Cp']//table[@class='F cf zt']//tr")
    public List<WebElement> tabliza;

    @FindBy(xpath = "//div[@class='ae4 UI']//div[@class='Cp']//table[@class='F cf zt']")
    public WebElement tabliza1;





    UUID uuid = UUID.randomUUID();


    public void clickWriteButton(){
        if (!writeButton.isDisplayed())
            wait.until(ExpectedConditions.elementToBeClickable(writeButton));

        writeButton.click();
    }

    public void fillDestination(String destination){
        if(!destinationField.isDisplayed())
            wait.until(ExpectedConditions.visibilityOf(destinationField));
        destinationField.sendKeys(destination);

        destinationField.getText();
    }

    public void fillTheme(String theme){
        if(!themeField.isDisplayed())
            wait.until(ExpectedConditions.visibilityOf(themeField));
        themeField.sendKeys(theme);

        themeField.getText();
    }

    public void fillLetterBody(String body){
        if(!letterBodyField.isDisplayed())
            wait.until(ExpectedConditions.visibilityOf(letterBodyField));


        letterBodyField.sendKeys(body);
        letterBodyField.sendKeys(uuid.toString());

    }

    public void clickSendLetterButton(){
        if (!sendLetterButton.isDisplayed())
            wait.until(ExpectedConditions.elementToBeClickable(sendLetterButton));

        sendLetterButton.click();
    }

    public void clickObn(){
        if (!obn.isDisplayed())
            wait.until(ExpectedConditions.elementToBeClickable(obn));

        obn.click();
    }

    public void draftButton(String draft){
        if(!draftField.isDisplayed())
            wait.until(ExpectedConditions.visibilityOf(draftField));
        draftField.sendKeys(draft);

        draftField.getText();
    }

    public void clickSearchButton(){
        if (!searchButton.isDisplayed())
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        searchButton.click();

    }
    public void clickFindMesageButton(){
        if (!tabliza1.isDisplayed())
            wait.until(ExpectedConditions.elementToBeClickable(tabliza1));

        tabliza1.click();

    }


    public void findMesage(){
        for(WebElement element:tabliza){
            this.clickSendLetterButton();
            break;

        }
    }

}
