import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.OpenMenu;
import utility.ReaderFromLoginProperty;

public class TC_001_TestLogin extends BaseTests{
    @Test(dataProvider = "validLoginData")
    public void loginWithValidDifferentUsers(String username,String password){
        loginPage.loginSuccessfully(username, password);
        HomePage homePage=loginPage.acceptAlertAfterLogin();
        OpenMenu openMenu=homePage.clickOnOpenMenu();
        openMenu.clickOnLogOut();
    }
    @DataProvider(name = "validLoginData")
    public Object[][] loginData(){
        String[] usernames= ReaderFromLoginProperty.getUsers();
        String password= ReaderFromLoginProperty.getPassword();
        Object[][] data=new Object[usernames.length][2];
        for (int i=0;i< usernames.length;i++){
            data[i][0]=usernames[i];
            data[i][1]=password;
        }
        return data;
    }
}
