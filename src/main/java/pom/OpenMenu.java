package pom;

import actions.ElementActions;

public class OpenMenu {

    String logOutID="logout_sidebar_link";
    ElementActions elementActions;
    public OpenMenu( ){
        this.elementActions=new ElementActions();
    }
    public void clickOnLogOut(){
        elementActions.clickOnElement(logOutID, ElementActions.Locators.id);
    }
}
