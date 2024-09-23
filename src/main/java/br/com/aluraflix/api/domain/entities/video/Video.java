package br.com.aluraflix.api.domain.entities.video;

import java.math.BigInteger;

public class Video {
    private BigInteger id;
    private String title;
    private String desc;
    private String url;

    public boolean isValidUrl(String url){
        String youtubeRegex = "^https?://(www\\.)?(youtube\\.com|youtu\\.be)/.+$";
        return url.matches(youtubeRegex);
    }
    public Video(){};

    public Video(BigInteger id, String title, String desc, String url) {
        if(!isValidUrl(url)){
            throw new IllegalArgumentException("Url inválida");
        }
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public Video(String title, String desc, String url) {
        if(!isValidUrl(url)){
            throw new IllegalArgumentException("Url inválida");
        }
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public BigInteger getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
