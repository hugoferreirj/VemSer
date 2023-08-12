package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;


//    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
//        PessoaEntity pessoa = pessoaService.findById(idPessoa);
//        if (pessoa != null) {
//            EnderecoEntity entity = objectMapper.convertValue(endereco, EnderecoEntity.class);
//
//
//            try {
//                emailService.enviarEmailSobreEnderecoUtilizandoTemplate(pessoa, "Um endereço foi criado e associado a sua conta!");
//            } catch (MessagingException e) {
//                throw new RuntimeException(e);
//            }
//
//            EnderecoEntity enderecoCriado = enderecoRepository.save(entity);
//            EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
//
//            return enderecoDTO;
//        } else {
//            return null;
//        }
//    }

    public EnderecoDTO create(EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        EnderecoEntity entity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.save(entity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);

        return enderecoDTO;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        enderecoAtualizar.setIdEndereco(idEndereco);
        EnderecoEntity entity = getEndereco(enderecoAtualizar.getIdEndereco());
        if (entity != null) {
            entity.setTipo(enderecoAtualizar.getTipo());
            entity.setLogradouro(enderecoAtualizar.getLogradouro());
            entity.setNumero(enderecoAtualizar.getNumero());
            entity.setComplemento(enderecoAtualizar.getComplemento());
            entity.setCep(enderecoAtualizar.getCep());
            entity.setCidade(enderecoAtualizar.getCidade());
            entity.setEstado(enderecoAtualizar.getEstado());
            entity.setPais(enderecoAtualizar.getPais());
            enderecoRepository.save(entity);

//            PessoaEntity pessoa = pessoaService.findById(entity.getIdPessoa());
//
//            try {
//                emailService.enviarEmailSobreEnderecoUtilizandoTemplate(pessoa, "O endereço " + idEndereco + " associado à sua conta foi alterado!");
//            } catch (MessagingException e) {
//                throw new RuntimeException(e);
//            }
        }
        return enderecoAtualizar;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = getEndereco(id);
        if (enderecoRecuperado != null) {
            enderecoRepository.delete(enderecoRecuperado);
//            PessoaEntity pessoa = pessoaService.findById(enderecoRecuperado.getIdPessoa());
//            try {
//                emailService.enviarEmailSobreEnderecoUtilizandoTemplate(pessoa, "O endereço " + id + " associado à sua conta foi excluido!");
//            } catch (MessagingException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

//    public List<EnderecoDTO> listByPessoa(Integer idPessoa) {
//        return enderecoRepository.findAll().stream()
//                .filter(endereco -> endereco.getIdPessoa() == idPessoa)
//                .map(this::retornarDTO)
//                .collect(Collectors.toList());
//    }

    private EnderecoEntity getEndereco(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoRecuperado;
    }

    public EnderecoDTO retornarDTO(EnderecoEntity entity) {
        return objectMapper.convertValue(entity, EnderecoDTO.class);
    }
}
