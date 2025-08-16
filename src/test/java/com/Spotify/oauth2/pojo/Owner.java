package com.Spotify.oauth2.pojo;

public class Owner
{
    private String spotify;
    private String display_name;
    private String uri;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public ExternalURLs getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(ExternalURLs external_urls) {
        this.external_urls = external_urls;
    }

    private String type;
    private String id;
    private String href;
    private ExternalURLs external_urls;
}
