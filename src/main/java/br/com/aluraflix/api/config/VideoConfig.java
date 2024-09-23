package br.com.aluraflix.api.config;


import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.application.usecases.*;
import br.com.aluraflix.api.infra.gateways.VideoMapper;
import br.com.aluraflix.api.infra.gateways.VideoRepositoryJpa;
import br.com.aluraflix.api.infra.persistence.VideoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoConfig {

    @Bean
    VideoRepositoryJpa createVideoRepositoryJpa(VideoRepository repository, VideoMapper mapper){
        return new VideoRepositoryJpa(repository, mapper);
    }

    @Bean
    VideoMapper createVideoMapper(){
        return new VideoMapper();
    }

    @Bean
    SaveVideoUsecase createSaveVideoUsecase(VideoRepo videoRepo){
        return new SaveVideoUsecase(videoRepo);
    }

    @Bean
    DeleteVideoUsecase createDeleteVideoUsecase(VideoRepo videoRepo){
        return new DeleteVideoUsecase(videoRepo);
    }

    @Bean
    GetAllVideosUsecase createGetAllVideoUsecase(VideoRepo videoRepo){
        return new GetAllVideosUsecase(videoRepo);
    }

    @Bean
    GetVideoUsecase createGetVideoUsecase(VideoRepo videoRepo){
        return new GetVideoUsecase(videoRepo);
    }

    @Bean
    UpdateVideoUsecase createUpdateVideoUsecase(VideoRepo videoRepo){
        return new UpdateVideoUsecase(videoRepo);
    }
}
