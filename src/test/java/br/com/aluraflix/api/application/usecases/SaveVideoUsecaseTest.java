package br.com.aluraflix.api.application.usecases;

import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.domain.entities.video.Video;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveVideoUsecaseTest {

    @Mock
    private VideoRepo videoRepo;

    @InjectMocks
    private SaveVideoUsecase saveVideoUsecase;

    @Test
    void shouldSaveVideoSuccessfully() {
        // Arrange
        Video video = new Video("title","desc", "https://www.youtube.com/watch?v=o2lUCWxRy7Y");
        when(videoRepo.save(video)).thenReturn(video);

        // Act
        Video result = saveVideoUsecase.createVideo(video);

        // Assert
        assertEquals(video, result);
        verify(videoRepo, times(1)).save(video);
    }

}

