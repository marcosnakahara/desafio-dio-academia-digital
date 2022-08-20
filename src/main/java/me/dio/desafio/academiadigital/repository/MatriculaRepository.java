package me.dio.desafio.academiadigital.repository;

import me.dio.desafio.academiadigital.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    public List<Matricula> findByAlunoBairro(String bairro);
}
