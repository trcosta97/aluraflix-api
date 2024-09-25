package br.com.aluraflix.api.infra.gateways;

import br.com.aluraflix.api.infra.persistence.VideoEntity;
import br.com.aluraflix.api.infra.persistence.VideoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class VideoRepositoryJpaTest {

    @Autowired
    private VideoRepository repository;


    @Test
    void shouldPersistAndGenerateIdSuccessfully() {
        VideoEntity video = new VideoEntity(
                "Teste",
                "Descricao",
                "https://www.youtube.com/watch?v=T6ChO8LQxRE");


        VideoEntity result = repository.save(video);

        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(video, result);
    }

    @Test
    void ShouldGetListSizeOfVideosSuccessfully(){
        VideoEntity entity1 = new VideoEntity("Teste", "Desc", "https://www.youtube.com/watch?v=T6ChO8LQxRE");
        VideoEntity entity2 = new VideoEntity("Teste2", "Desc2", "https://www.youtube.com/watch?v=o2lUCWxRy7Y");

        repository.save(entity1);
        repository.save(entity2);

        List<VideoEntity> result = repository.findAll();

        Assertions.assertEquals(2, result.size());
    }


    @Test
    void ShouldDeleteSuccessfully(){
        VideoEntity entity = new VideoEntity("Teste", "Desc", "https://www.youtube.com/watch?v=T6ChO8LQxRE");

        VideoEntity result = repository.save(entity);
        List<VideoEntity> beforeDelete = repository.findAll();

        Assertions.assertEquals(1, beforeDelete.size());

        repository.deleteById(result.getId());
        List<VideoEntity> afterDelete = repository.findAll();

        Assertions.assertEquals(0, afterDelete.size());

    }
}
