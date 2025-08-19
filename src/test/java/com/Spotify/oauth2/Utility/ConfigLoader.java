package com.Spotify.oauth2.Utility;

import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigLoader
{
    private final Properties prop;
    private static ConfigLoader configLoader;

    private ConfigLoader() throws FileNotFoundException {
        prop = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() throws FileNotFoundException {
        if(configLoader==null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientID(){
       String properties = prop.getProperty("client_id");
       if(properties!=null){
           return properties;
       }
       else {
           throw new RuntimeException("Client ID Property is not configured");
       }

    }

    public String getClientSecret(){
        String properties = prop.getProperty("client_secret");
        if(properties!=null){
            return properties;
        }
        else {
            throw new RuntimeException("Client secret Property is not configured");
        }

    }

    public String getGrandTyoe(){
    String properties = prop.getProperty("grant_type");
    if(properties!=null){
        return properties;
    }
    else {
        throw new RuntimeException("Grant type Property is not configured");
    }

}

    public String getRefreshToken(){
        String properties = prop.getProperty("refresh_token");
        if(properties!=null){
            return properties;
        }
        else {
            throw new RuntimeException("Refresh Token Property is not configured");
        }

    } public String getUserID(){
    String properties = prop.getProperty("user_id");
    if(properties!=null){
        return properties;
    }
    else {
        throw new RuntimeException("User ID Property is not configured");
    }

}



}
