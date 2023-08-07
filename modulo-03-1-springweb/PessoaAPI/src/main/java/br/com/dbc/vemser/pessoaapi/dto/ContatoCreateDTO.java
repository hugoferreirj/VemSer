package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
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
    private Integer idPessoa;

    @NotNull(message = "O tipo de contato não pode ser nulo")
    private TipoContato tipoContato;

    @NotEmpty(message = "O número do contato não pode estar vazio")
    @Size(min = 13, max = 13, message = "O número do contato deve ter exatamente 13 caracteres")
    private String numero;

    @NotEmpty(message = "A descrição do contato não pode estar vazia")
    private String descricao;
}
