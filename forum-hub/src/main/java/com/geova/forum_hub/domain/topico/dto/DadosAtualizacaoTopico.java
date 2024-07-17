package com.geova.forum_hub.domain.topico.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizacaoTopico(
        @NotNull
        String titulo,

        @NotNull
        String mensagem,

        @NotNull
        String autor,

        @NotNull
        LocalDateTime data_criacao
) {
}
