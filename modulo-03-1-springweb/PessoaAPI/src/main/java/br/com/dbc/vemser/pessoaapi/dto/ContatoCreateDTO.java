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
    @NotNull
    private TipoContato tipoContato;
    @NotEmpty
    @Size(min = 13, max = 13)
    private String numero;
    @NotEmpty
    private String descricao;
}
