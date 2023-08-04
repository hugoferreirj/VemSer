package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Pessoa {

    private Integer idPessoa;
    @NotNull
    @Size(min=2, max=30)
    private String nome;
    @PastOrPresent
    private LocalDate dataNascimento;

    private String cpf;
}
