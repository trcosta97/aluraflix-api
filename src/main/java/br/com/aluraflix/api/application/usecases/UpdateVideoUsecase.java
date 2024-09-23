package br.com.aluraflix.api.application.usecases;

import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.domain.entities.video.Video;

import java.math.BigInteger;

public class UpdateVideoUsecase {

    private final VideoRepo videoRepo;


    public UpdateVideoUsecase(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public Video updateVideo(BigInteger id, Video video) throws Exception {
        return videoRepo.update(id, video);
    }
}
