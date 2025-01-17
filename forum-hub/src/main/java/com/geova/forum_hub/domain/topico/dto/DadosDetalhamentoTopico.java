package com.geova.forum_hub.domain.topico.dto;

import com.geova.forum_hub.domain.status.StatusTopico;
import com.geova.forum_hub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id,
                                      String titulo,
                                      String mensagem,
                                      LocalDateTime dataCriacao,
                                      String autor,
                                      String curso,
                                      StatusTopico status) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getStatus());
    }
}
