import org.testng.Assert;
import org.testng.annotations.Test;
import pom.*;
import utility.ReaderFromLoginProperty;
import utility.ReaderFromUtilityProperty;

public class TC_002_End_To_End extends BaseTests{
    @Test
    public void successfulCheckoutFlowForAValidUser(){
        String userName= ReaderFromLoginProperty.getvalidUser();
        String password= ReaderFromLoginProperty.getPassword();
        String fname= ReaderFromUtilityProperty.getFirstName();
        String lname= ReaderFromUtilityProperty.getLastName();
        String zcode= ReaderFromUtilityProperty.getZipCode();
        String productName= ReaderFromUtilityProperty.getProductName("1");
System.out.println(productName);
        loginPage.loginSuccessfully(userName,password);
        HomePage homePage=loginPage.acceptAlertAfterLogin();
        homePage.clickOnAddToCart(productName);
        homePage.clickOnAddToCart(ReaderFromUtilityProperty.getProductName("6"));
        CartPage cartPage=homePage.clickOnCart();
        CheckoutPage checkoutPage=cartPage.clickOnCheckOut();
        checkoutPage.fillCheckoutForm(fname,lname,zcode);
        OverviewPage overviewPage=checkoutPage.clickOnContinue();
        FinishPage finishPage=overviewPage.clickOnFinish();
        String confirmMessage=finishPage.getConfirmMessage();
        Assert.assertEquals(confirmMessage,"THANK YOU FOR YOUR ORDER");
    }
}
