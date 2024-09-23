package br.com.aluraflix.api.infra.controller.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateVideoRequest(
        @NotBlank
        String title,
        String desc,
        @NotBlank
        String url) {
}
