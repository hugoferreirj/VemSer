package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {
    @Schema(description = "ID da Pessoa associada a este endereço")
    private Integer idPessoa;

    @NotNull(message = "O tipo de endereço não pode ser nulo")
    @Schema(description = "Tipo de endereço", required = true, example = "RESIDENCIAL")
    private TipoEndereco tipo;

    @NotEmpty(message = "O logradouro não pode estar vazio")
    @Size(max = 250, message = "O logradouro deve ter no máximo 250 caracteres")
    @Schema(description = "Logradouro do endereço", required = true, example = "Rua Principal")
    private String logradouro;

    @NotNull(message = "O número não pode ser nulo")
    @Schema(description = "Número do endereço", required = true, example = "123")
    private Integer numero;

    @Schema(description = "Complemento do endereço", example = "Bloco A, Apt 101")
    private String complemento;

    @NotEmpty(message = "O CEP não pode estar vazio")
    @Size(max = 8, message = "O CEP deve ter no máximo 8 caracteres")
    @Schema(description = "CEP do endereço", maxLength = 8, required = true, example = "12345678")
    private String cep;

    @NotEmpty(message = "A cidade não pode estar vazia")
    @Size(max = 250, message = "A cidade deve ter no máximo 250 caracteres")
    @Schema(description = "Cidade do endereço", maxLength = 250, required = true, example = "São Paulo")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo")
    @Schema(description = "Estado do endereço", required = true, example = "SP")
    private String estado;

    @NotNull(message = "O país não pode ser nulo")
    @Schema(description = "País do endereço", required = true, example = "Brasil")
    private String pais;

    @JsonIgnore
    private Set<PessoaEntity> pessoas;
}
