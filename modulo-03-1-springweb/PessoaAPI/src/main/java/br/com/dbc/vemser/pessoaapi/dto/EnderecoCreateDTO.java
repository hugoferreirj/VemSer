package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {
    private Integer idPessoa;
    @NotNull(message = "O tipo de endereço não pode ser nulo")
    private TipoEndereco tipo;

    @NotEmpty(message = "O logradouro não pode estar vazio")
    @Size(max = 250, message = "O logradouro deve ter no máximo 250 caracteres")
    private String logradouro;

    @NotNull(message = "O número não pode ser nulo")
    private Integer numero;

    private String complemento;

    @NotEmpty(message = "O CEP não pode estar vazio")
    @Size(max = 8, message = "O CEP deve ter no máximo 8 caracteres")
    private String cep;

    @NotEmpty(message = "A cidade não pode estar vazia")
    @Size(max = 250, message = "A cidade deve ter no máximo 250 caracteres")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo")
    private String estado;

    @NotNull(message = "O país não pode ser nulo")
    private String pais;
}
