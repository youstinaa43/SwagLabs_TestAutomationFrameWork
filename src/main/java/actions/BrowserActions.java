package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;

import java.time.Duration;

public class BrowserActions {
    public static ThreadLocal<WebDriver> drivers=new ThreadLocal<>();
    public static ThreadLocal<WebDriverWait> waits=new ThreadLocal<>();
    public static void initTheBrowser(Browsers browser) {
        WebDriver driver;
        switch (browser){
            case chrome:
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("autofill.profile_enabled", false);
                prefs.put("autofill.credit_card_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                options.addArguments(
                        "--disable-save-password-bubble",
                        "--disable-infobars",
                        "--disable-notifications",
                        "--disable-popup-blocking",
                        "--disable-autofill-keyboard-accessory-view",
                        "--disable-password-manager-reauthentication",
                        "--disable-password-manager-verification",
                        "--disable-single-click-autofill",
                        "--disable-features=PasswordManager",
                        "--remote-allow-origins=*"
                );
                options.setExperimentalOption("excludeSwitches",
                        new String[]{
                                "enable-automation",
                                "enable-logging",
                                "password-manager"
                        });
                options.setExperimentalOption("useAutomationExtension", false);
                driver=new ChromeDriver(options);
                break;
            case firefox:
                driver=new FirefoxDriver();
                break;
            case edge:
                driver=new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browser);
        }
        drivers.set(driver);
        waits.set(new WebDriverWait(driver, Duration.ofSeconds(15)));
    }
    public static WebDriver getDriver() {
        if (drivers.get() == null) {
            throw new IllegalStateException("Driver not initialized. Call initTheBrowser() first.");
        }
        return drivers.get();
    }
    public static WebDriverWait getWait() {
        if (waits.get() == null) {
            throw new IllegalStateException("Wait not initialized. Call initTheBrowser() first.");
        }
        return waits.get();
    }
    public static void closeBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
            drivers.remove();
            waits.remove();
        }
    }
    public static void navigateTo(String url){
        getDriver().get(url);
    }
    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
    public static void navigateBack() {
        getDriver().navigate().back();
    }
    public static void navigateForward() {
        getDriver().navigate().forward();
    }
    public static void refreshPage() {
        getDriver().navigate().refresh();
    }
    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public enum Browsers{
        chrome,
        firefox,
        edge
    }
}
