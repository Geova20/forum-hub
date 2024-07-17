package com.geova.forum_hub.service;

import com.geova.forum_hub.domain.topico.*;
import com.geova.forum_hub.domain.topico.dto.*;
import com.geova.forum_hub.service.exception.DuplicidadeTopicoException;
import com.geova.forum_hub.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    public DadosDetalhamentoCadastroTopico cadastrar(DadosCadastroTopico dados) {
        try {
            validarDuplicidade(dados.mensagem());
            Topico topico = repository.save(new Topico(dados));
            return new DadosDetalhamentoCadastroTopico(topico);
        } catch (EntityNotFoundException e) {
            throw new DuplicidadeTopicoException("Já existe um tópico com o mesmo título ou mensagem. ");
        }
    }

    @Transactional(readOnly = true)
    public Page<DadosListagemTopicos> listar(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemTopicos::new);
    }

    @Transactional(readOnly = true)
    public DadosDetalhamentoTopico detalhar(Long id) {
        try {
            Topico topico = repository.getReferenceById(id);
            return new DadosDetalhamentoTopico(topico);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("ID do tópico inválido. Forneça um ID válido. " + id);
        }
    }

    @Transactional
    public DadosDetalhamentoTopico atualizar(Long id, DadosAtualizacaoTopico dados) {
        try {
            Topico topico = repository.getReferenceById(id);
            topico.setTitulo(dados.titulo());
            topico.setMensagem(dados.mensagem());
            topico = repository.save(topico);
            return new DadosDetalhamentoTopico(topico);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("O ID digitado não é válido. Verifique o ID do tópico e tente novamente. " + id);
        }
    }

    @Transactional
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("O ID digitado não é válido. Verifique o ID do tópico e tente novamente. " + id);
        }
        repository.deleteById(id);
    }

    public void validarDuplicidade(String mensagem) {
        if (repository.existsByMensagem(mensagem)) {
            throw new DuplicidadeTopicoException("Duplicidade detectada! Já existe um tópico com esse título e mensagem. ");
        }
    }
}

