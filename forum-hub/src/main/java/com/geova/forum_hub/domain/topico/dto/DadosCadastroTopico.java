package com.geova.forum_hub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        
        @NotBlank
        String titulo,
        
        @NotBlank
        String mensagem,
        
        @NotBlank
        String autor,

        @NotBlank
        String curso) {
}
