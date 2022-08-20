package me.dio.desafio.academiadigital.dto.response.builder;

import me.dio.desafio.academiadigital.dto.response.AlunoResponseDTO;
import me.dio.desafio.academiadigital.model.Aluno;

import java.time.LocalDate;

public final class AlunoResponseDTOBuilder {

    private Long id;
    private String nome;
    private String cpf;
    private String bairro;
    private LocalDate dataNascimento;

    public AlunoResponseDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public AlunoResponseDTOBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public AlunoResponseDTOBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public AlunoResponseDTOBuilder bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public AlunoResponseDTOBuilder dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public AlunoResponseDTO build() {
        return new AlunoResponseDTO(id, nome, cpf, bairro, dataNascimento);
    }

    public AlunoResponseDTO build(Aluno aluno) {
        return this.id(aluno.getId())
                .nome(aluno.getNome())
                .cpf(aluno.getCpf())
                .bairro(aluno.getBairro())
                .dataNascimento(aluno.getDataNascimento())
                .build();
    }
}
