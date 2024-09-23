package br.com.aluraflix.api.application.usecases;

import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.domain.entities.video.Video;

import java.util.List;

public class GetAllVideosUsecase {

    private final VideoRepo videoRepo;

    public GetAllVideosUsecase(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public List<Video> getAll(){
        return videoRepo.getAll();
    }
}
