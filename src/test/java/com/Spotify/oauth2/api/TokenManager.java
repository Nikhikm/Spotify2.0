package com.Spotify.oauth2.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
        }
        System.out.println(access_token);
        return access_token;


    }
    private static Response renewToken()
    {
        HashMap<String,String> formparams= new HashMap<String,String>();
        formparams.put("client_id","3a39bb5a8bef4e7fa23f08a5c3206bb2");
        formparams.put("client_secret","8ea2ddd810c04a4f89041dba3a9c15db");
        formparams.put("grant_type","refresh_token");
        formparams.put("refresh_token","AQBRKZEdykaX9sPnYWQZwhnFLjMXf9dhikDpXHCqV5wQDcpQ2dYf7ULoebwS3DbKZ9Ibsq__1MJZRybk_holGM3OqkRFUocxlyVCM3DkWIT_oYR-WI4IdahLfxN3Sza4vkw");

       Response response =RestResource.postaccount(formparams);

       if(response.statusCode()!=200){
           throw new RuntimeException("Renew Token Failed!!!!!");
       }

       return response;


    }
}
