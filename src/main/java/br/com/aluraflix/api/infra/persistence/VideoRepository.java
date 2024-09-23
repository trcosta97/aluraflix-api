package br.com.aluraflix.api.infra.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface VideoRepository extends JpaRepository<VideoEntity, BigInteger> {


}
