package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 2, max = 30, message = "O nome deve ter entre 2 e 30 caracteres")
    @Column(name = "nome")
    private String nome;

    @PastOrPresent(message = "A data de nascimento deve ser no passado ou presente")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @CPF(message = "CPF inválido")
    @Column(name = "cpf")
    private String cpf;

    @Email(message = "O email deve ser válido")
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<EnderecoEntity> enderecos;

    @OneToMany(mappedBy = "pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @OneToOne(mappedBy = "pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private PetEntity pet;
}
