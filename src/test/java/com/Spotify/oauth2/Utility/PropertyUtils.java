package com.Spotify.oauth2.Utility;

import java.io.*;
import java.util.Properties;

public class PropertyUtils
{
    public static Properties propertyLoader(String filepath) throws FileNotFoundException
    {
        Properties prop = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filepath));
            try{
                prop.load(reader);
                reader.close();
            }catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load property file"+filepath);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Properties file not found at "+filepath);
        }
        return prop;
    }
}
