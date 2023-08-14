package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final DadosPessoaisClient dadosPessoaisClient;

    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity pessoaEntity = converterDTO(pessoa);
        return retornarDTO(pessoaRepository.save(pessoaEntity));
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não encontrada"));
        return entity;
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        PessoaEntity pessoaEntityRecuperada = returnPersonById(id);

        pessoaEntityRecuperada.setCpf(pessoaDto.getCpf());
        pessoaEntityRecuperada.setEmail(pessoaDto.getEmail());
        pessoaEntityRecuperada.setDataNascimento(pessoaDto.getDataNascimento());
        pessoaEntityRecuperada.setNome(pessoaDto.getNome());

        return retornarDTO(pessoaRepository.save(pessoaEntityRecuperada));
    }

    public void delete(Integer id) {
        try {
            PessoaEntity pessoaEntityRecuperada = returnPersonById(id);
            pessoaRepository.delete(pessoaEntityRecuperada);
        } catch (EntidadeNaoEncontradaException ex) {
            ex.printStackTrace();
        }
    }

    public PessoaEntity returnPersonById(Integer id) throws EntidadeNaoEncontradaException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public PessoaEntity converterDTO(PessoaCreateDTO dto) {
        return objectMapper.convertValue(dto, PessoaEntity.class);
    }

    public PessoaDTO retornarDTO(PessoaEntity entity) {
        return objectMapper.convertValue(entity, PessoaDTO.class);
    }

    public List<PessoaDTO> findAllByNomeContains(String nome) {
        return pessoaRepository.findAllByNomeContains(nome).stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }


    public List<PessoaPetDTO> findAllWithPetsOrByIdPessoa(Integer id) {
        return pessoaRepository.findAllWithPetsOrByIdPessoa(id).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaPetDTO.class))
                .collect(Collectors.toList());
    }


    public List<PessoaContatosDTO> findAllWithContatosOrByIdPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findAllWithContatosOrByIdPessoa(id).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaContatosDTO.class))
                .collect(Collectors.toList());

    }


    public List<PessoaEnderecosDTO> findAllWithEnderecosOrByIdPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findAllWithEnderecosOrByIdPessoa(id).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaEnderecosDTO.class))
                .collect(Collectors.toList());
    }

}
