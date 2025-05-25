import org.testng.Assert;
import org.testng.annotations.Test;
import pom.*;
import utility.ReaderFromLoginProperty;
import utility.ReaderFromUtilityProperty;

public class TC_003_VerifyTotalPrice extends BaseTests{
    @Test
    public void successfulCheckoutFlowForAValidUser(){
        String userName= ReaderFromLoginProperty.getvalidUser();
        String password= ReaderFromLoginProperty.getPassword();
        String fname= ReaderFromUtilityProperty.getFirstName();
        String lname= ReaderFromUtilityProperty.getLastName();
        String zcode= ReaderFromUtilityProperty.getZipCode();
        loginPage.loginSuccessfully(userName,password);
        HomePage homePage=loginPage.acceptAlertAfterLogin();
        homePage.clickOnAddToCart(ReaderFromUtilityProperty.getProductName("6"));
        CartPage cartPage=homePage.clickOnCart();
        CheckoutPage checkoutPage=cartPage.clickOnCheckOut();
        checkoutPage.fillCheckoutForm(fname,lname,zcode);
        OverviewPage overviewPage=checkoutPage.clickOnContinue();
        Double itemTotal=overviewPage.getItemTotal();
        Double tax=overviewPage.getTax();
        Double total=overviewPage.getotal();
        Assert.assertEquals(total,itemTotal+tax);
    }
}
