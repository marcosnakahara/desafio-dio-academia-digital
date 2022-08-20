package me.dio.desafio.academiadigital.service;

import me.dio.desafio.academiadigital.dto.request.MatriculaRequestDTO;
import me.dio.desafio.academiadigital.model.Aluno;
import me.dio.desafio.academiadigital.model.Matricula;
import me.dio.desafio.academiadigital.repository.AlunoRepository;
import me.dio.desafio.academiadigital.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public Matricula create(MatriculaRequestDTO matricula) {

        Optional<Aluno> optionalAluno = alunoRepository.findById(matricula.getAlunoId());

        if (optionalAluno.isPresent()) {

            Matricula novaMatricula = new Matricula();
            novaMatricula.setAluno(optionalAluno.get());

            return matriculaRepository.save(novaMatricula);
        }
        return null;
    }

    public Matricula findById(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    public List<Matricula> getAll(String bairro) {

        if(bairro != null && !bairro.isEmpty()) {
            return matriculaRepository.findByAlunoBairro(bairro);
        } else {
            return matriculaRepository.findAll();
        }
    }
}
