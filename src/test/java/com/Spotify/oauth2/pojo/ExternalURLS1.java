package com.Spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ExternalURLS1
{
    public String getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(String external_urls) {
        this.external_urls = external_urls;
    }

    private String external_urls;
}
