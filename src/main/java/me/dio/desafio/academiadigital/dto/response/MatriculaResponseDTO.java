package me.dio.desafio.academiadigital.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.desafio.academiadigital.annotation.LocalDateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaResponseDTO {

    private Long id;
    private AlunoResponseDTO aluno;
    @LocalDateTimeFormat
    private LocalDateTime dataMatricula;
}
