package br.com.aluraflix.api.application.usecases;


import br.com.aluraflix.api.application.gateways.VideoRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteVideoUsecaseTest {
    @Mock
    private VideoRepo videoRepo;

    @InjectMocks
    private DeleteVideoUsecase deleteVideoUsecase;

    @Test
    void shouldDeleteVideoSuccessfully() throws Exception {
        // Arrange
        BigInteger videoId = BigInteger.valueOf(1);

        // No need to mock the return value since delete does not return anything
        doNothing().when(videoRepo).delete(videoId);

        // Act
        deleteVideoUsecase.deleteVideo(videoId);

        // Assert
        verify(videoRepo, times(1)).delete(videoId);
    }

    @Test
    void shouldThrowExceptionWhenVideoNotFound() throws Exception {

        // Arrange
        BigInteger videoId = BigInteger.valueOf(1);

        // Mocking the behavior to throw an exception when trying to delete a non-existent video
        doThrow(new Exception("Video not found")).when(videoRepo).delete(videoId);

        // Act & Assert
        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(Exception.class, () -> {
            deleteVideoUsecase.deleteVideo(videoId);
        });

        // Verifying that the exception message is correct
        org.junit.jupiter.api.Assertions.assertEquals("Video not found", exception.getMessage());
        verify(videoRepo, times(1)).delete(videoId);
    }
}
