package pom;

import actions.ElementActions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    String checkoutButton="a.checkout_button";
    String continueShop="a.btn_secondary";
    String removeButton="button.btn_secondary";
    String productNames="div.inventory_item_name";
    String cartNumber="span.shopping_cart_badge";
    ElementActions elementActions;
    public  CartPage(){
        this.elementActions=new ElementActions();
    }
    public CheckoutPage clickOnCheckOut(){
        elementActions.clickOnElement(checkoutButton, ElementActions.Locators.css);
        return new CheckoutPage();
    }
    public HomePage clickOnContinueShoping(){
        elementActions.clickOnElement(continueShop, ElementActions.Locators.css);
        return new HomePage();
    }
    public void removeProductFromCart(){
        elementActions.clickOnElement(removeButton, ElementActions.Locators.css);
    }
    public List<String> getProductNames(){
        List<WebElement> products= elementActions.getElements(productNames, ElementActions.Locators.css);
        List<String> productNames=new ArrayList<>();
        for (WebElement product:products){
            productNames.add(product.getText());
        }
        return productNames;
    }
    public int getProductNoOfCart(){
        String text=elementActions.getElementText(cartNumber, ElementActions.Locators.css);
        return Integer.parseInt(text);
    }
}
