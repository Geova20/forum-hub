package com.geova.forum_hub.domain.topico.dto;

import com.geova.forum_hub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoCadastroTopico(
        Long id,
        String titulo,
        String curso,
        String mensagem,
        String autor,
        LocalDateTime data_Criacao) {

    public DadosDetalhamentoCadastroTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getCurso(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getDataCriacao());
    }
}
