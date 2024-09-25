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
class UpdateVideoUsecaseTest {

    @Mock
    private VideoRepo videoRepo;

    @InjectMocks
    private UpdateVideoUsecase updateVideoUsecase;

    @Test
    void shouldUpdateVideoSuccessfully() throws Exception {
        // Arrange
        BigInteger videoId = BigInteger.valueOf(1);
        Video existingVideo = new Video("Original Title", "Original Desc", "https://www.youtube.com/watch?v=original");
        Video updatedVideo = new Video("Updated Title", "Updated Desc", "https://www.youtube.com/watch?v=updated");

        when(videoRepo.update(videoId, updatedVideo)).thenReturn(updatedVideo);

        // Act
        Video result = updateVideoUsecase.updateVideo(videoId, updatedVideo);

        // Assert
        assertEquals(updatedVideo, result);
        verify(videoRepo, times(1)).update(videoId, updatedVideo);
    }

    @Test
    void shouldThrowExceptionWhenVideoNotFound() throws Exception {
        // Arrange
        BigInteger videoId = BigInteger.valueOf(1);
        Video updatedVideo = new Video("Updated Title", "Updated Desc", "https://www.youtube.com/watch?v=updated");

        // Simula uma exceção quando o vídeo não é encontrado
        when(videoRepo.update(videoId, updatedVideo)).thenThrow(new Exception("Video not found"));

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            updateVideoUsecase.updateVideo(videoId, updatedVideo);
        });

        assertEquals("Video not found", exception.getMessage());
        verify(videoRepo, times(1)).update(videoId, updatedVideo);
    }
}
