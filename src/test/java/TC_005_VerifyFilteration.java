import org.testng.Assert;
import org.testng.annotations.Test;
import pom.CartPage;
import pom.HomePage;
import utility.ReaderFromLoginProperty;
import utility.ReaderFromUtilityProperty;

import java.util.List;

public class TC_005_VerifyFilteration extends BaseTests{
    @Test
    public void verifyFilteration() throws InterruptedException {
        String userName= ReaderFromLoginProperty.getvalidUser();
        String password= ReaderFromLoginProperty.getPassword();
        String fname= ReaderFromUtilityProperty.getFirstName();
        String lname= ReaderFromUtilityProperty.getLastName();
        String zcode= ReaderFromUtilityProperty.getZipCode();
        String product1=ReaderFromUtilityProperty.getProductName("1");
        String product2=ReaderFromUtilityProperty.getProductName("4");
        loginPage.loginSuccessfully(userName,password);
        HomePage homePage=loginPage.acceptAlertAfterLogin();
        homePage.clickOnAddToCart(product1);
        homePage.clickOnAddToCart(product2);
        homePage.selectFromDropdown("index","2");
        homePage.clickOnRemoveFromCart(product1);
        Thread.sleep(3000);

    }
}
