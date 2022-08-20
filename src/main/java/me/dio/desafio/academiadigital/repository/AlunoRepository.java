package me.dio.desafio.academiadigital.repository;

import me.dio.desafio.academiadigital.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public List<Aluno> findByDataNascimento(LocalDate dataNascimento);
}