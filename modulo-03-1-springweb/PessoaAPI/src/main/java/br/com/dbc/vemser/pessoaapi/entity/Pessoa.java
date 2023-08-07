package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Pessoa {

    private Integer idPessoa;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 2, max = 30, message = "O nome deve ter entre 2 e 30 caracteres")
    private String nome;

    @PastOrPresent(message = "A data de nascimento deve ser no passado ou presente")
    private LocalDate dataNascimento;

    @CPF(message = "CPF inválido")
    private String cpf;

    @Email(message = "O email deve ser válido")
    private String email;
}
