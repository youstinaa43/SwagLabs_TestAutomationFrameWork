package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementActions {
    private WebDriver driver;
    private WebDriverWait wait;
    public ElementActions(){
        this.driver=BrowserActions.getDriver();
        this.wait=BrowserActions.getWait();
    }
    public void clickOnElement(String selector,Locators locator){
        try {
            By elementLocator= locateElement(selector,locator);
            WebElement element=waitUntil(elementLocator,ConditionsExpected.elementToBeClickable);
            try {
                element.click();
                //return;
            }catch (Exception e){
                throw new RuntimeException("Element not found or not clickable: " + selector);
            }
        }
        catch (Exception e){
            throw new RuntimeException("Element not clickable "+selector,e);
        }
    }
    public void clickOnElementUsingJS(String selector,Locators locator){
        try {
            By elementLocator= locateElement(selector,locator);
            WebElement element=waitUntil(elementLocator,ConditionsExpected.elementToBeClickable);
            if(element!=null){
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
            }else {
                throw new RuntimeException("Element not found or not clickable: " + selector);
            }
        }
        catch (Exception e){
            throw new RuntimeException("Element not clickable "+selector,e);
        }
    }
    public void pressEnterOnElement(String selector,Locators locator) {
        try {
            By elementLocator= locateElement(selector,locator);
            WebElement element=waitUntil(elementLocator,ConditionsExpected.elementToBeClickable);
            if(element!=null){
                element.clear();
                element.sendKeys(Keys.ENTER);
            }else {
                throw new RuntimeException("Element not found or not clickable: " + selector);
            }
        }
        catch (Exception e){
            throw new RuntimeException("Element not clickable "+selector,e);
        }
    }
    public String getElementText(String selector,Locators locator){
        try {
            By elementLocator=locateElement(selector,locator);
            WebElement element=waitUntil(elementLocator,ConditionsExpected.visibilityOfElement);
            return element.getText();
        }
        catch (Exception e){
            throw new RuntimeException("Text not visible "+locator,e);
        }
    }
    public List<WebElement> getElements(String selector,Locators locator){
        try {
            By elementLocator=locateElement(selector,locator);
            List<WebElement> elements=waitForAllElements(elementLocator);
            return elements;
        }
        catch (Exception e){
            throw new RuntimeException("Failed to find elements with selector "+selector,e);
        }
    }
    public void sendText(String selector,Locators locator,String message) {
        try {
            By elementLocator= locateElement(selector,locator);
            WebElement element=waitUntil(elementLocator,ConditionsExpected.visibilityOfElement);
                //element.clear();
                element.sendKeys(message);
        }
        catch (Exception e){
            throw new RuntimeException("Element not visible "+selector,e);
        }
    }
    public void acceptAlert(){
        try {
           // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
           // Alert alert= wait.until(ExpectedConditions.alertIsPresent());
            Alert alert=driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }catch (Exception e){
            throw new RuntimeException("Failed to accept alert",e);
        }
    }
    public void selectFromDropDownMenu(String dropdown,Locators locator,String selectBy,String value){
        By elementLocator=locateElement(dropdown,locator);
        WebElement element=waitUntil(elementLocator,ConditionsExpected.presenceOfElement);
        Select dropDownMenu=new Select(element);
        switch (selectBy){
            case "value":
                dropDownMenu.selectByValue(value);
                break;
            case "visible text":
                dropDownMenu.selectByVisibleText(value);
                break;
            case "index":
                int index=Integer.parseInt(value);
                dropDownMenu.selectByIndex(index);
                break;
        }

    }
    public WebElement waitUntil(By locator, ConditionsExpected condition){
        try {
            switch (condition){
                case presenceOfElement:
                    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                case visibilityOfElement:
                    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                case elementToBeClickable:
                    return wait.until(ExpectedConditions.elementToBeClickable(locator));
                case alertIsPresent:
                    return (WebElement) wait.until(ExpectedConditions.alertIsPresent());
                default:
                    return null;
            }
        }
        catch (Exception e){
            return null;
        }
    }
    public List<WebElement> waitForAllElements(By locator){
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }
        catch (Exception e){
            return null;
        }
    }
    public By locateElement(String selector,Locators locator){
        switch (locator){
            case id:
                return new By.ById(selector);
            case xpath:
                return new By.ByXPath(selector);
            case css:
                return new By.ByCssSelector(selector);
            default: return null;
        }
    }

    public enum Locators {
        xpath,
        css,
        id
    }
    public enum ConditionsExpected{
        presenceOfElement,
        elementToBeClickable,
        visibilityOfElement,
        alertIsPresent,
        presenceOfAllElementsLocatedBy
    }

}
