package br.com.aluraflix.api.application.gateways;

import br.com.aluraflix.api.domain.entities.video.Video;

import java.math.BigInteger;
import java.util.List;

public interface VideoRepo {

   Video save(Video video);
   Video get(BigInteger id) throws Exception;
   Video update(BigInteger id, Video video) throws  Exception;
   List<Video> getAll();
   void delete(BigInteger id) throws Exception;
}
