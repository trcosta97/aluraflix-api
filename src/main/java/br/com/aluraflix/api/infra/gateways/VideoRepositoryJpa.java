package br.com.aluraflix.api.infra.gateways;

import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.domain.entities.video.Video;
import br.com.aluraflix.api.infra.persistence.VideoEntity;
import br.com.aluraflix.api.infra.persistence.VideoRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VideoRepositoryJpa implements VideoRepo {

    private final VideoRepository repository;
    private final VideoMapper mapper;

    public VideoRepositoryJpa(VideoRepository repository, VideoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Video save(Video video) {
        VideoEntity entity = mapper.toEntity(video);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Video get(BigInteger id) throws Exception {
        Optional<VideoEntity> optionalVideo = repository.findById(id);
        if (optionalVideo.isPresent()){
            VideoEntity entity = optionalVideo.get();
            return mapper.toDomain(entity);
        }
        throw new Exception("Video not found");
    }

    @Override
    public Video update(BigInteger id, Video video) throws Exception {
        Optional<VideoEntity> optionalVideo = repository.findById(id);
        if (optionalVideo.isPresent()){
            VideoEntity entity = optionalVideo.get();
            if(video.getTitle() != null){
                entity.setTitle(video.getTitle());
            }
            if(video.getDesc() != null){
                entity.setDesc(video.getDesc());
            }
            if(video.getUrl() != null){
                entity.setUrl(video.getUrl());
            }
            return mapper.toDomain(entity);
        }
        throw new Exception("Video not found");
    }

    @Override
    public List<Video> getAll() {
//        List<VideoEntity> entities =  repository.findAll();
//        List<Video> domainList = new ArrayList<>();
//
//        for (VideoEntity entity : entities){
//            Video domain = mapper.toDomain(entity);
//            domainList.add(domain);
//        }
//        return domainList;

        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(BigInteger id) throws Exception {

    }
}
