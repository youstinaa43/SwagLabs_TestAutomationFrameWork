import org.testng.Assert;
import org.testng.annotations.Test;
import pom.CartPage;
import pom.CheckoutPage;
import pom.HomePage;
import pom.OverviewPage;
import utility.ReaderFromLoginProperty;
import utility.ReaderFromUtilityProperty;

import java.util.List;

public class TC_004_VerifyProductsNameInCart extends BaseTests{
    @Test
    public void successfulCheckoutFlowForAValidUser(){
        String userName= ReaderFromLoginProperty.getvalidUser();
        String password= ReaderFromLoginProperty.getPassword();
        String fname= ReaderFromUtilityProperty.getFirstName();
        String lname= ReaderFromUtilityProperty.getLastName();
        String zcode= ReaderFromUtilityProperty.getZipCode();
        String product1=ReaderFromUtilityProperty.getProductName("1");
        String product2=ReaderFromUtilityProperty.getProductName("4");
        HomePage homePage=loginPage.loginSuccessfully(userName,password);
        homePage.clickOnAddToCart(product1);
        homePage.clickOnAddToCart(product2);
        CartPage cartPage=homePage.clickOnCart();
        List<String> productNames=cartPage.getProductNames();
        int cartNo=cartPage.getProductNoOfCart();
        Assert.assertEquals(productNames.get(0),product1);
        Assert.assertEquals(productNames.get(1),product2);
        Assert.assertEquals(cartNo,productNames.size());

    }
}
