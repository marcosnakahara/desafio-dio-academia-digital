package me.dio.desafio.academiadigital.controller;

import me.dio.desafio.academiadigital.dto.request.AlunoRequestDTO;
import me.dio.desafio.academiadigital.dto.response.AlunoResponseDTO;
import me.dio.desafio.academiadigital.dto.response.builder.AlunoResponseDTOBuilder;
import me.dio.desafio.academiadigital.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<AlunoResponseDTO> getAll(@RequestParam(value = "dataNascimento", required = false)
                                             @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataNascimento) {
        return service.getAll(dataNascimento).stream().map(aluno -> new AlunoResponseDTOBuilder().build(aluno)).collect(Collectors.toList());
    }

    @PostMapping
    public AlunoResponseDTO create(@Valid @RequestBody AlunoRequestDTO aluno) {
        return new AlunoResponseDTOBuilder().build(service.create(aluno));
    }
}
