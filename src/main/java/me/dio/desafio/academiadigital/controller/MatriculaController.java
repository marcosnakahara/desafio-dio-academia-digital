package me.dio.desafio.academiadigital.controller;

import me.dio.desafio.academiadigital.dto.response.MatriculaResponseDTO;
import me.dio.desafio.academiadigital.dto.response.builder.MatriculaResponseDTOBuilder;
import me.dio.desafio.academiadigital.dto.request.MatriculaRequestDTO;
import me.dio.desafio.academiadigital.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @GetMapping
    public List<MatriculaResponseDTO> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro).stream().map(matricula -> new MatriculaResponseDTOBuilder().build(matricula)).collect(Collectors.toList());
    }

    @PostMapping
    public MatriculaResponseDTO create(@Valid @RequestBody MatriculaRequestDTO matricula) {
        return new MatriculaResponseDTOBuilder().build(service.create(matricula));
    }
}
