package me.dio.desafio.academiadigital.service;

import me.dio.desafio.academiadigital.dto.request.AvaliacaoFisicaRequestDTO;
import me.dio.desafio.academiadigital.dto.response.AvaliacaoFisicaResponseDTO;
import me.dio.desafio.academiadigital.model.Aluno;
import me.dio.desafio.academiadigital.model.AvaliacaoFisica;
import me.dio.desafio.academiadigital.repository.AlunoRepository;
import me.dio.desafio.academiadigital.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public AvaliacaoFisica create(AvaliacaoFisicaRequestDTO avaliacao) {

        Optional<Aluno> optionalAluno = alunoRepository.findById(avaliacao.getAlunoId());

        if (optionalAluno.isPresent()) {
            AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica();
            novaAvaliacao.setAluno(optionalAluno.get());
            novaAvaliacao.setPeso(avaliacao.getPeso());
            novaAvaliacao.setAltura(avaliacao.getAltura());

            return avaliacaoRepository.save(novaAvaliacao);
        }
        return null;
    }

    public AvaliacaoFisica findById(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public List<AvaliacaoFisica> getAll() {
        return avaliacaoRepository.findAll();
    }

    public List<AvaliacaoFisica> getAvaliacaoFisicaByAlunoId(Long id) {

        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (optionalAluno.isPresent()) {
            return optionalAluno.get().getAvaliacoes();
        }
        return new ArrayList<>();
    }
}
