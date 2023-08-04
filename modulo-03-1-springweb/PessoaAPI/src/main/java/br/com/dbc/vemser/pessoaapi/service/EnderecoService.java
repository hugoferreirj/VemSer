package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;


    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        if (pessoaService.getPessoa(idPessoa) != null) {
            Endereco entity = objectMapper.convertValue(endereco, Endereco.class);
            entity.setIdPessoa(idPessoa);

            Endereco enderecoCriado = enderecoRepository.create(entity);
            EnderecoDTO enderecoDTO = new EnderecoDTO();
            enderecoDTO.setIdEndereco(enderecoCriado.getIdEndereco());
            enderecoDTO.setCep(enderecoCriado.getCep());
            enderecoDTO.setCidade(enderecoCriado.getCidade());
            enderecoDTO.setEstado(enderecoCriado.getEstado());
            enderecoDTO.setComplemento(enderecoCriado.getComplemento());
            enderecoDTO.setNumero(enderecoCriado.getNumero());
            enderecoDTO.setPais(enderecoCriado.getPais());
            enderecoDTO.setLogradouro(enderecoCriado.getLogradouro());
            enderecoDTO.setTipo(enderecoCriado.getTipo());
            enderecoDTO.setIdPessoa(enderecoCriado.getIdPessoa());

            return enderecoDTO;
        } else {
            return null;
        }
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        enderecoAtualizar.setIdEndereco(idEndereco);
        Endereco entity = getEndereco(enderecoAtualizar.getIdEndereco());
        if (entity != null) {
            entity.setTipo(enderecoAtualizar.getTipo());
            entity.setIdPessoa(enderecoAtualizar.getIdPessoa());
            entity.setLogradouro(enderecoAtualizar.getLogradouro());
            entity.setNumero(enderecoAtualizar.getNumero());
            entity.setComplemento(enderecoAtualizar.getComplemento());
            entity.setCep(enderecoAtualizar.getCep());
            entity.setCidade(enderecoAtualizar.getCidade());
            entity.setEstado(enderecoAtualizar.getEstado());
            entity.setPais(enderecoAtualizar.getPais());
        }
        return enderecoAtualizar;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = getEndereco(id);
        if (enderecoRecuperado != null) {
            enderecoRepository.delete(enderecoRecuperado);
        }
    }

    public List<Endereco> listByPessoa(Integer idPessoa) {
        return enderecoRepository.listByPessoa(idPessoa);
    }

    public List<Endereco> listByEndereco(Integer idPessoa) {
        return enderecoRepository.listByEndereco(idPessoa);
    }

    private Endereco getEndereco(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return enderecoRecuperado;
    }
}
