package me.dio.desafio.academiadigital.service;

import me.dio.desafio.academiadigital.dto.request.AlunoRequestDTO;
import me.dio.desafio.academiadigital.model.Aluno;
import me.dio.desafio.academiadigital.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno create(AlunoRequestDTO aluno) {
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(aluno.getNome());
        novoAluno.setCpf(aluno.getCpf());
        novoAluno.setBairro(aluno.getBairro());
        novoAluno.setDataNascimento(aluno.getDataNascimento());

        return repository.save(novoAluno);
    }

    public Aluno findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Aluno> getAll(LocalDate dataNascimento) {

        if(dataNascimento == null) {
            return repository.findAll();
        } else {
            return repository.findByDataNascimento(dataNascimento);
        }
    }
}
