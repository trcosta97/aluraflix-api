package br.com.aluraflix.api.domain.entities.video;

public class VideoFactory {

    private Video video;

    public Video withTitleDescAndUrl(String title, String desc, String url){
        return this.video = new Video(title, desc, url);
    }

    public Video withTitleAndUrl(String title, String url){
        return this.video = new Video(title, "", url);
    }
}
