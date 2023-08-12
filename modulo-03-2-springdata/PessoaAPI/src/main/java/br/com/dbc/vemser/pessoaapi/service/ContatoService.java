package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;


    public ContatoDTO create(ContatoCreateDTO contato, Integer idPessoa) throws RegraDeNegocioException {
        if (pessoaService.findById(idPessoa) != null) {
            ContatoEntity entity = objectMapper.convertValue(contato, ContatoEntity.class);
//            entity.setIdPessoa(idPessoa);
            entity.setPessoaEntity(pessoaService.findById(idPessoa));

            ContatoEntity contatoCriado = contatoRepository.save(entity);
            ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);

            return contatoDTO;
        } else {
            return null;
        }
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer idContato,
                             ContatoDTO contatoAtualizar) throws RegraDeNegocioException {
        contatoAtualizar.setIdContato(idContato);
        ContatoEntity entity = getContato(contatoAtualizar.getIdContato());
        if (entity != null) {
            entity.setTipoContato(contatoAtualizar.getTipoContato());
//            entity.setIdPessoa(contatoAtualizar.getIdPessoa());
            entity.setPessoaEntity(contatoAtualizar.getPessoaEntity());
            entity.setDescricao(contatoAtualizar.getDescricao());
            entity.setNumero(contatoAtualizar.getNumero());
            contatoRepository.save((entity));
        }
        return contatoAtualizar;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoRecuperado = getContato(id);
        if (contatoRecuperado != null) {
            contatoRepository.delete(contatoRecuperado);
        }
    }

    public List<ContatoDTO> listByPessoa(Integer idPessoa) throws EntidadeNaoEncontradaException {
        return contatoRepository.findByPessoaEntity(pessoaService.returnPersonById(idPessoa)).stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    private ContatoEntity getContato(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoRecuperado = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoRecuperado;
    }

    public ContatoDTO retornarDTO(ContatoEntity entity) {
        return objectMapper.convertValue(entity, ContatoDTO.class);
    }

}
