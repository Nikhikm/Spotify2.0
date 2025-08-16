package com.Spotify.oauth2.api;

import com.Spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
//import static jdk.internal.vm.vector.VectorSupport.extract;
//import static jdk.internal.vm.vector.VectorSupport.extract;


public class RestResource {
  //  static String accessToken ="BQDouFMIxHyaRgbqc0qIctPVNFW-t6UdgsMXThxvC7DK5B2JFf2ht-0XsVtIDvvjohakrV4mBwGqbjqnKmHJZ1B7YHy2T6kbPXZBu3UdgcDnnNXYqDD-2g4Hm5gDVmCXHLBkkxEPS8XcKLihjilSoLlW_CCpPiNv4rLxP0l4E0-bW-1nj4TaG0dCbbyNqiJ5llRmKZ1Hl3de7AFq-YoBBITj2YYE1jnZFqj0ywDAO7WFUO3UZOBFiKRqgCQ_py5OFwt_0FRx0-9D7_qkOa5vVtNPvJlDBZbUkee0Fg1D-4N7NG0BUewKq_Ac";

    public static Response post(Object CreatePlaylistPayload, String path,String accessToken) {
      return given(SpecBuilder.getRequestSpec())
                .body(CreatePlaylistPayload)
                .header("Authorization","Bearer "+ accessToken)
                .when().post(path)
                .then().spec(SpecBuilder.getResponseSpec())
               .extract().response();

      //  post("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists")
    }

    public static Response get(String PlaylistID,String path,String accessToken)
    {
        return given(SpecBuilder.getRequestSpec()).header("Authorization","Bearer "+ accessToken).get(path).then().spec(SpecBuilder.getResponseSpec()).
                extract().response();
       // get("/users/31ckskvxosw7e3koqevgzakvm7vi/playlists/"+PlaylistID)

    }

    public static Response update(Object CreatePlaylistPayload,String PlaylistID,String path,String accessToken){
       return given(SpecBuilder.getRequestSpec()).header("Authorization","Bearer "+ accessToken).body(CreatePlaylistPayload).put(path).then().spec(SpecBuilder.getResponseSpec()).
                assertThat().extract().response();

    //    put("/playlists/"
    }


}