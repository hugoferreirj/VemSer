package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
//    @Schema(description = "ID da Pessoa associada a este contato")
//    private Integer idPessoa;

    @JsonIgnore
    private PessoaEntity pessoaEntity;

    @NotNull(message = "O tipo de contato não pode ser nulo")
    @Schema(description = "Tipo de contato", required = true, example = "COMERCIAL")
    private TipoContato tipoContato;

    @NotEmpty(message = "O número do contato não pode estar vazio")
    @Size(min = 13, max = 13, message = "O número do contato deve ter exatamente 13 caracteres")
    @Schema(description = "Número do contato (13 caracteres)", required = true, example = "5512345678901")
    private String numero;

    @NotEmpty(message = "A descrição do contato não pode estar vazia")
    @Schema(description = "Descrição do contato", required = true, example = "Contato principal")
    private String descricao;
}
