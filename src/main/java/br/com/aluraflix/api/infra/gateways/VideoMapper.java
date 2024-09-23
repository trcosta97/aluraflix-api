package br.com.aluraflix.api.infra.gateways;

import br.com.aluraflix.api.domain.entities.video.Video;
import br.com.aluraflix.api.infra.persistence.VideoEntity;

public class VideoMapper {

    public VideoEntity toEntity(Video video){
        return new VideoEntity(video.getTitle(), video.getDesc(), video.getUrl());
    }

    public Video toDomain(VideoEntity entity){
        return new Video(entity.getTitle(), entity.getDesc(), entity.getUrl());
    }
}
