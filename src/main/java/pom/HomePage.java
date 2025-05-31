package pom;

import actions.ElementActions;

public class HomePage {
    String openMenu="//div[@class='bm-burger-button']/button";
    String cart="a.shopping_cart_link";
    String dropdown="select.product_sort_container";
    String logOutID="logout_sidebar_link";

    ElementActions elementActions;
    public HomePage( ){
        this.elementActions=new ElementActions();
    }
    public void clickOnOpenMenu(){
        elementActions.clickOnElement(openMenu, ElementActions.Locators.xpath);
        elementActions.pressEnterOnElement(openMenu, ElementActions.Locators.xpath);
        elementActions.clickOnElementUsingJS(openMenu,ElementActions.Locators.xpath);
    }
    public void clickOnLogOut(){
        elementActions.clickOnElement(logOutID, ElementActions.Locators.id);
    }
    public void clickOnAddToCart(String productName){
        String addToCart="//div[text()=\""+productName+"\"]/parent::*/parent::div[@class=\"inventory_item_label\"]/parent::div//div[@class=\"pricebar\"]/button";
        elementActions.clickOnElement(addToCart, ElementActions.Locators.xpath);
    }
    public void clickOnRemoveFromCart(String productName){
        String addToCart="//div[text()=\""+productName+"\"]/parent::*/parent::div[@class=\"inventory_item_label\"]/parent::div//div[@class=\"pricebar\"]/button";
        elementActions.clickOnElement(addToCart, ElementActions.Locators.xpath);
    }
    public CartPage clickOnCart(){
        elementActions.clickOnElement(cart, ElementActions.Locators.css);
        return new CartPage();
    }
    public void selectFromDropdown(String selectBy,String value){
        elementActions.selectFromDropDownMenu(dropdown, ElementActions.Locators.css,selectBy,value);
    }

}
