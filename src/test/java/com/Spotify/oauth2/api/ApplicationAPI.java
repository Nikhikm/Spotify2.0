package com.Spotify.oauth2.api;

import com.Spotify.oauth2.pojo.GetPlaylist;
import com.Spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

import static com.Spotify.oauth2.api.Route.PLAYLISTS;
import static com.Spotify.oauth2.api.TokenManager.getToken;
//import static com.Spotify.oauth2.api.TokenManager.renewToken;
import static io.restassured.RestAssured.given;
//import static jdk.internal.vm.vector.VectorSupport.extract;
//import static jdk.internal.vm.vector.VectorSupport.extract;
import java.util.Vector;

public class ApplicationAPI {
  //  static String accessToken ="BQASBZ5OndWhSbF1Jbukooacn-tMAbCYEyDwPVlGRjKWszzoAzH5pcl8IRQJDxntm8Z_QGbcqgRSrGV3s5NmY4QDx03bpMVxhW_vFyJSVlBITuVRt6zwXZM7atTFRgN1xadqkTFI82W1enbQQL0Rb20JRrE1rXtJBodFOHCFx4YOPfK8K9wvzQkCqQ0CHW-fS4Do5wCPV3BnbbWXFh3bfkTSLfosXO2OnKJI5Stim9J4oCAiLOg3XR63K0klVH8te-EY0JBEkmxhWC0hgWQCtPgI8NabHSpgexyuWWuP7mdhLAremwLjacSe";
    public static Response post(Playlist CreatePlaylistPayload) {

        return RestResource.post(CreatePlaylistPayload,"/users/31ckskvxosw7e3koqevgzakvm7vi"+PLAYLISTS,getToken());
//      return given(SpecBuilder.getRequestSpec())
//                .body(CreatePlaylistPayload)
//                .header("Authorization","Bearer "+ accessToken)
//                .when().post("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists")
//                .then().spec(SpecBuilder.getResponseSpec())
//               .extract().response();
    }

    public static Response get(String PlaylistID)
    {
        return RestResource.get(PlaylistID,"/users/31ckskvxosw7e3koqevgzakvm7vi"+PLAYLISTS+PlaylistID,getToken());
//        return given(SpecBuilder.getRequestSpec()).header("Authorization","Bearer "+ accessToken).get("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists/"+PlaylistID).then().spec(SpecBuilder.getResponseSpec()).
//                extract().response();
    }

    public static Response update(Playlist CreatePlaylistPayload,String PlaylistID){
        return RestResource.update(CreatePlaylistPayload,PlaylistID,PLAYLISTS+PlaylistID,getToken());
//       return given(SpecBuilder.getRequestSpec()).header("Authorization","Bearer "+ accessToken).body(CreatePlaylistPayload).put("/playlists/"+PlaylistID).then().spec(SpecBuilder.getResponseSpec()).
//                assertThat().extract().response();
    }


}