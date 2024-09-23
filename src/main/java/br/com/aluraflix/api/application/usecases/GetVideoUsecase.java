package br.com.aluraflix.api.application.usecases;

import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.domain.entities.video.Video;

import java.math.BigInteger;

public class GetVideoUsecase {

    private final VideoRepo videoRepo;

    public GetVideoUsecase(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public Video getVideo(BigInteger id) throws Exception {
        return this.videoRepo.get(id);
    }
}
