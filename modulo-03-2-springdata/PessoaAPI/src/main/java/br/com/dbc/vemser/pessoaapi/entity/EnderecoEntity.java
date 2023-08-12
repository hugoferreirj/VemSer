package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    //@Column(name = "id_pessoa")
//    private Integer idPessoa;

    @NotNull(message = "O tipo de endereço não pode ser nulo")
    @Column(name = "tipo")
    private TipoEndereco tipo;

    @NotEmpty(message = "O logradouro não pode estar vazio")
    @Size(max = 250, message = "O logradouro deve ter no máximo 250 caracteres")
    @Column(name = "logradouro")
    private String logradouro;

    @NotNull(message = "O número não pode ser nulo")
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @NotEmpty(message = "O CEP não pode estar vazio")
    @Size(max = 8, message = "O CEP deve ter no máximo 8 caracteres")
    @Column(name = "cep")
    private String cep;

    @NotEmpty(message = "A cidade não pode estar vazia")
    @Size(max = 250, message = "A cidade deve ter no máximo 250 caracteres")
    @Column(name = "cidade")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo")
    @Column(name = "estado")
    private String estado;

    @NotNull(message = "O país não pode ser nulo")
    @Column(name = "pais")
    private String pais;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;
}
