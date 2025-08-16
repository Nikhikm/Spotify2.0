package com.Spotify.oauth2.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder
{
    static String accessToken ="BQAXaqsF88yFoCcYM3iEzDBjUW6FGtvVTCFfDkIhr_8RVjm88s4AUsO8p9qOBNsrcIsU84YSQFyovLZa3foLb_e27v8IKoM7iMe_QeT2zhj8rroWpnK5D5Gl9xa3Ve5MMRtH1_QJ1gv_5BCEDp1ljFlbJoahZ7Iw8VLj8MBgtv1DFsK80Ni96E6qebbK85LIiGY1I_PeWzLLvLYyP7esR7koDLe5xSw50dB6-X25HiXr4z_YqeaBivMpP7u-NP3YKnkOhduu0tZ03B9vWnUJ81-BxnKVNjPTcbaVCoqN0ux3dIak-dL3dXXj";

    public static RequestSpecification getRequestSpec()
    {
       return new RequestSpecBuilder().setBaseUri("https://api.spotify.com/").setBasePath("/v1").addHeader("Authorization","Bearer "+ accessToken).setContentType(ContentType.JSON)
            .log(LogDetail.ALL).build();

    }

    public static ResponseSpecification getResponseSpec(){
      return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
