package com.geova.forum_hub.controller;

import com.geova.forum_hub.domain.topico.*;
import com.geova.forum_hub.domain.topico.dto.*;
import com.geova.forum_hub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoCadastroTopico> cadastrar(@RequestBody DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {

        var dadosDetalhamentoCadastroTopico = service.cadastrar(dados);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dadosDetalhamentoCadastroTopico.id()).toUri();

        return ResponseEntity.created(uri).body(dadosDetalhamentoCadastroTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(@PageableDefault(sort = {"dataCriacao"},
            direction = Sort.Direction.ASC) Pageable pageable) {
        Page <DadosListagemTopicos> page = service.listar(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        DadosDetalhamentoTopico dadosDetalhamentoTopico = service.detalhar(id);
        return ResponseEntity.ok(dadosDetalhamentoTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        DadosDetalhamentoTopico dadosDetalhamentoTopico = service.atualizar(id, dados);
        return ResponseEntity.ok(dadosDetalhamentoTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
      service.excluir(id);
      return ResponseEntity.noContent().build();
    }
    
}
