package com.Spotify.oauth2.tests;

import com.Spotify.oauth2.api.ApplicationAPI;
import com.Spotify.oauth2.api.SpecBuilder;
import com.Spotify.oauth2.pojo.GetPlaylist;
import com.Spotify.oauth2.pojo.Playlist;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Playlists
{
    ResponseSpecification responseSpecification;
    static String PlaylistID="";
    RequestSpecification requestSpecification;
//    String accessToken ="BQB9oD1KGgIL1__SccSkWAjGgwmhKqrspfwaAsCZVXpvnmQZvve_JdmMj61vTdleScYsKpIZPJ0JxXpyHSW8Zbx4E697T8hL1q-0zjfHBXYrqwplHoMZSt9m8m_2cl7PZ8hCglkNyHMQwQ6gF7VWUSddbilJ7G-4ue7JUVF4DDi_emiqWbTUvFCrk1ai97X6RSgczfLPmH4QJBB6MOy6zrSnIMDAskTlJYmtJb4i5_yFKWEpn6MdPrKEw1QU5hlD8SHNOKFtm6RJk-zHhiaO_TNFa_JMfWMqqF708rGRhBLt7kvKqgMxDrpg";
//
//    @BeforeClass
//    public void beforeClass()
//    {
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        requestSpecBuilder.setBaseUri("https://api.spotify.com/").setBasePath("/v1").
//        addHeader("Authorization","Bearer "+ accessToken).setContentType(ContentType.JSON)
//                .log(LogDetail.ALL);
//
//        requestSpecification= requestSpecBuilder.build();
//
//        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
//        responseSpecBuilder.log(LogDetail.ALL);
//        responseSpecification=responseSpecBuilder.build();
//
//    }

    public Playlist playlistBuilder(String name , String description){
        return new Playlist()
                .setName(name).setDescription(description);

    }

    public void assertPlaylist(Playlist responsePlaylists,Playlist CreatePlaylistPayload){
        assertThat(responsePlaylists.getName(),equalTo(CreatePlaylistPayload.getName()));
        assertThat(responsePlaylists.getDescription(),equalTo(CreatePlaylistPayload.getDescription()));


    }

    @Test
    public void createPlaylist() throws FileNotFoundException {

        //####################the below line is commented due to implementation of playlistBuilder##############
//        Playlist CreatePlaylistPayload = new Playlist();
//        CreatePlaylistPayload.setName("New Nikhils Automated playlist77");
//        CreatePlaylistPayload.setDescription("created by Nikhil1");

        //####################the above line is commented due to implementation of playlistBuilder##############

        Playlist CreatePlaylistPayload = playlistBuilder("New Nikhils Automated playlist77", "created by Nikhil1");


//        Playlist responsePlaylists = given(SpecBuilder.getRequestSpec()).body(CreatePlaylistPayload).when().post("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists").then().spec(SpecBuilder.getResponseSpec()).
//                assertThat().statusCode(201).extract().response().as(Playlist.class);
//        assertThat(responsePlaylists.getName(),equalTo(CreatePlaylistPayload.getName()));
//        assertThat(responsePlaylists.getDescription(),equalTo(CreatePlaylistPayload.getDescription()));
//
//        PlaylistID =responsePlaylists.getId();
//        System.out.println(PlaylistID);
//        //assertThat(responsePlaylists.get,equalTo(CreatePlaylistPayload.getPublic()));

        Response response = ApplicationAPI.post(CreatePlaylistPayload);
        assertThat(response.statusCode(),equalTo(201));
        Playlist responsePlaylists= response.as(Playlist.class);

        PlaylistID =responsePlaylists.getId();
        System.out.println(PlaylistID);

//        assertThat(responsePlaylists.getName(),equalTo(CreatePlaylistPayload.getName()));
//        assertThat(responsePlaylists.getDescription(),equalTo(CreatePlaylistPayload.getDescription()));
        //###above line is commented and used below code#############

        assertPlaylist(response.as(Playlist.class),CreatePlaylistPayload);


    }

    @Test
    public void getPlaylist() throws FileNotFoundException {
//        GetPlaylist responseGetPlaylist = given(SpecBuilder.getRequestSpec()).get("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists").then().spec(SpecBuilder.getResponseSpec()).
//                assertThat().statusCode(200).extract().response().as(GetPlaylist.class);
       // int lastindex = responseGetPlaylist.getItems().size() - 1;


        Response response = ApplicationAPI.get(PlaylistID);
        assertThat(response.statusCode(),equalTo(200));
        Playlist responseGetPlaylist =response.as(Playlist.class);

        assertThat(responseGetPlaylist.getName(),is(equalTo("New Nikhils Automated playlist77")));

    }

    @Test()
    public void updatePlaylist()
    {
        System.out.println(PlaylistID);

      Playlist CreatePlaylistPayload = playlistBuilder("New Nikhils Automated playlist updated55","created by Nikhil1");
//####################the below line is commented due to implementation of playlistBuilder##############
//        Playlist CreatePlaylistPayload = new Playlist();
//        CreatePlaylistPayload.setName("New Nikhils Automated playlist updated55");
//        CreatePlaylistPayload.setDescription("created by Nikhil1");

        //####################the above line is commented due to implementation of playlistBuilder##############


       Response response= ApplicationAPI.update(CreatePlaylistPayload,PlaylistID);
       assertThat(response.statusCode(),equalTo(200));

//        given(SpecBuilder.getRequestSpec()).body(CreatePlaylistPayload).put("/playlists/"+PlaylistID).then().spec(responseSpecification).
//                assertThat().statusCode(200);
    }

    @Test(dependsOnMethods = "updatePlaylist")
    public void getPlaylistAfterUpdate() throws FileNotFoundException {
        Response response = ApplicationAPI.get(PlaylistID);
        assertThat(response.statusCode(),equalTo(200));
        Playlist responseGetPlaylist =response.as(Playlist.class);

        assertThat(responseGetPlaylist.getName(),is(equalTo("New Nikhils Automated playlist updated55")));
//        GetPlaylist respose = given(SpecBuilder.getRequestSpec()).get("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists").then().spec(responseSpecification).
//                assertThat().statusCode(200).extract().response().as(GetPlaylist.class);
//        assertThat(respose.getItems(),hasItem(hasProperty("name",is(equalTo("New Nikhils Automated playlist updated5")))));
    }

}
