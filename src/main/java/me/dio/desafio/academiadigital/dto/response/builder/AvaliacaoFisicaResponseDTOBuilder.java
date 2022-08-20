package me.dio.desafio.academiadigital.dto.response.builder;

import me.dio.desafio.academiadigital.dto.response.AlunoResponseDTO;
import me.dio.desafio.academiadigital.dto.response.AvaliacaoFisicaResponseDTO;
import me.dio.desafio.academiadigital.model.Aluno;
import me.dio.desafio.academiadigital.model.AvaliacaoFisica;

import java.time.LocalDateTime;

public final class AvaliacaoFisicaResponseDTOBuilder {

    private Long id;
    private AlunoResponseDTO aluno;
    private LocalDateTime dataAvaliacao;
    private Double peso;
    private Double altura;

    public AvaliacaoFisicaResponseDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public AvaliacaoFisicaResponseDTOBuilder aluno(Aluno aluno) {
        this.aluno = new AlunoResponseDTOBuilder()
                .id(aluno.getId())
                .build();
        return this;
    }

    public AvaliacaoFisicaResponseDTOBuilder dataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
        return this;
    }

    public AvaliacaoFisicaResponseDTOBuilder peso(Double peso) {
        this.peso = peso;
        return this;
    }

    public AvaliacaoFisicaResponseDTOBuilder altura(Double altura) {
        this.altura = altura;
        return this;
    }

    public AvaliacaoFisicaResponseDTO build() {
        return new AvaliacaoFisicaResponseDTO(id, aluno, dataAvaliacao, peso, altura);
    }

    public AvaliacaoFisicaResponseDTO build(AvaliacaoFisica avaliacao) {
        return this.id(avaliacao.getId())
                .aluno(avaliacao.getAluno())
                .dataAvaliacao(avaliacao.getDataAvaliacao())
                .peso(avaliacao.getPeso())
                .altura(avaliacao.getAltura())
                .build();
    }
}
