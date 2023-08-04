package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;


    public ContatoDTO create(ContatoCreateDTO contato, Integer idPessoa) throws RegraDeNegocioException {
        if (pessoaService.getPessoa(idPessoa) != null) {
            Contato entity = objectMapper.convertValue(contato, Contato.class);
            entity.setIdPessoa(idPessoa);

            Contato contatoCriado = contatoRepository.create(entity);
            ContatoDTO contatoDTO = new ContatoDTO();
            contatoDTO.setIdContato(contatoCriado.getIdContato());
            contatoDTO.setTipoContato(contatoCriado.getTipoContato());
            contatoDTO.setNumero(contatoCriado.getNumero());
            contatoDTO.setIdPessoa(contatoCriado.getIdPessoa());
            contatoDTO.setDescricao(contatoCriado.getDescricao());

            return contatoDTO;
        } else {
            return null;
        }
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public ContatoDTO update(Integer idContato,
                             ContatoDTO contatoAtualizar) throws RegraDeNegocioException {
        contatoAtualizar.setIdContato(idContato);
        Contato entity = getContato(contatoAtualizar.getIdContato());
        if (entity != null) {
            entity.setTipoContato(contatoAtualizar.getTipoContato());
            entity.setIdPessoa(contatoAtualizar.getIdPessoa());
            entity.setDescricao(contatoAtualizar.getDescricao());
            entity.setNumero(contatoAtualizar.getNumero());
        }
        return contatoAtualizar;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = getContato(id);
        if (contatoRecuperado != null) {
            contatoRepository.delete(contatoRecuperado);
        }
    }

    public List<Contato> listByPessoa(Integer idPessoa) {
        return contatoRepository.listByPessoa(idPessoa);
    }

    private Contato getContato(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }
}
