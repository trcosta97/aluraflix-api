package br.com.aluraflix.api.application.usecases;

import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.domain.entities.video.Video;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetAllVideoUsecaseTest {

    @Mock
    private VideoRepo videoRepo;
    @InjectMocks
    private GetAllVideosUsecase getAllVideosUsecase;

    @Test
    void ShouldRetrieveAllVideosSuccessfully(){

        Video video = new Video("title", "desc", "https://www.youtube.com/watch?v=o2lUCWxRy7Y");
        Video video2 = new Video("title", "desc", "https://www.youtube.com/watch?v=o2lUCWxRy7Y");
        List<Video> videos = new ArrayList<>();
        videos.add(video);
        videos.add(video2);

        when(videoRepo.getAll()).thenReturn(videos);

        List<Video> result = getAllVideosUsecase.getAll();

        assertEquals(videos, result);
        verify(videoRepo, times(1)).getAll();

    }

}
