package br.com.aluraflix.api.infra.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_video")
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;
    private String title;
    private String desc;
    private String url;

    public VideoEntity(String title, String desc, String url) {
        this.title = title;
        this.desc = desc;
        this.url = url;
    }
}
