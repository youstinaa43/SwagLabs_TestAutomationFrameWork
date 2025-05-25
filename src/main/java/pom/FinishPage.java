package pom;

import actions.ElementActions;

public class FinishPage {
    ElementActions elementActions;
    String confirmMessage="//h2[@class=\"complete-header\"]";
    String cart="a.shopping_cart_link";
    public FinishPage(){
        this.elementActions=new ElementActions();
    }
    public String getConfirmMessage(){
        return elementActions.getElementText(confirmMessage, ElementActions.Locators.xpath);
    }
    public CartPage clickOnCart(){
        elementActions.clickOnElement(cart, ElementActions.Locators.css);
        return new CartPage();
    }

}
