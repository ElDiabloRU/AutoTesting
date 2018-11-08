import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ru.hazker.page.BasicPage;
import ru.hazker.page.GmailPage;
import ru.hazker.page.LoginPage;
import ru.hazker.page.MainPage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {


    private final String CHROME_PROPERTY_KEY = "webdriver.chrome.driver";
    private final String CHROME_PROPERTY_VALUE = "src/main/resources/chromedriver.exe";

    private WebDriver webDriver;

    private UUID uuid = UUID.randomUUID();
    private LoginPage loginPage;
    private MainPage mainPage;
    private GmailPage gmailPage;
    private BasicPage basicPage;

    @BeforeTest
    public void start(){
        System.setProperty(CHROME_PROPERTY_KEY,CHROME_PROPERTY_VALUE);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }


    @Пусть("^открыта страница входа в приложение '(.+)'$")
    public void openLoginPage(String url){
        webDriver.get(url);

    }

    @И("^нажимает кнопку \"([^\"]*)\"$")
    public void clickButton(String btnName){
        switch (btnName){
            case "write letter":

        }
    }

    @И("^пользователь вводит в поле \"([^\"]*)\" значение \"([^\"]*)\"$")
    public void setTextInput(String fieldName, String value){

    }

    @То("^должен увидеть страницу, загаловок который содержит текст 'Входящие'$")
    public void checkInbox(){

    }

    @И("^вводит текст \"([^\"]*)\" в поле \"([^\"]*)\"$")
    public void setTextToInput(String text, String input){

    }

    @И("^вводит uuid в поле \"([^\"]*)\"$")
    public void setUuidInput(String uuidInput){

    }

    @Пусть("^пользователь вводит в поле \"([^\"]*)\" значение 'in:draft'$")
    public void setTextInDraftInput(String draft){

    }

    @Тогда("^должен увидеть страницу, заголовок который содержит текст 'Черновики'$")
    public void checkToDraft(){

    }

    @Пусть("^пользователь находит текущее письмо$")
    public void findLetter(){

    }

    @И("^нажимает \"([^\"]*)\"$")
    public void click(String click){

    }

    @Тогда("^пользователь сравнивает \"([^\"]*)\" с текстом в данных$")
    public void comparedText(String compared){

    }


    @AfterTest
    public void quit(){
        webDriver.quit();
    }

}