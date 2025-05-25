package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReaderFromLoginProperty {
    private static String filePath="F:\\Java\\Projects\\Saucedemo\\src\\test\\resources\\login_credentials.properties";
    private static Properties properties=new Properties();
    static {
        try (InputStream input=new FileInputStream(filePath)){
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
    public static String[] getUsers(){
        String usercount=getProperty("userCount");
        int userCount=Integer.parseInt(usercount);
        String[] usernames=new String[userCount];
        for (int i=0;i<userCount;i++){
            usernames[i]=properties.getProperty("user"+(i+1));
        }
        return usernames;
    }
    public static String getPassword(){
        return properties.getProperty("password");
    }
    public static String getvalidUser(){
        return properties.getProperty("user1");
    }


}

