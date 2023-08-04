package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PessoaService {

    // @Autowired
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;


    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        Pessoa entity = objectMapper.convertValue(pessoa, Pessoa.class);
        entity.setCpf(pessoa.getCpf());
        entity.setNome(pessoa.getNome());
        entity.setDataNascimento(pessoa.getDataNascimento());

        Pessoa pessoa1 = pessoaRepository.create(entity);

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setIdPessoa(pessoa1.getIdPessoa());
        pessoaDTO.setDataNascimento(pessoa1.getDataNascimento());
        pessoaDTO.setCpf(pessoa1.getCpf());
        pessoaDTO.setNome(pessoa1.getNome());

        return pessoaDTO;
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public PessoaDTO update(Integer idPessoa,
                         PessoaDTO pessoaAtualizar) throws RegraDeNegocioException {
        pessoaAtualizar.setIdPessoa(idPessoa);
        Pessoa entity = getPessoa(pessoaAtualizar.getIdPessoa());
        if (entity != null) {
            entity.setCpf(pessoaAtualizar.getCpf());
            entity.setNome(pessoaAtualizar.getNome());
            entity.setDataNascimento(pessoaAtualizar.getDataNascimento());
        }
        return pessoaAtualizar;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = getPessoa(id);
        if (pessoaRecuperada != null) {
            pessoaRepository.delete(pessoaRecuperada);
        }
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

    public Pessoa getPessoa(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }
}
