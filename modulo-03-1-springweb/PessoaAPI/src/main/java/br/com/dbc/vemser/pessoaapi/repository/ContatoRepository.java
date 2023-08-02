package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.RESIDENCIAL, "1234567890", "Telefone residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "comercial@example.com", "E-mail comercial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "9876543210", "Celular residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.RESIDENCIAL, "9876543210", null));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, TipoContato.COMERCIAL, "5555555555", "Telefone comercial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, TipoContato.COMERCIAL, "9998887776", ""));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }


    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> listByPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa() == idPessoa)
                .collect(Collectors.toList());
    }
}
