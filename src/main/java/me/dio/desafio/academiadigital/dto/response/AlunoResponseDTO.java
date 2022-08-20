package me.dio.desafio.academiadigital.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.desafio.academiadigital.annotation.LocalDateFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String bairro;
    @LocalDateFormat
    private LocalDate dataNascimento;
}
