package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
  @NotNull(message = "O nome não pode ser nulo")
  @Size(min = 2, max = 30, message = "O nome deve ter entre 2 e 30 caracteres")
  @Schema(description = "Nome da pessoa", required = true, example = "Hugo Ferreira")
  private String nome;

  @PastOrPresent(message = "A data de nascimento deve ser no passado ou presente")
  @Schema(description = "Data de nascimento da pessoa", example = "2000-01-01")
  private LocalDate dataNascimento;

  @Size(min = 14, max = 14, message = "O cpf deve ter 14 caracteres")
  @Schema(description = "CPF da pessoa", example = "123.456.789-09")
  private String cpf;

  @Email(message = "O email deve ser válido")
  @Schema(description = "Endereço de email da pessoa", example = "nome@example.com")
  private String email;
}
