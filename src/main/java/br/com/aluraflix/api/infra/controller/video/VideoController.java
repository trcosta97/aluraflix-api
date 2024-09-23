package br.com.aluraflix.api.infra.controller.video;

import br.com.aluraflix.api.application.usecases.*;
import br.com.aluraflix.api.domain.entities.video.Video;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    private final SaveVideoUsecase saveVideoUsecase;
    private final GetVideoUsecase getVideoUsecase;
    private final GetAllVideosUsecase getAllVideosUsecase;
    private final UpdateVideoUsecase updateVideoUsecase;
    private final DeleteVideoUsecase deleteVideoUsecase;

    public VideoController(SaveVideoUsecase saveVideoUsecase, GetVideoUsecase getVideoUsecase, GetAllVideosUsecase getAllVideosUsecase, UpdateVideoUsecase updateVideoUsecase, DeleteVideoUsecase deleteVideoUsecase) {
        this.saveVideoUsecase = saveVideoUsecase;
        this.getVideoUsecase = getVideoUsecase;
        this.getAllVideosUsecase = getAllVideosUsecase;
        this.updateVideoUsecase = updateVideoUsecase;
        this.deleteVideoUsecase = deleteVideoUsecase;
    }

    @PostMapping
    public VideoResponse saveVideo(@RequestBody @Valid CreateVideoRequest request){
        Video savedVideo = saveVideoUsecase.createVideo(new Video(request.title(), request.desc(), request.url()));
        return new VideoResponse(savedVideo.getTitle(), savedVideo.getDesc(), savedVideo.getUrl());
    }

    @GetMapping("/{id}")
    public VideoResponse getVideo(@PathVariable BigInteger id) throws Exception {
        Video video = getVideoUsecase.getVideo(id);
        return new VideoResponse(video.getTitle(), video.getDesc(), video.getUrl());
    }

    @GetMapping
    public List<VideoResponse> getAllVideos(){
        List<Video> videos = getAllVideosUsecase.getAll();
        List<VideoResponse> responses = new ArrayList<>();

        for(Video video : videos){
            VideoResponse response = new VideoResponse(video.getTitle(), video.getDesc(), video.getUrl());
            responses.add(response);
        }
        return responses;
    }

    @PutMapping("/{id}")
    public VideoResponse updateVideo(@PathVariable BigInteger id, @RequestBody @Valid CreateVideoRequest request ) throws Exception {
        Video video = new Video(request.title(), request.desc(), request.url());
        Video updatedVideo = updateVideoUsecase.updateVideo(id, video);
        return new VideoResponse(updatedVideo.getTitle(), updatedVideo.getDesc(), updatedVideo.getUrl());
    }

    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable BigInteger id) throws Exception {
        deleteVideoUsecase.deleteVideo(id);
    }
}
