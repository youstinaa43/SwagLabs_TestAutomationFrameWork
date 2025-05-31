import actions.BrowserActions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.OpenMenu;
import utility.ReaderFromLoginProperty;

public class TC_001_TestLogin extends BaseTests{
    @Test(dataProvider = "validLoginData")
    public void loginWithDifferentUsers(String username,String password){
        HomePage homePage=loginPage.loginSuccessfully(username, password);
        BrowserActions.navigateBack();
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
