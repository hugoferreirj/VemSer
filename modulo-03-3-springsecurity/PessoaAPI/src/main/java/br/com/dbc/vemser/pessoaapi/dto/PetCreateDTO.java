package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PetCreateDTO {

//    private Integer idPessoa;

    @JsonIgnore
    private PessoaEntity pessoaEntity;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    @Schema(description = "Nome do pet", required = true, example = "Nick")
    private String nome;

    @NotNull(message = "O tipo de pet não pode ser nulo")
    private TipoPet tipoPet;


}
