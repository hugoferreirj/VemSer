package br.com.dbc.vemser.pessoaapi.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaRelatorioDTO {
    private Integer idPessoa;
    private String nome;
    private String email;
    private String numeroContato;
    private String cepEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private String paisEndereco;
    private String nomePet;

    public PessoaRelatorioDTO(Integer idPessoa, String nome, String email, String numeroContato, String cepEndereco, String cidadeEndereco, String estadoEndereco, String paisEndereco, String nomePet) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
        this.numeroContato = numeroContato;
        this.cepEndereco = cepEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.estadoEndereco = estadoEndereco;
        this.paisEndereco = paisEndereco;
        this.nomePet = nomePet;
    }
}
