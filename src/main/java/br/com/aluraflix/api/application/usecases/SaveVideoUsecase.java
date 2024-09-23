package br.com.aluraflix.api.application.usecases;

import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.domain.entities.video.Video;

public class SaveVideoUsecase {

    private final VideoRepo videoRepo;

    public SaveVideoUsecase(VideoRepo videoRepo){
        this.videoRepo = videoRepo;
    }

    public Video createVideo(Video video){
        return videoRepo.save(video);
    }
}
