package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class UsuarioDTO {
    @NotNull
    private String login;
    @NotNull
    private String senha;

    private Set<Integer> cargos;
}
