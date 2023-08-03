package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "Rua das Flores", 123, "Casa 1", "12345-678", "Cidade A", "Estado A", "Pais A"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.COMERCIAL, "Avenida Principal", 987, "Sala 2", "98765-432", "Cidade B", "Estado B", "Pais B"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.RESIDENCIAL, "Rua do Sol", 456, null, "54321-876", "Cidade C", "Estado C", "Pais C"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 4, TipoEndereco.RESIDENCIAL, "Avenida Central", 789, "Bloco 3", "13579-246", "Cidade D", "Estado D", "Pais D"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 5, TipoEndereco.COMERCIAL, "Rua das Palmeiras", 321, "Loja 4", "86420-159", "Cidade E", "Estado E", "Pais E"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.COMERCIAL, "Avenida da Praia", 555, "Andar 10", "98765-432", "Cidade F", "Estado F", "Pais F"));

    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }

    public List<Endereco> listByPessoa(Integer idPessoa) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa() == idPessoa)
                .collect(Collectors.toList());
    }

    public List<Endereco> listByEndereco(Integer idEndereco) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco()== idEndereco)
                .collect(Collectors.toList());
    }
}
