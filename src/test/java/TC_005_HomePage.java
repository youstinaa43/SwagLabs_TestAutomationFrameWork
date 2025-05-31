import org.testng.annotations.Test;
import pom.HomePage;
import utility.ReaderFromLoginProperty;
import utility.ReaderFromUtilityProperty;

public class TC_005_HomePage extends BaseTests{
    @Test
    public void verifyFilteration() throws InterruptedException {
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
        homePage.selectFromDropdown("index","2");
        homePage.clickOnRemoveFromCart(product1);
        Thread.sleep(3000);

    }
}
