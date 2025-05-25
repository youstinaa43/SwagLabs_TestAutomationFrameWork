package pom;

import actions.ElementActions;

public class OverviewPage {
    String finish="a.cart_button";
    String cancel="a.cart_cancel_link";
    String itemTotal="div.summary_subtotal_label";
    String tax="div.summary_tax_label";
    String total="div.summary_total_label";
    ElementActions elementActions;
    public OverviewPage(){
        this.elementActions=new ElementActions();
    }
    public FinishPage clickOnFinish(){
        elementActions.clickOnElement(finish, ElementActions.Locators.css);
        return new FinishPage();
    }
    public HomePage clickOnCancel(){
        elementActions.clickOnElement(cancel, ElementActions.Locators.css);
        return new HomePage();
    }
    public double getItemTotal(){
        String text=elementActions.getElementText(itemTotal, ElementActions.Locators.css).replaceAll("[^0-9.]","");
        return Double.parseDouble(text);
    }
    public double getTax(){
        String text=elementActions.getElementText(tax, ElementActions.Locators.css).replaceAll("[^0-9.]","");
        return Double.parseDouble(text);
    }
    public double getotal(){
        String text=elementActions.getElementText(total, ElementActions.Locators.css).replaceAll("[^0-9.]","");
        return Double.parseDouble(text);
    }


}
