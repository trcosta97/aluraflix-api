package br.com.aluraflix.api.application.usecases;

import br.com.aluraflix.api.application.gateways.VideoRepo;

import java.math.BigInteger;

public class DeleteVideoUsecase {

    private final VideoRepo videoRepo;

    public DeleteVideoUsecase(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public void deleteVideo(BigInteger id) throws Exception {
        videoRepo.delete(id);
    }

}
