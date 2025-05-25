package pom;

import actions.ElementActions;

public class CheckoutPage {
    String firstName="first-name";
    String lastName="last-name";
    String zipCode="postal-code";
    String continueButton="input.btn_primary";
    String cancelButton="a.cart_cancel_link";
    String cart="a.shopping_cart_link";
    ElementActions elementActions;
    public CheckoutPage(){
        this.elementActions=new ElementActions();
    }
    public void fillCheckoutForm(String fName,String lName,String zCode){
        elementActions.sendText(firstName, ElementActions.Locators.id,fName);
        elementActions.sendText(lastName, ElementActions.Locators.id,lName);
        elementActions.sendText(zipCode, ElementActions.Locators.id,zCode);
    }
    public OverviewPage clickOnContinue(){
        elementActions.clickOnElement(continueButton, ElementActions.Locators.css);
        return new OverviewPage();
    }
    public CartPage clickOnCart(){
        elementActions.clickOnElement(cart, ElementActions.Locators.css);
        return new CartPage();
    }
    public CartPage clickOnCancel(){
        elementActions.clickOnElement(cancelButton, ElementActions.Locators.css);
        return new CartPage();
    }

}
