import actions.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pom.LoginPage;

import java.io.IOException;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    @BeforeClass
    public void setUp() throws IOException {
        BrowserActions.initTheBrowser(BrowserActions.Browsers.firefox);
        loginPage=new LoginPage();
        BrowserActions.navigateTo("https://www.saucedemo.com/v1/");
        loginPage.saveCredentialsInProperty("F:\\Java\\Projects\\Saucedemo\\src\\test\\resources\\data.properties");
    }
    @AfterClass
    public void tearDown(){
        BrowserActions.closeBrowser();
    }
}
