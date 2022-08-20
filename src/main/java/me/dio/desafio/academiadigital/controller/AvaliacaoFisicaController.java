package me.dio.desafio.academiadigital.controller;

import me.dio.desafio.academiadigital.dto.request.AvaliacaoFisicaRequestDTO;
import me.dio.desafio.academiadigital.dto.response.AvaliacaoFisicaResponseDTO;
import me.dio.desafio.academiadigital.dto.response.builder.AvaliacaoFisicaResponseDTOBuilder;
import me.dio.desafio.academiadigital.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService service;

    @GetMapping
    public List<AvaliacaoFisicaResponseDTO> getAll() {
        return service.getAll().stream().map(avaliacao -> new AvaliacaoFisicaResponseDTOBuilder().build(avaliacao)).collect(Collectors.toList());
    }

    @GetMapping("/aluno/{id}")
    public List<AvaliacaoFisicaResponseDTO> getAllByAlunoId(@PathVariable Long id) {
        return  service.getAvaliacaoFisicaByAlunoId(id).stream().map(avaliacao -> new AvaliacaoFisicaResponseDTOBuilder().build(avaliacao)).collect(Collectors.toList());
    }

    @PostMapping
    public AvaliacaoFisicaResponseDTO create(@Valid @RequestBody AvaliacaoFisicaRequestDTO avaliacao) {
        return new AvaliacaoFisicaResponseDTOBuilder().build(service.create(avaliacao));
    }
}
