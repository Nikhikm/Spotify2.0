package spotify.oauth2.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class Playlists
{
    ResponseSpecification responseSpecification;
    RequestSpecification requestSpecification;

    @BeforeClass
    public void beforeClass()
    {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.spotify.com/").setBasePath("/v1").
        addHeader("Authorization","Bearer ").setContentType(ContentType.JSON)
                .log(LogDetail.ALL);

        requestSpecification= requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON).log(LogDetail.ALL);
        responseSpecification=responseSpecBuilder.build();

    }
}
