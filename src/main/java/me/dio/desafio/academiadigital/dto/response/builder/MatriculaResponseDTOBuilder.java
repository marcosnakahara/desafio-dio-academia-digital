package me.dio.desafio.academiadigital.dto.response.builder;

import me.dio.desafio.academiadigital.dto.response.AlunoResponseDTO;
import me.dio.desafio.academiadigital.dto.response.MatriculaResponseDTO;
import me.dio.desafio.academiadigital.model.Aluno;
import me.dio.desafio.academiadigital.model.Matricula;

import java.time.LocalDateTime;

public class MatriculaResponseDTOBuilder {

    private Long id;
    private AlunoResponseDTO aluno;
    private LocalDateTime dataMatricula;

    public MatriculaResponseDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public MatriculaResponseDTOBuilder aluno(Aluno aluno) {
        this.aluno = new AlunoResponseDTOBuilder().id(aluno.getId()).build();
        return this;
    }

    public MatriculaResponseDTOBuilder dataMatricula(LocalDateTime dataMatricula) {
        this.dataMatricula = dataMatricula;
        return this;
    }

    public MatriculaResponseDTO build() {
        return new MatriculaResponseDTO(id, aluno, dataMatricula);
    }

    public MatriculaResponseDTO build(Matricula matricula) {
        return this.id(matricula.getId())
                .aluno(matricula.getAluno())
                .dataMatricula(matricula.getDataMatricula())
                .build();
    }
}
