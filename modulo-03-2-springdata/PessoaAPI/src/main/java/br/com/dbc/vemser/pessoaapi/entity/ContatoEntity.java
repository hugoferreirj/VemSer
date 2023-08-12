package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CONTATO")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

//    @Column(name = "id_pessoa")
//    private Integer idPessoa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoaEntity;

    @NotNull(message = "O tipo de contato não pode ser nulo")
    @Column(name = "tipo")
    private TipoContato tipoContato;

    @NotEmpty(message = "O número do contato não pode estar vazio")
    @Size(min = 13, max = 13, message = "O número do contato deve ter exatamente 13 caracteres")
    @Column(name = "numero")
    private String numero;

    @NotEmpty(message = "A descrição do contato não pode estar vazia")
    @Column(name = "descricao")
    private String descricao;

}
