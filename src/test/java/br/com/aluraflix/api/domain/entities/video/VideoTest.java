package br.com.aluraflix.api.domain.entities.video;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class VideoTest {

    @Test
    public void shouldntSaveWithInvalidUrl(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->new Video(new BigInteger("87656789"),
                        "Test Video",
                        "Video with invalid url",
                        "http://vimeo.com/jknvjdnbjkdf"));
    }

    @Test
    public void shouldSaveWithValidUrl(){
        Video testVideo = new Video(new BigInteger("87226789"),
                            "Test Video",
                            "Video with valid url=",
                            "https://www.youtube.com/watch?v=HFlxEM6zZsc");

        Assertions.assertEquals("https://www.youtube.com/watch?v=HFlxEM6zZsc",
                testVideo.getUrl());
    }

    @Test
    public void shouldSaveWithFactoryWithoutDesc(){
        VideoFactory factory = new VideoFactory();
        Video videoTest = factory.withTitleAndUrl("Test Video",
                "https://www.youtube.com/watch?v=HFlxEM6zZsc");

        Assertions.assertEquals("Test Video", videoTest.getTitle());

        Assertions.assertEquals("", videoTest.getDesc());
    }

}
