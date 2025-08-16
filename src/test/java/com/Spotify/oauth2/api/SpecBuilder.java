package com.Spotify.oauth2.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder
{
    static String accessToken ="BQB-VgEkYFFxGKrs4fyiQ5j3njNZUuyQOPMxK5lcbEE06rd76C0GAF7r0Q9h0ocGPlhH90fkvwI-mX2dorLf3f6dtSBfMlLsnGUzdvpx5ArtFsC5FzqTF-4qb3Nig9yNiFcFhSPX1GaArkJzjfnXqcZB6oehYhawRGfHxnIwa2BWyHYqjbcsgtBbdOkUVhckcUzqFgTYFaSFnNcM2HQb3QLeLLmZ9vHh-cDlDSJfwd4hqxfOfskohh8RS1QPqkrHDmCIGRxQzjkFCjwbOZoTB5cjMpgcASdoBvN8LsdcA2SAz9iuwL0goR9J";

    public static RequestSpecification getRequestSpec()
    {
       return new RequestSpecBuilder().setBaseUri("https://api.spotify.com/").setBasePath("/v1").setContentType(ContentType.JSON)
            .log(LogDetail.ALL).build();

    }

    public static ResponseSpecification getResponseSpec(){
      return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
