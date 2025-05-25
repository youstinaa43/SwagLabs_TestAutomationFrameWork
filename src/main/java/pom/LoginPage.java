package pom;

import actions.ElementActions;
import dev.failsafe.internal.util.Assert;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoginPage {
    String userNameID="user-name";
    String passwordID="password";
    String loginID="login-button";
    String acceptedUsers="div.login_credentials";
    String validPassword="div.login_password";
    ElementActions elementActions;
    public LoginPage( ){
        this.elementActions=new ElementActions();
    }
    public List<String> getValidUserNames(){
        List<String> usernames=new ArrayList<>();
        try {
            String credentialText=elementActions.getElementText(acceptedUsers, ElementActions.Locators.css);
            String[] userNamesSplit=credentialText.split("\n");
            for (int i=1;i< userNamesSplit.length;i++){
                String userName=userNamesSplit[i].trim();
                if(!userName.isEmpty()){
                    usernames.add(userName);
                }
            }
        }catch (Exception e){
            throw new RuntimeException("Failed to extract usernames ",e);
        }
        return usernames;
    }
    public String getValidPassword(){
        try {
            String credentialText=elementActions.getElementText(validPassword, ElementActions.Locators.css);
            String[] passwordsSplit=credentialText.split("\n");
                if(passwordsSplit.length>=2){
                    return passwordsSplit[1];
                }

        }catch (Exception e){
            throw new RuntimeException("Failed to extract password ",e);
        }
        return "";
    }
    public void saveCredentialsInProperty(String filePath) throws IOException {
        Properties proper=new Properties();
        List<String> usernames=getValidUserNames();
        String password=getValidPassword();
        proper.setProperty("userCount", String.valueOf(usernames.size()));
        for(int i=0;i<usernames.size();i++){
            proper.setProperty("user"+(i+1),usernames.get(i));
        }
        proper.setProperty("password",password);
        try (FileOutputStream writer=new FileOutputStream(filePath)){
            proper.store(writer,"SauceDemo Login Credentials");
        }
    }
    public void loginSuccessfully(String username,String password) {
        elementActions.sendText(userNameID, ElementActions.Locators.id,username);
        elementActions.sendText(passwordID, ElementActions.Locators.id,password);
        elementActions.clickOnElement(loginID, ElementActions.Locators.id);
    }
    public HomePage acceptAlertAfterLogin(){
        //elementActions.acceptAlert();
        return new HomePage();
    }



}
