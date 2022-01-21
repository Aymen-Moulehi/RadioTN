package com.aymen.radiotn;

import java.io.Serializable;

public class Radio {
    static int statId = 0 ;
    int id;
    String name ;
    Boolean favorite = false ;
    String imageURL ;
    String audioUrl ;

    public Radio(String name, String imageURL, String audioUrl) {
        this.name = name;
        this.imageURL = imageURL;
        this.audioUrl = audioUrl;
        Radio.statId += 1 ;
        this.id = Radio.statId ;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }
}
