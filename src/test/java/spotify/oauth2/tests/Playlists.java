package spotify.oauth2.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Playlists
{
    ResponseSpecification responseSpecification;
    RequestSpecification requestSpecification;
    String accessToken ="BQAkonvS5e10o3dbkNBhUpq0xy6aR3KUOTJkY-zR9m9Pk0MNQq1cSGOa6oyIBy8-XraPZVrsdeNEJXEtwF-x80ANGFokl41yY8l0koKD4pZuWY5h1WZsWQOwbCAMV6X_hZEIr99a_MEmXZpdFu3OZjkF-rSlXEHTmCwNlRYGlmP6gWTrNWmzvBKXD_nJend8FM3xvtpJ3QgZRCx2-waZ-uk7P8WdQBmTIdl0LfCji72H2F0BpKW4YI4UmroBqEdwVCGW4EUJTlNEzVaJJ2_BpcYZ6bMjPWnuxX-hDxBgPIa6MDN2LDEHQPX3";

    @BeforeClass
    public void beforeClass()
    {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.spotify.com/").setBasePath("/v1").
        addHeader("Authorization","Bearer "+ accessToken).setContentType(ContentType.JSON)
                .log(LogDetail.ALL);

        requestSpecification= requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.log(LogDetail.ALL);
        responseSpecification=responseSpecBuilder.build();

    }

    @Test
    public void createPlaylist(){
        String payload ="{\n" +
                "    \"name\": \"Nikhils automated API Playlist\",\n" +
                "    \"description\": \"created by nikhil automated\",\n" +
                "    \"public\": false\n" +
                "}";
        given(requestSpecification).body(payload).when().post("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists").then().spec(responseSpecification).
                assertThat().statusCode(201).body("name",equalTo("Nikhils automated API Playlist"),"description",equalTo("created by nikhil automated"));
    }

    @Test
    public void getPlaylist()
    {
        given(requestSpecification).get("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists").then().spec(responseSpecification).
                assertThat().statusCode(200).body("items[0].name",equalTo("Nikhils automated API Playlist"),"items[0].owner.display_name",equalTo("Nikhil"));
    }

    @Test()
    public void updatePlaylist()
    {
        String payload ="{\n" +
                "    \"name\": \"Nikhils automated API Playlist updated1\",\n" +
                "    \"description\": \"Updated playlist description automatically\",\n" +
                "    \"public\": false\n" +
                "}";
        given(requestSpecification).body(payload).put("/playlists/3tfqA8rVJCZ5OOYQmYuwyB").then().spec(responseSpecification).
                assertThat().statusCode(200);
    }

    @Test(dependsOnMethods = "updatePlaylist")
    public void getPlaylistAfterUpdate()
    {
        given(requestSpecification).get("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists").then().spec(responseSpecification).
                assertThat().statusCode(200).body("items[0].name",equalTo("Nikhils automated API Playlist updated1"),"items[0].owner.display_name",equalTo("Nikhil"));
    }

}
