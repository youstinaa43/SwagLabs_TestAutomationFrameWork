package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReaderFromUtilityProperty {
    private static String filePath="F:\\Java\\Projects\\Saucedemo\\src\\test\\resources\\utility.properties";
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
    public static String getInvalidUser(){
        return properties.getProperty("invaliduser");
    }
    public static String getInvalidPassword(){
        return properties.getProperty("invalidpass");
    }
    public static String getZipCode(){
        return properties.getProperty("zipCode");
    }
    public static String getFirstName(){
        return properties.getProperty("firstName");
    }
    public static String getLastName(){
        return properties.getProperty("lastName");
    }
    public static String getProductName(String productNo){
        return properties.getProperty("product"+productNo);
    }

}

