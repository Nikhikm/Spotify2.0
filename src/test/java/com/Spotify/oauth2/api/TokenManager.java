package com.Spotify.oauth2.api;

import com.Spotify.oauth2.Utility.ConfigLoader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TokenManager
{
   private static String access_token;
   private static Instant expire_Time;

    public static String getToken()
    {
        try {
            if (access_token == null || Instant.now().isAfter(expire_Time)) {
                System.out.println("renewing Token");
                Response response = renewToken();
                 access_token = response.path("access_token");
                System.out.println(access_token);
                int expireDurationInSeconds = response.path("expires_in");
                expire_Time = Instant.now().plusSeconds(expireDurationInSeconds - 300);
            } else {
                System.out.println("Token Good to use!!!!!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Renew Token failed!!!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(access_token);
        return access_token;


    }
    private static Response renewToken() throws FileNotFoundException {
        HashMap<String,String> formparams= new HashMap<String,String>();
        formparams.put("client_id", ConfigLoader.getInstance().getClientID());
        formparams.put("client_secret",ConfigLoader.getInstance().getClientSecret());
        formparams.put("grant_type",ConfigLoader.getInstance().getGrandTyoe());
        formparams.put("refresh_token",ConfigLoader.getInstance().getRefreshToken());

       Response response =RestResource.postaccount(formparams);

       if(response.statusCode()!=200){
           throw new RuntimeException("Renew Token Failed!!!!!");
       }

       return response;


    }
}
