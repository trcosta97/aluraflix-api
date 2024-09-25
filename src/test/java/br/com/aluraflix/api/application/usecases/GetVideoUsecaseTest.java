package br.com.aluraflix.api.application.usecases;

import br.com.aluraflix.api.application.gateways.VideoRepo;
import br.com.aluraflix.api.domain.entities.video.Video;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetVideoUsecaseTest {

    @Mock
    private VideoRepo videoRepo;
    @InjectMocks
    private GetVideoUsecase getVideoUsecase;



    @Test
    void shouldRetrieveVideoByIdSuccessfully() throws Exception {
        // Arrange
        BigInteger videoId = BigInteger.valueOf(1);
        Video video = new Video("title", "desc", "https://www.youtube.com/watch?v=o2lUCWxRy7Y");

        // Mocking the behavior of videoRepo.get
        when(videoRepo.get(videoId)).thenReturn(video);

        // Act
        Video result = getVideoUsecase.getVideo(videoId);

        // Assert
        assertEquals(video, result);
        verify(videoRepo, times(1)).get(videoId);
    }

    @Test
    void shouldThrowExceptionWhenVideoNotFound() throws Exception {
        // Arrange
        BigInteger videoId = BigInteger.valueOf(1);

        // Mocking the behavior of videoRepo.get to throw an exception
        when(videoRepo.get(videoId)).thenThrow(new Exception("Video not found"));

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            getVideoUsecase.getVideo(videoId);
        });

        // Verifying the exception message
        assertEquals("Video not found", exception.getMessage());
        verify(videoRepo, times(1)).get(videoId);
    }

}
